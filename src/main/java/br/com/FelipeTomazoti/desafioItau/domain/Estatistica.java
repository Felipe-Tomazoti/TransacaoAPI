package br.com.FelipeTomazoti.desafioItau.domain;
import br.com.FelipeTomazoti.desafioItau.serializer.DoubleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Estatistica {

    private int count;
    @JsonSerialize(using = DoubleSerializer.class)
    private double sum;
    @JsonSerialize(using = DoubleSerializer.class)
    private double avg;
    @JsonSerialize(using = DoubleSerializer.class)
    private double min;
    @JsonSerialize(using = DoubleSerializer.class)
    private double max;

}
