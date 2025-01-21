package br.com.FelipeTomazoti.desafioItau.service;

import br.com.FelipeTomazoti.desafioItau.domain.Estatistica;
import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.domain.dto.EstatisticaDTO;
import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;
import br.com.FelipeTomazoti.desafioItau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record TransacaoService(TransacaoRepository transacaoRepository) {

    public void criarTransacao(TransacaoDTO transacao) {
        transacaoRepository.salvarTransacao(transacao);
    }

    public void excluirTodasTransacoes() {
        transacaoRepository.excluirTodasTransacoes();
    }

    public List<TransacaoDTO> listarTransacoes() {
        return transacaoRepository.listarTransacoes();
    }

    public EstatisticaDTO listarEstatisticas(long minutos) {
        return transacaoRepository.listarEstatisticas(minutos);
    }
}
