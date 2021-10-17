package br.com.alura.livraria.service;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.entities.Autor;

import br.com.alura.livraria.entities.Livro;
import br.com.alura.livraria.repositories.AutorRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public Page<AutorDto> listar(Pageable paginacao) {
        Page<Autor> autores = autorRepository.findAll(paginacao);
        return autores.map(x -> modelMapper.map(x, AutorDto.class));
    }

    @Transactional
    public AutorDto cadastrar(@RequestBody AutorFormDto autorFormDto) {
        Autor autor = modelMapper.map(autorFormDto, Autor.class);
        autor.setId(null);
        autorRepository.save(autor);
        return modelMapper.map(autor, AutorDto.class);
    }
}
