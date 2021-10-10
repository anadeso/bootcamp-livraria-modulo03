package br.com.alura.livraria.repositories;

import br.com.alura.livraria.dto.ItemAutorDto;
import br.com.alura.livraria.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select new br.com.alura.livraria.dto.ItemAutorDto(" +
            "a.nome, " +
            "count(l.autor), " +
            "count(l.autor) * 1.0 / (select count(l2.autor) from Livro l2) * 1.0) " +
            "from Livro l " +
            "inner join Autor a " +
            "on a.id = l.autor " +
            "group by a.nome ")
    List<ItemAutorDto> relatorioAutorLivros();
}

