package de.fakeller.performance.variability.configuration;

import de.fakeller.performance.variability.feature.FeatureModel;

import java.util.*;

/**
 * Defines a configuration of the {@link FeatureModel}, such that each {@link FEATURE} is either enabled or disabled.
 */
public class Configuration<FEATURE> {

    private final FeatureModel<FEATURE> fm;

    private final Map<FEATURE, Boolean> isEnabled = new LinkedHashMap<>();

    public Configuration(final FeatureModel<FEATURE> fm) {
        this.fm = fm;
        this.fm.getFeatures().forEach(f -> this.isEnabled.put(f, false));
    }


    public Configuration<FEATURE> enable(final FEATURE feature) {
        return this.enable(Arrays.asList(feature));
    }

    public Configuration<FEATURE> enable(final Collection<FEATURE> features) {
        this.setConfiguration(features, true);
        return this;
    }


    public Configuration<FEATURE> disable(final FEATURE feature) {
        return this.disable(Arrays.asList(feature));
    }

    public Configuration<FEATURE> disable(final Collection<FEATURE> features) {
        this.setConfiguration(features, false);
        return this;
    }


    private void setConfiguration(final Collection<FEATURE> features, final boolean enabled) {
        features.forEach(feature -> {
            assert this.fm.hasFeature(feature);
            this.isEnabled.put(feature, enabled);
        });
    }

    public boolean isEnabled(final FEATURE feature) {
        assert this.fm.hasFeature(feature);
        return this.isEnabled.get(feature);
    }

    /**
     * Returns an ordered list of boolean flags indicating whether the feature at index i is enabled or not.
     */
    public List<Boolean> getFeatureFlags() {
        return new ArrayList<>(this.isEnabled.values());
    }
}
