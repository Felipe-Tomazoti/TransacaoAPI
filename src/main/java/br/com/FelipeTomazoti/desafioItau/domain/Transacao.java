package br.com.FelipeTomazoti.desafioItau.domain;

import br.com.FelipeTomazoti.desafioItau.domain.validator.ValidTransacao;
import br.com.FelipeTomazoti.desafioItau.serializer.DoubleSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ValidTransacao
public class Transacao {

    @NotNull(message = "O Campo \"valor\" não pode ser nulo!")
    @JsonSerialize(using = DoubleSerializer.class)
    private double valor;

    @NotNull(message = "O Campo \"dataHora\" não pode ser nulo!")
    private OffsetDateTime dataHora;

    public Transacao(Transacao transacao) {
        this.valor = transacao.getValor();
        this.dataHora = transacao.getDataHora();
    }


}
