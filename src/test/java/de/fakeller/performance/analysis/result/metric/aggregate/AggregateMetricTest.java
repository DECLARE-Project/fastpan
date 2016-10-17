package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.DPQ;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

/**
 * @author Fabian Keller
 */
public class AggregateMetricTest {

    @Test
    public void mean() {
        testMetric(MeanMetric::new);
        assertEquals("mean(DPQ: 42.00%)", new MeanMetric<>(DPQ.of(0.42)).toHumanReadable());
    }

    @Test
    public void median() {
        testMetric(MedianMetric::new);
        assertEquals("median(DPQ: 42.00%)", new MedianMetric<>(DPQ.of(0.42)).toHumanReadable());
    }

    @Test
    public void min() {
        testMetric(MinMetric::new);
        assertEquals("min(DPQ: 42.00%)", new MinMetric<>(DPQ.of(0.42)).toHumanReadable());
    }

    @Test
    public void max() {
        testMetric(MaxMetric::new);
        assertEquals("max(DPQ: 42.00%)", new MaxMetric<>(DPQ.of(0.42)).toHumanReadable());
    }

    @Test
    public void sum() {
        testMetric(SumMetric::new);
        assertEquals("sum(DPQ: 42.00%)", new SumMetric<>(DPQ.of(0.42)).toHumanReadable());
    }


    private void testMetric(final Function<DPQ, AggregateMetric<DPQ>> metric) {
        DPQ m1dpq = DPQ.of(2.4);
        AggregateMetric m1 = metric.apply(m1dpq);
        AggregateMetric m2 = metric.apply(DPQ.of(2.5));

        // check metric equality
        assertEquals(m1, metric.apply(DPQ.of(2.4)));
        assertNotEquals(m1, m2);

        assertSame(m1dpq, m1.getAggregate());
    }


}