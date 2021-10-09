package br.com.alura.livraria.service;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;

import br.com.alura.livraria.entities.Autor;

import br.com.alura.livraria.repositories.AutorRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<AutorDto> listar() {
        List<Autor> autores = autorRepository.findAll();
        return autores.stream().map(x -> modelMapper.map(x, AutorDto.class))
                .collect(Collectors.toList());
    }

    public void cadastrar(@RequestBody AutorFormDto autorFormDto) {
        Autor autor = modelMapper.map(autorFormDto, Autor.class);
        autorRepository.save(autor);
    }
}
