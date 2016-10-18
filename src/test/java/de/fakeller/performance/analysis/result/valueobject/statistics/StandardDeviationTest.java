package de.fakeller.performance.analysis.result.valueobject.statistics;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class StandardDeviationTest {

    @Test
    public void equals() throws Exception {
        assertEquals(new StandardDeviation(0.24), new StandardDeviation(0.24));
        assertNotEquals(new StandardDeviation(0.23), new StandardDeviation(0.24));
    }

    @Test
    public void getStandardDeviation() throws Exception {
        assertEquals(0.24, new StandardDeviation(0.24).getStandardDeviation(), Double.MIN_VALUE);
    }

    @Test
    public void toHumanReadable() throws Exception {
        assertEquals("std=0.2400", new StandardDeviation(0.24).toHumanReadable());
    }


}