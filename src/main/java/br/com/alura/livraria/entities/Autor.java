package br.com.alura.livraria.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "data")
    private LocalDate dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "curriculo")
    @Size(min = 10, max = 300)
    private String miniCurriculo;
}
