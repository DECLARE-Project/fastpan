package de.fakeller.performance.analysis.result.metric;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Fabian Keller
 */
public class DirectMetricTest {
    @Test
    public void getMetric() throws Exception {
        DPQ q = DPQ.of(0.42);
        assertSame(q, new DirectMetric<>(q).getMetric());
    }

    @Test
    public void toHumanReadable() throws Exception {
        assertEquals("DPQ: 42.00%", new DirectMetric<>(DPQ.of(0.42)).toHumanReadable());
    }

    @Test
    public void equalsAndHashCode() throws Exception {
        DirectMetric<DPQ> d1 = new DirectMetric<>(DPQ.of(0.42));
        DirectMetric<DPQ> d2 = new DirectMetric<>(DPQ.of(0.42));
        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());

        assertNotSame(d1, d2);

        DirectMetric<DPQ> d3 = new DirectMetric<>(DPQ.of(0.43));
        assertNotEquals(d3, d1);
        assertNotEquals(d3.hashCode(), d1.hashCode());
    }

}