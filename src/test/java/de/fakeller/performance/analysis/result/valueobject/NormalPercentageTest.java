package de.fakeller.performance.analysis.result.valueobject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalPercentageTest {

    @Test
    public void getPercentage() throws Exception {
        assertEquals(0.21, NormalPercentage.of(0.21).getPercentage(), Double.MIN_VALUE);
    }


    @Test
    public void equals() throws Exception {
        assertEquals(NormalPercentage.of(0.21), NormalPercentage.of(0.21));
    }

    @Test
    public void toHumanReadable() throws Exception {
        assertEquals("21.00%", NormalPercentage.of(0.21).toHumanReadable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfOutOfUpperBound() {
        NormalPercentage.of(1.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfOutOfLowerBound() {
        NormalPercentage.of(-0.01);
    }
}