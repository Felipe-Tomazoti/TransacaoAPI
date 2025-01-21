package br.com.FelipeTomazoti.desafioItau.repository;

import br.com.FelipeTomazoti.desafioItau.domain.Estatistica;
import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Estatistica listarEstatisticas(Integer minuto) {
        OffsetDateTime umMinutoAtras = OffsetDateTime.now().minusMinutes(minuto);
        List<Transacao> transacoesValidas = transacoes.stream()
                .filter(transacao -> transacao.getDataHora().isAfter(umMinutoAtras)
                ).collect(Collectors.toList());

        int count = transacoesValidas.size();
        double sum = transacoesValidas.stream().mapToDouble(Transacao::getValor).sum();
        double avg = 0;
        if (sum == 0){
            avg = 0.00;
        } else {
            avg = sum / count;
        }
        double max = transacoesValidas.stream().mapToDouble(Transacao::getValor).max().orElse(0.0);
        double min = transacoesValidas.stream().mapToDouble(Transacao::getValor).min().orElse(0.0);

        return new Estatistica(count, sum, avg, min, max);
    }
}
