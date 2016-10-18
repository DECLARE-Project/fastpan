package de.fakeller.performance.analysis.result.metric.probabilistic;

import de.fakeller.performance.analysis.result.metric.DPQ;
import de.fakeller.performance.analysis.result.metric.DirectMetric;
import de.fakeller.performance.analysis.result.valueobject.statistics.StandardDeviation;
import de.fakeller.performance.analysis.result.valueobject.statistics.Variance;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Fabian Keller
 */
public class NormalDistributionMetricTest {
    @Test
    public void isOfType() throws Exception {

    }

    @Test
    public void toHumanReadable() throws Exception {
        assertEquals("N(mu=(DPQ: 42.00%), sigma=0.2400)", new NormalDistributionMetric<>(DPQ.of(0.42), new Variance(0.24)).toHumanReadable());
    }

    @Test
    public void equalsAndHashCode() throws Exception {
        NormalDistributionMetric<DPQ> d1 = new NormalDistributionMetric<>(DPQ.of(0.42), new Variance(0.24));
        NormalDistributionMetric<DPQ> d2 = new NormalDistributionMetric<>(DPQ.of(0.42), new Variance(0.24));
        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());

        assertNotSame(d1, d2);

        NormalDistributionMetric<DPQ> d3 = new NormalDistributionMetric<>(DPQ.of(0.43), new Variance(0.24));
        assertNotEquals(d3, d1);
        assertNotEquals(d3.hashCode(), d1.hashCode());
    }

    @Test
    public void getMu() throws Exception {
        DPQ mu = DPQ.of(0.42);
        assertEquals(mu, new NormalDistributionMetric<>(mu, new Variance(0.24)).getMu());
    }

    @Test
    public void getSigma() throws Exception {
        Variance sigma = new Variance(0.25);
        assertEquals(sigma, new NormalDistributionMetric<>(DPQ.of(0.42), sigma).getSigma());

        StandardDeviation std = new StandardDeviation(0.5);
        assertEquals(sigma, new NormalDistributionMetric<>(DPQ.of(0.42), std).getSigma());
    }

}