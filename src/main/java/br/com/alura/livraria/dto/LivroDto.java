package br.com.alura.livraria.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LivroDto {

    private Long id;
    private String titulo;
    private LocalDate dataLancamento;
    private int numeroPagina;
    private AutorDto autor;
}
