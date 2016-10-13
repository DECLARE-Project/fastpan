package de.fakeller.performance.analysis.result.metric;

/**
 * Used as base class for implementing {@link PerformanceQuantity}s.
 */
abstract public class AbstractPerformanceQuantity<Q extends PerformanceQuantity<Q>> implements PerformanceQuantity<Q> {

//    protected AbstractPerformanceQuantity(final T value) {
//        super(value);
//    }
//
//    @Override
//    public String toHumanReadable() {
//        return String.format("%s: %s", this.getHumanReadableDescription(), this.value.toHumanReadable());
//    }
//
//    /**
//     * Returns the humand-readable name of this metric. This is used to create the
//     * {@link PerformanceQuantity ::toHumanReadable} notation.
//     */
//    abstract protected String getHumanReadableDescription();
}
