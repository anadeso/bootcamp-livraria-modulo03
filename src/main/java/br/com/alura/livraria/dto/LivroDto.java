package br.com.alura.livraria.dto;

import br.com.alura.livraria.modelo.Autor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LivroDto {

    private String titulo;
    private LocalDate dataLancamento;
    private int numeroPagina;
    private Autor autor;
}
