package br.com.alura.livraria.service;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;

import br.com.alura.livraria.modelo.Autor;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private List<Autor> autores = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<AutorDto> listar() {
        return autores.stream()
                .map(x -> modelMapper.map(x, AutorDto.class))
                .collect(Collectors.toList());
    }

    public void cadastrar(@RequestBody AutorFormDto autorFormDto) {
        Autor autor = modelMapper.map(autorFormDto, Autor.class);

        autores.add(autor);
    }
}
