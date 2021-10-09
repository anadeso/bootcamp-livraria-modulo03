package br.com.alura.livraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import java.time.LocalDate;

@Getter
@Setter
public class AutorFormDto {

    @NotBlank(message = "Nao deve ser nulo")
    @Size(min = 3, max = 40, message = "Tamanho deve estar entre 3 e 40")
    private String nome;

    @NotBlank(message = "Nao deve ser nulo")
    @Email(message = "Email deve ser valido")
    @Size(min = 8, max = 40, message = "Tamanho deve estar entre 8 e 40")
    private String email;

    @NotNull
    @Past(message = "Deve estar no passado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "Nao deve ser nulo")
    @Size(min = 10, max = 300, message = "Tamanho deve estar entre 10 e 300")
    private String miniCurriculo;
}
