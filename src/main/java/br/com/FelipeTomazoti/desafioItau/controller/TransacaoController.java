package br.com.FelipeTomazoti.desafioItau.controller;

import br.com.FelipeTomazoti.desafioItau.domain.Estatistica;
import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;
import br.com.FelipeTomazoti.desafioItau.service.TransacaoService;
import io.swagger.v3.core.util.Json;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/transacao")
public record TransacaoController(TransacaoService transacaoService) {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransacaoDTO>> listarTransacoes(){
        List<TransacaoDTO> list = transacaoService.listarTransacoes();
        log.info("Transacoes listadas com sucesso!");
        return ResponseEntity.ok(list);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> criarTransacao(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        transacaoService.criarTransacao(transacaoDTO);
        log.info("Transacao criada com sucesso!");
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodasTransacoes() {
        transacaoService.excluirTodasTransacoes();
        log.info("Transacoes excluidas com sucesso!");
        return ResponseEntity.ok().build();
    }
}
