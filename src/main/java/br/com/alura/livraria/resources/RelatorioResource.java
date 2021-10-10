package br.com.alura.livraria.resources;

import br.com.alura.livraria.dto.ItemAutorDto;
import br.com.alura.livraria.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioResource {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/autor")
    public List<ItemAutorDto> relatorioAutorLivros() {
        return relatorioService.relatorioAutorLivros();
    }
}
