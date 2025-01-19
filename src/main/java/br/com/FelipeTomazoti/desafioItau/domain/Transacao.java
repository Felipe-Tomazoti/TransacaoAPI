package br.com.FelipeTomazoti.desafioItau.domain;

import br.com.FelipeTomazoti.desafioItau.domain.validator.ValidTransacao;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ValidTransacao
public class Transacao {

    @NotNull(message = "O Campo \"valor\" não pode ser nulo!")
    private double valor;
    @NotNull(message = "O Campo \"dataHora\" não pode ser nulo!")
    private OffsetDateTime dataHora;

    public Transacao(Transacao transacao) {
        this.valor = transacao.getValor();
        this.dataHora = transacao.getDataHora();
    }


}
