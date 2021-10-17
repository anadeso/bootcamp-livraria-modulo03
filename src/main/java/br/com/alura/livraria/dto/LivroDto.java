package br.com.alura.livraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LivroDto {

    private Long id;
    private String titulo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    private int numeroPagina;

    private AutorDto autor;
}
