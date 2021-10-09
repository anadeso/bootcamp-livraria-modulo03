package br.com.alura.livraria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Min;

import java.time.LocalDate;

@Getter
@Setter
public class LivroFormDto {

    @NotBlank(message = "Nao deve ser nulo")
    @Size(min = 10, max = 40, message = "Tamanho deve estar entre 10 e 40")
    private String titulo;

    @NotNull
    @PastOrPresent(message = "Deve estar no presente ou passado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    @Min(100)
    private int numeroPagina;

    @JsonAlias("autor_id")
    private Long autorId;
}
