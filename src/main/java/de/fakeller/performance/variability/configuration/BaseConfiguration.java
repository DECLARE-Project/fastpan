package de.fakeller.performance.variability.configuration;

import de.fakeller.performance.variability.feature.FeatureModel;
import de.fakeller.performance.variability.feature.UnknownFeatureException;

import java.util.*;

/**
 * Implements a Java-based configuration.
 *
 * @param <FEATURE>
 */
public class BaseConfiguration<FEATURE> implements ModifiableConfiguration<FEATURE> {

    private final FeatureModel<FEATURE> fm;

    private final Map<FEATURE, Boolean> isEnabled = new LinkedHashMap<>();

    public BaseConfiguration(final FeatureModel<FEATURE> fm) {
        this.fm = fm;
        this.fm.getFeatures().forEach(f -> this.isEnabled.put(f, false));
    }


    @Override
    public BaseConfiguration<FEATURE> enable(final Collection<FEATURE> features) {
        this.setConfiguration(features, true);
        return this;
    }

    @Override
    public BaseConfiguration<FEATURE> enableAll() {
        return this.enable(this.isEnabled.keySet());
    }


    @Override
    public BaseConfiguration<FEATURE> disable(final Collection<FEATURE> features) {
        this.setConfiguration(features, false);
        return this;
    }

    @Override
    public BaseConfiguration<FEATURE> disableAll() {
        return this.disable(this.isEnabled.keySet());
    }


    @Override
    public boolean isEnabled(final FEATURE feature) {
        this.assertContainsFeature(feature);
        return this.isEnabled.get(feature);
    }

    @Override
    public List<Boolean> getFeatureFlags() {
        return new ArrayList<>(this.isEnabled.values());
    }

    @Override
    public FeatureModel<FEATURE> getFeatureModel() {
        return this.fm;
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
