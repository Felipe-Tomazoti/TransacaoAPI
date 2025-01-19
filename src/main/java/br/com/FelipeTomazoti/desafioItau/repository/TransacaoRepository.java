package br.com.FelipeTomazoti.desafioItau.repository;

import br.com.FelipeTomazoti.desafioItau.domain.Transacao;

import java.util.List;

public interface TransacaoRepository {
    void salvarTransacao(Transacao transacao);
    void excluirTodasTransacoes();
    List<Transacao> listarTransacoes();
}
