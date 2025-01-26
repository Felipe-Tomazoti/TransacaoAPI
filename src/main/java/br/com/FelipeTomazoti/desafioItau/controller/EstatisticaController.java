package br.com.FelipeTomazoti.desafioItau.controller;

import br.com.FelipeTomazoti.desafioItau.domain.dto.EstatisticaDTO;
import br.com.FelipeTomazoti.desafioItau.service.TransacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Estatisticas")
@Slf4j
@RestController
@RequestMapping(value = "/estatistica", produces = MediaType.APPLICATION_JSON_VALUE)
public record EstatisticaController(TransacaoService transacaoService) {

    @GetMapping()
    public ResponseEntity<EstatisticaDTO> listarEstatisticas(){
        EstatisticaDTO est = transacaoService.listarEstatisticas(1);
        log.info("Estatisticas sobre transações realizadas a 1 minuto atrás, listdas com sucesso!");
        return ResponseEntity.ok().body(est);
    }

    @GetMapping("{minutos}")
    public ResponseEntity<EstatisticaDTO> listarEstatisticasPorMinuto(
            @PathVariable
            @io.swagger.v3.oas.annotations.Parameter(
                    description = "estatisticas das transações realizadas em minutos",
                    example = "5"
            )
            long minutos){
        EstatisticaDTO est = transacaoService.listarEstatisticas(minutos);
        log.info("Estatisticas sobre transações realizadas a " + minutos + "atrás, listdas com sucesso!");
        return ResponseEntity.ok().body(est);
    }
}
