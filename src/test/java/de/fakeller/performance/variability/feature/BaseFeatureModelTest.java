package de.fakeller.performance.variability.feature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Fabian Keller
 */
public class BaseFeatureModelTest {

    BaseFeatureModel<String> sut;

    @Before
    public void setUp() throws Exception {
        this.sut = new BaseFeatureModel<>(Arrays.asList("A", "B", "C", "D"));

    }

    @Test
    public void getFeatures() throws Exception {
        Assert.assertEquals(Arrays.asList("A", "B", "C", "D"), this.sut.getFeatures());
    }

    @Test
    public void hasFeature() throws Exception {
        assertTrue(this.sut.hasFeature("A"));
        assertTrue(this.sut.hasFeature("D"));
        assertFalse(this.sut.hasFeature("unknown"));
    }

    @Test
    public void get() throws Exception {
        assertEquals("A", this.sut.get(0));
        assertEquals("B", this.sut.get(1));
        assertEquals("C", this.sut.get(2));
        assertEquals("D", this.sut.get(3));
    }

    @Test(expected = UnknownFeatureException.class)
    public void get_withInvalidIndex_throwsException() throws Exception {
        this.sut.get(4);
    }
}
