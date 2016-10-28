package de.fakeller.performance.variability.feature;

/**
 * Thrown in case a method expects a Feature to be present, but is not.
 */
public class UnknownFeatureException extends IllegalArgumentException {
    public UnknownFeatureException(final String s) {
        super(s);
    }
}
