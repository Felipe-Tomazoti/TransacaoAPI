package br.com.FelipeTomazoti.desafioItau.service;

import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    public void criarTransacao(Transacao transacao) {
        new Transacao(transacao);
    }
}
