package br.com.FelipeTomazoti.desafioItau.controller;

import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes(){
        List<Transacao> list = transacaoService.listarTransacoes();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody @Valid Transacao transacao) {
        transacaoService.criarTransacao(transacao);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodasTransacoes() {
        transacaoService.excluirTodasTransacoes();
        return ResponseEntity.ok().build();
    }
}
