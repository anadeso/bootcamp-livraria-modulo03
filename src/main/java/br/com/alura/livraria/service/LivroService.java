package br.com.alura.livraria.service;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;

import br.com.alura.livraria.entities.Autor;
import br.com.alura.livraria.entities.Livro;

import br.com.alura.livraria.repositories.AutorRepository;
import br.com.alura.livraria.repositories.LivroRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public Page<LivroDto> listar(Pageable paginacao) {
        Page<Livro> livros = livroRepository.findAll(paginacao);
        return livros.map(x -> modelMapper.map(x, LivroDto.class));
    }

    @Transactional
    public LivroDto cadastrar(LivroFormDto livroFormDto) {
        Livro livro = modelMapper.map(livroFormDto, Livro.class);
        Autor autor = autorRepository.getById(livroFormDto.getAutorId());

        livro.setId(null);
        livro.setAutor(autor);
        livroRepository.save(livro);

        return modelMapper.map(livro, LivroDto.class);
    }
}
