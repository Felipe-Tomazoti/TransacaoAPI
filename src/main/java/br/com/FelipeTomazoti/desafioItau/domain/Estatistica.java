package br.com.FelipeTomazoti.desafioItau.domain;
import br.com.FelipeTomazoti.desafioItau.serializer.DoubleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.DoubleSummaryStatistics;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Estatistica {

    private long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

}
