package br.com.FelipeTomazoti.desafioItau.domain;

import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Transacao {

    private double valor;
    private OffsetDateTime dataHora;

}
