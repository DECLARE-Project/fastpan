package de.fakeller.performance.variability.configuration;

import de.fakeller.performance.variability.feature.Feature;
import de.fakeller.performance.variability.feature.FeatureModel;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines a configuration of the {@link FeatureModel}, such that each {@link Feature} is either enabled or disabled.
 */
public class Configuration<FEATURE> {

    private final FeatureModel<FEATURE> fm;

    private final Map<Feature<FEATURE>, Boolean> isEnabled = new HashMap();

    public Configuration(final FeatureModel<FEATURE> fm) {
        this.fm = fm;
        this.fm.getFeatures().forEach(f -> this.isEnabled.put(f, false));
    }


    public Configuration<FEATURE> enable(final Feature<FEATURE> feature) {
        return this.enable(Arrays.asList(feature));
    }

    public Configuration<FEATURE> enable(final Collection<Feature<FEATURE>> features) {
        this.setConfiguration(features, true);
        return this;
    }


    public Configuration<FEATURE> disable(final Feature<FEATURE> feature) {
        return this.disable(Arrays.asList(feature));
    }

    public Configuration<FEATURE> disable(final Collection<Feature<FEATURE>> features) {
        this.setConfiguration(features, false);
        return this;
    }


    private void setConfiguration(final Collection<Feature<FEATURE>> features, final boolean enabled) {
        features.forEach(feature -> {
            assert this.fm.hasFeature(feature);
            this.isEnabled.put(feature, enabled);
        });
    }

    public boolean isEnabled(final Feature<FEATURE> feature) {
        assert this.fm.hasFeature(feature);
        return this.isEnabled.get(feature);
    }
}
