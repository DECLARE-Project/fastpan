package de.fakeller.performance.variability.configuration;

import de.fakeller.performance.variability.feature.FeatureModel;
import de.fakeller.performance.variability.feature.UnknownFeatureException;

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


    public Configuration<FEATURE> enable(final FEATURE... features) {
        return this.enable(Arrays.asList(features));
    }

    public Configuration<FEATURE> enable(final Collection<FEATURE> features) {
        this.setConfiguration(features, true);
        return this;
    }

    /**
     * Sets all feature flags to enabled.
     */
    public Configuration<FEATURE> enableAll() {
        return this.enable(this.isEnabled.keySet());
    }


    public Configuration<FEATURE> disable(final FEATURE... features) {
        return this.disable(Arrays.asList(features));
    }

    public Configuration<FEATURE> disable(final Collection<FEATURE> features) {
        this.setConfiguration(features, false);
        return this;
    }

    /**
     * Sets all feature flags to enabled.
     */
    public Configuration<FEATURE> disableAll() {
        return this.disable(this.isEnabled.keySet());
    }

    /**
     * Determines whether the given feature is enabled or not.
     */
    public boolean isEnabled(final FEATURE feature) {
        this.assertContainsFeature(feature);
        return this.isEnabled.get(feature);
    }

    /**
     * Returns an ordered list of boolean flags indicating whether the feature at index i is enabled or not.
     */
    public List<Boolean> getFeatureFlags() {
        return new ArrayList<>(this.isEnabled.values());
    }


    private void setConfiguration(final Collection<FEATURE> features, final boolean enabled) {
        features.forEach(feature -> {
            this.assertContainsFeature(feature);
            this.isEnabled.put(feature, enabled);
        });
    }

    private void assertContainsFeature(final FEATURE feature) {
        if (!this.fm.hasFeature(feature)) {
            throw new UnknownFeatureException(String.format("The feature model %s does not have feature %s. You must specify all valid features when constructing the feature model!", this.fm, feature));
        }
    }

}
