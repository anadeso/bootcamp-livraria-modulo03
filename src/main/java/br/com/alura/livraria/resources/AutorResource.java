package br.com.alura.livraria.resources;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;

import br.com.alura.livraria.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorResource {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public Page<AutorDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return autorService.listar(paginacao);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid AutorFormDto autorFormDto) {
        autorService.cadastrar(autorFormDto);
    }
}
