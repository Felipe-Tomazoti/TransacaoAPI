package br.com.FelipeTomazoti.desafioItau.domain.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class EstatisticaDTO {

    private long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public EstatisticaDTO() {
        this(new DoubleSummaryStatistics());
    }
    public EstatisticaDTO(DoubleSummaryStatistics summaryStatistics) {
        this.count = summaryStatistics.getCount();
        this.sum = summaryStatistics.getSum();
        this.avg = summaryStatistics.getAverage();
        this.min = summaryStatistics.getMin() == Double.POSITIVE_INFINITY ? 0 : summaryStatistics.getMin();
        this.max = summaryStatistics.getMax() == Double.NEGATIVE_INFINITY ? 0 : summaryStatistics.getMax();
    }

}

