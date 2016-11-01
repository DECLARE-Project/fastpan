package de.fakeller.performance.variability.feature;

import java.util.List;

/**
 * A feature model contains all possible features of a system.
 * <p>
 * Constraints between features are not modeled, as they are not relevant for performance analysis. They should be
 * modeled by the backing feature model.
 *
 * @param <FEATURE> the backing class representing a feature. Features must properly implement {@link Object#hashCode()}
 *                  and {@link Object#equals(Object)}.
 */
public interface FeatureModel<FEATURE> {

    /**
     * Returns all features in this feature model.
     */
    List<FEATURE> getFeatures();

    /**
     * Determines whether the given feature is part of this feature model.
     */
    boolean hasFeature(FEATURE feature);

    /**
     * Gets the feature at the specified index.
     *
     * @throws UnknownFeatureException in case the index is not valid
     */
    FEATURE get(int index);
}
