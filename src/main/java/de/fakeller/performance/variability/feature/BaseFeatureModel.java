package de.fakeller.performance.variability.feature;

import java.util.*;

/**
 * Provides a base implementation for a feature model.
 */
public class BaseFeatureModel<FEATURE> implements FeatureModel<FEATURE> {

    private final Set<FEATURE> features = new LinkedHashSet<>();

    public BaseFeatureModel(final List<FEATURE> features) {
        this.features.addAll(features);
    }

    @Override
    public List<FEATURE> getFeatures() {
        return Collections.unmodifiableList(new ArrayList<>(this.features));
    }


    @Override
    public boolean hasFeature(final FEATURE feature) {
        return this.features.contains(feature);
    }

    @Override
    public FEATURE get(final int index) {
        if (index < 0 || index >= this.getFeatures().size()) {
            throw new UnknownFeatureException(String.format("Feature model %s does not have a feature at index %d, as there are only %d features available.", this, index, this.features.size()));
        }
        return this.getFeatures().get(index);
    }
}
