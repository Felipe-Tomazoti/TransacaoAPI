package br.com.FelipeTomazoti.desafioItau.controller;

import br.com.FelipeTomazoti.desafioItau.domain.Estatistica;
import br.com.FelipeTomazoti.desafioItau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping()
    public ResponseEntity<Estatistica> listarEstatisticas(){
        Estatistica est = transacaoService.listarEstatisticas(1);
        return ResponseEntity.ok().body(est);
    }

    @GetMapping("{minutos}")
    public ResponseEntity<Estatistica> listarEstatisticasPorMinuto(@PathVariable Integer minutos){
        Estatistica est = transacaoService.listarEstatisticas(minutos);
        return ResponseEntity.ok().body(est);
    }
}
