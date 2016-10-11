package de.fakeller.performance.variability.feature;

import java.util.*;

/**
 * A feature model contains all possible features of a system.
 * <p>
 * Constraints between features are not modeled, as they are not relevant for performance analysis. They should be
 * modeled by the backing feature model.
 */
public class FeatureModel<FEATURE> {

    private final Set<Feature<FEATURE>> features = new LinkedHashSet<>();

    public FeatureModel(final List<Feature<FEATURE>> features) {
        this.features.addAll(features);
    }

    /**
     * Returns all features in this feature model.
     */
    public List<Feature<FEATURE>> getFeatures() {
        return Collections.unmodifiableList(new ArrayList<Feature<FEATURE>>(this.features));
    }

    /**
     * Determines whether the given feature is part of this feature model.
     */
    public boolean hasFeature(final Feature<FEATURE> feature) {
        return this.features.contains(feature);
    }

    /**
     * Gets the feature at the specified index.
     */
    public Feature<FEATURE> get(final int index) {
        return this.getFeatures().get(index);
    }
}
