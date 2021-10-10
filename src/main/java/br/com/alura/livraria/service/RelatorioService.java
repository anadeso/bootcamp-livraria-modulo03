package br.com.alura.livraria.service;

import br.com.alura.livraria.dto.ItemAutorDto;
import br.com.alura.livraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private LivroRepository repository;

    public List<ItemAutorDto> relatorioAutorLivros() {
        return repository.relatorioAutorLivros();
    }
}
