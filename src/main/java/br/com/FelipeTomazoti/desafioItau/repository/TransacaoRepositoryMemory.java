package br.com.FelipeTomazoti.desafioItau.repository;

import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepositoryMemory implements TransacaoRepository{

    private final List<Transacao> transacoes = new ArrayList<>();

    @Override
    public void salvarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    @Override
    public void excluirTodasTransacoes() {
        transacoes.clear();
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return transacoes;
    }
}
