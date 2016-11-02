package de.fakeller.performance.variability.feature;

/**
 * Interface used to ease the integration of 3rd-party feature models.
 */
public interface BackedFeatureModel<MODEL, FEATURE> extends FeatureModel<FEATURE> {

    /**
     * Returns the feature model that backs this feature model.
     */
    MODEL getBackingFeatureModel();
}
