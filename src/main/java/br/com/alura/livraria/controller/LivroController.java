package br.com.alura.livraria.controller;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;
import br.com.alura.livraria.service.AutorService;
import br.com.alura.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<LivroDto> listar() {
        return livroService.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid LivroFormDto livroFormDto) {
        livroService.cadastrar(livroFormDto);
    }
}
