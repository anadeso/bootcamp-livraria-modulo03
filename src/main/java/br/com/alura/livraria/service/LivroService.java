package br.com.alura.livraria.service;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;

import br.com.alura.livraria.modelo.Livro;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private List<Livro> livros = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<LivroDto> listar() {
        List<LivroDto> collect = livros.stream()
                .map(x -> modelMapper.map(x, LivroDto.class))
                .collect(Collectors.toList());

        return collect;
    }

    public void cadastrar(LivroFormDto livroFormDto) {
        Livro livro = modelMapper.map(livroFormDto, Livro.class);

        livros.add(livro);
    }
}
