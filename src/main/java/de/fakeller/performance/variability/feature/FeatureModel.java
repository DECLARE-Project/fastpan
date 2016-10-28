package de.fakeller.performance.variability.feature;

import java.util.*;

/**
 * A feature model contains all possible features of a system.
 * <p>
 * Constraints between features are not modeled, as they are not relevant for performance analysis. They should be
 * modeled by the backing feature model.
 *
 * @param <FEATURE> the backing class representing a feature. Features must properly implement {@link Object#hashCode()}
 *                  and {@link Object#equals(Object)}.
 */
public class FeatureModel<FEATURE> {

    private final Set<FEATURE> features = new LinkedHashSet<>();

    public FeatureModel(final List<FEATURE> features) {
        this.features.addAll(features);
    }

    /**
     * Returns all features in this feature model.
     */
    public List<FEATURE> getFeatures() {
        return Collections.unmodifiableList(new ArrayList<>(this.features));
    }

    /**
     * Determines whether the given feature is part of this feature model.
     */
    public boolean hasFeature(final FEATURE feature) {
        return this.features.contains(feature);
    }

    /**
     * Gets the feature at the specified index.
     *
     * @throws UnknownFeatureException in case the index is not valid
     */
    public FEATURE get(final int index) {
        if (index < 0 || index >= this.getFeatures().size()) {
            throw new UnknownFeatureException(String.format("Feature model %s does not have a feature at index %d, as there are only %d features available.", this, index, this.features.size()));
        }
        return this.getFeatures().get(index);
    }
}
