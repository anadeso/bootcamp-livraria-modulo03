package br.com.alura.livraria.resources;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorResource {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<Page<AutorDto>> listar(Pageable pageable) {
        Page<AutorDto> list = autorService.listar(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorFormDto autorFormDto) {
        AutorDto autorDto = autorService.cadastrar(autorFormDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(autorDto.getId()).toUri();
        return ResponseEntity.created(uri).body(autorDto);
    }
}
