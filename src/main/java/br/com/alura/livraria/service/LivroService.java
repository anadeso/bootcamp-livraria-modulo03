package br.com.alura.livraria.service;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;

import br.com.alura.livraria.entities.Livro;

import br.com.alura.livraria.repositories.LivroRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public List<LivroDto> listar() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(x -> modelMapper.map(x, LivroDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void cadastrar(LivroFormDto livroFormDto) {
        Livro livro = modelMapper.map(livroFormDto, Livro.class);
        livro.setId(null);
        livroRepository.save(livro);
    }
}
