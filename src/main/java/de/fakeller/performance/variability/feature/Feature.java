package de.fakeller.performance.variability.feature;

/**
 * Used to model a single feature of an external feature model.
 *
 * @param <FEATURE> the feature of the external feature model backing this representation
 */
public class Feature<FEATURE> {

    private final String name;
    private final FEATURE feature;

    public Feature(final String name, final FEATURE feature) {
        this.name = name;
        this.feature = feature;
    }

    /**
     * Returns a human-readable name representing the feature.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the feature object that backs this feature.
     */
    public FEATURE getFeature() {
        return this.feature;
    }
}
