package br.com.alura.livraria.controller;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;

import br.com.alura.livraria.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorDto> listar() {
        return autorService.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid AutorFormDto autorFormDto) {
        autorService.cadastrar(autorFormDto);
    }
}
