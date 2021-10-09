package br.com.alura.livraria.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    private String titulo;
    private LocalDate dataLancamento;
    private int numeroPagina;
    private Autor autor;
}
