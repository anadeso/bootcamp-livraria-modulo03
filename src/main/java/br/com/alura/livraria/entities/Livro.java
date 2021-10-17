package br.com.alura.livraria.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @Column(name = "data")
    private LocalDate dataLancamento;

    @Column(name = "numpagina")
    private Integer numeroPagina;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
