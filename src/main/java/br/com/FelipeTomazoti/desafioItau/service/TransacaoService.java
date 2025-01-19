package br.com.FelipeTomazoti.desafioItau.service;

import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public void criarTransacao(Transacao transacao) {
        transacaoRepository.salvarTransacao(new Transacao(transacao));
    }

    public void excluirTodasTransacoes() {
        transacaoRepository.excluirTodasTransacoes();
    }

    public List<Transacao> listarTransacoes() {
        return transacaoRepository.listarTransacoes();
    }
}
