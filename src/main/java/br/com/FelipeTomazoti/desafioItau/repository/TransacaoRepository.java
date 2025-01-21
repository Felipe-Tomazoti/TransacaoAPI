package br.com.FelipeTomazoti.desafioItau.repository;

import br.com.FelipeTomazoti.desafioItau.domain.Estatistica;
import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.domain.dto.EstatisticaDTO;
import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;

import java.util.List;

public interface TransacaoRepository {
    void salvarTransacao(TransacaoDTO transacao);
    void excluirTodasTransacoes();
    List<TransacaoDTO> listarTransacoes();
    EstatisticaDTO listarEstatisticas(long minuto);
}
