package br.com.FelipeTomazoti.desafioItau.domain.dto;


import br.com.FelipeTomazoti.desafioItau.domain.validator.ValidTransacao;
import br.com.FelipeTomazoti.desafioItau.serializer.DoubleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ValidTransacao
public class TransacaoDTO {

    @NotNull(message = "O Campo \"valor\" não pode ser nulo!")
    @JsonSerialize(using = DoubleSerializer.class)
    private Double valor;

    @NotNull(message = "O Campo \"dataHora\" não pode ser nulo!")
    private OffsetDateTime dataHora;

    public TransacaoDTO(TransacaoDTO transacao) {
        this.valor = transacao.getValor();
        this.dataHora = transacao.getDataHora();
    }
}

