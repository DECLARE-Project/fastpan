package de.fakeller.performance.analysis.result;

import de.fakeller.performance.analysis.result.metric.DirectMetric;
import de.fakeller.performance.analysis.result.metric.aggregate.*;
import de.fakeller.performance.analysis.result.metric.probabilistic.NormalDistributionMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.quantity.RelativeThroughput;
import de.fakeller.performance.analysis.result.quantity.ServiceTime;
import de.fakeller.performance.analysis.result.quantity.Utilization;
import de.fakeller.performance.analysis.result.quantity.time.BusyTime;
import de.fakeller.performance.analysis.result.quantity.time.IdleTime;
import de.fakeller.performance.analysis.result.unit.ThroughputUnit;
import de.fakeller.performance.analysis.result.valueobject.Duration;
import de.fakeller.performance.analysis.result.valueobject.NormalPercentage;
import de.fakeller.performance.analysis.result.valueobject.Percentage;
import de.fakeller.performance.analysis.result.valueobject.statistics.StandardDeviation;
import de.fakeller.performance.analysis.result.valueobject.statistics.Variance;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Fabian Keller
 */
public class AttachTest {

    private final Object to = new Object();

    @Test
    public void allQuantities() {
        assertQuantity(Attach.to(this.to).busyTime(Duration.ofMilliseconds(240)).direct(), BusyTime.class);
        assertQuantity(Attach.to(this.to).idleTime(Duration.ofMilliseconds(240)).direct(), IdleTime.class);
        assertQuantity(Attach.to(this.to).serviceTime(Duration.ofMilliseconds(240)).direct(), ServiceTime.class);

        assertQuantity(Attach.to(this.to).relativeThroughput(NormalPercentage.of(0.2), ThroughputUnit.MESSAGES).direct(), RelativeThroughput.class);
        assertQuantity(Attach.to(this.to).utilization(Percentage.of(0.2)).direct(), Utilization.class);
    }

    @Test
    public void allMetrics() {
        final Attach.MetricBuilder b = Attach.to(this.to).busyTime(Duration.ofMilliseconds(250));

        assertTrue(b.direct().value() instanceof DirectMetric);

        // aggregate
        assertTrue(b.mean().value() instanceof MeanMetric);
        assertTrue(b.median().value() instanceof MedianMetric);
        assertTrue(b.min().value() instanceof MinMetric);
        assertTrue(b.max().value() instanceof MaxMetric);
        assertTrue(b.sum().value() instanceof SumMetric);

        // probabilistic
        assertTrue(b.normalDistribution(new Variance(0.14)).value() instanceof NormalDistributionMetric);
        assertTrue(b.normalDistribution(new StandardDeviation(0.8)).value() instanceof NormalDistributionMetric);
    }

    private void assertQuantity(final Result<?> result, final Class<? extends PerformanceQuantity> quantity) {
        assertNotNull(result.value());
        assertTrue(result.value().isOfType(quantity));
        assertFalse(result.value().isOfType(GarbageQuantity.class));
    }


    interface GarbageQuantity extends PerformanceQuantity {

    }
}