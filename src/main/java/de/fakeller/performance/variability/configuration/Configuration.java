package de.fakeller.performance.variability.configuration;

import de.fakeller.performance.variability.feature.FeatureModel;

import java.util.List;

/**
 * Defines a configuration of the {@link FeatureModel}, such that each {@link FEATURE} is either enabled or disabled.
 *
 * @param <FEATURE> the backing class representing a feature. Features must properly implement {@link Object#hashCode()}
 *                  and {@link Object#equals(Object)}.
 */
public interface Configuration<FEATURE> {

    /**
     * Determines whether the given feature is enabled or not.
     */
    boolean isEnabled(FEATURE feature);

    /**
     * Returns an ordered list of boolean flags indicating whether the feature at index i is enabled or not.
     */
    List<Boolean> getFeatureFlags();

    /**
     * Returns the feature model this configuration belongs to.
     */
    FeatureModel<FEATURE> getFeatureModel();
}
