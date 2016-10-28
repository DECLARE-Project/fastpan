package de.fakeller.performance.variability.feature;

/**
 * Thrown in case a method expects a Feature to be present, but is not.
 */
public class UnknownFeatureException extends IllegalArgumentException {
    public UnknownFeatureException() {
    }

    public UnknownFeatureException(final String s) {
        super(s);
    }

    public UnknownFeatureException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnknownFeatureException(final Throwable cause) {
        super(cause);
    }
}
