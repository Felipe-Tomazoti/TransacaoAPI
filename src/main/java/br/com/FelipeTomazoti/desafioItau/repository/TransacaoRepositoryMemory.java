package br.com.FelipeTomazoti.desafioItau.repository;

import br.com.FelipeTomazoti.desafioItau.domain.Estatistica;
import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.domain.dto.EstatisticaDTO;
import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Repository
public class TransacaoRepositoryMemory implements TransacaoRepository{

    private final List<TransacaoDTO> transacoes = new ArrayList<>();

    @Override
    public void salvarTransacao(TransacaoDTO transacao) {
        transacoes.add(new TransacaoDTO(transacao));
    }

    @Override
    public void excluirTodasTransacoes() {
        transacoes.clear();
    }

    @Override
    public List<TransacaoDTO> listarTransacoes() {
        return transacoes;
    }

    @Override
    public EstatisticaDTO listarEstatisticas(long minuto) {
        OffsetDateTime umMinutoAtras = OffsetDateTime.now().minusMinutes(minuto);
        final Double[] valoresValidos = transacoes.stream()
                .filter(transacao -> transacao.getDataHora().isAfter(umMinutoAtras))
                .map(TransacaoDTO::getValor)
                .toArray(Double[]::new);
        if (valoresValidos.length == 0){
            return new EstatisticaDTO();
        }else {
            DoubleStream doubleStream = Arrays.stream(valoresValidos).mapToDouble(Double::doubleValue);
            return new EstatisticaDTO(doubleStream.summaryStatistics());
        }
    }
}
