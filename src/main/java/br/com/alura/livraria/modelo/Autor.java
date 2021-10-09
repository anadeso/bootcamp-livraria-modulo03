package br.com.alura.livraria.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    private String nome;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate dataNascimento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String miniCurriculo;
}
