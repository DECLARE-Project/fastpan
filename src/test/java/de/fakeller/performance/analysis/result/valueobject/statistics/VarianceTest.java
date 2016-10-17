package de.fakeller.performance.analysis.result.valueobject.statistics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class VarianceTest {

    @Test
    public void equals() throws Exception {
        assertEquals(new Variance(0.24), new Variance(0.24));
        assertNotEquals(new Variance(0.23), new Variance(0.24));
    }

    @Test
    public void getVariance() throws Exception {
        assertEquals(0.24, new Variance(0.24).getVariance(), Double.MIN_VALUE);
    }

    @Test
    public void toHumanReadable() throws Exception {
        assertEquals("variance=0.2400", new Variance(0.24).toHumanReadable());
    }


}