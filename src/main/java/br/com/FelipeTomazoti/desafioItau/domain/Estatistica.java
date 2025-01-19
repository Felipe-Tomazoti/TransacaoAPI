package br.com.FelipeTomazoti.desafioItau.domain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Estatistica {

    private int count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
