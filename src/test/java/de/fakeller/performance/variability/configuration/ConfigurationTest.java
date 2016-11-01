package de.fakeller.performance.variability.configuration;

import de.fakeller.performance.variability.feature.BaseFeatureModel;
import de.fakeller.performance.variability.feature.UnknownFeatureException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Fabian Keller
 */
public class ConfigurationTest {

    private BaseFeatureModel<String> fm;

    @Before
    public void setUp() throws Exception {
        this.fm = new BaseFeatureModel<>(Arrays.asList("A", "B", "C", "D"));
    }

    @Test
    public void enable_singleFeature() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm);
        assertFalse(cfg.isEnabled("A"));
        assertFalse(cfg.isEnabled("C"));
        cfg.enable("A");
        cfg.enable("A");
        cfg.enable("A");
        cfg.enable("C");
        assertTrue(cfg.isEnabled("A"));
        assertTrue(cfg.isEnabled("C"));
    }

    @Test
    public void enable_collectionOfFeatures() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm);
        assertFalse(cfg.isEnabled("A"));
        assertFalse(cfg.isEnabled("C"));
        cfg.enable(Arrays.asList("A", "C"));
        assertTrue(cfg.isEnabled("A"));
        assertTrue(cfg.isEnabled("C"));
    }

    @Test(expected = UnknownFeatureException.class)
    public void enable_withUnknownFeature_throwsException() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm);
        cfg.enable("undefined_feature");
    }

    @Test
    public void disable_singleFeature() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm).enableAll();
        assertTrue(cfg.isEnabled("A"));
        assertTrue(cfg.isEnabled("C"));
        cfg.disable("A");
        cfg.disable("A");
        cfg.disable("A");
        cfg.disable("C");
        assertFalse(cfg.isEnabled("A"));
        assertFalse(cfg.isEnabled("C"));
    }

    @Test
    public void disable_collectionOfFeatures() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm).enableAll();
        assertTrue(cfg.isEnabled("A"));
        assertTrue(cfg.isEnabled("C"));
        cfg.disable(Arrays.asList("A", "C"));
        assertFalse(cfg.isEnabled("A"));
        assertFalse(cfg.isEnabled("C"));
    }

    @Test(expected = UnknownFeatureException.class)
    public void disable_withUnknownFeature_throwsException() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm);
        cfg.disable("undefined_feature");
    }

    @Test
    public void isEnabled_byDefault_isFalse() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm);
        assertFalse(cfg.isEnabled("A"));
        assertFalse(cfg.isEnabled("B"));
        assertFalse(cfg.isEnabled("C"));
        assertFalse(cfg.isEnabled("D"));
    }

    @Test(expected = UnknownFeatureException.class)
    public void isEnabled_withUnknownFeature_throwsException() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm);
        cfg.isEnabled("undefined_feature");
    }

    @Test
    public void getFeatureFlags() throws Exception {
        final Configuration<String> cfg = new Configuration<>(this.fm);
        assertEquals(Arrays.asList(false, false, false, false), cfg.getFeatureFlags());

        cfg.enable("B");
        assertEquals(Arrays.asList(false, true, false, false), cfg.getFeatureFlags());

        cfg.enable("A", "D");
        assertEquals(Arrays.asList(true, true, false, true), cfg.getFeatureFlags());

        cfg.enableAll();
        assertEquals(Arrays.asList(true, true, true, true), cfg.getFeatureFlags());

        cfg.disableAll();
        assertEquals(Arrays.asList(false, false, false, false), cfg.getFeatureFlags());
    }

}