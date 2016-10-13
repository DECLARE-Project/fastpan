package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.unit.Unit;
import de.fakeller.performance.analysis.result.valueobject.AbstractValueObject;
import de.fakeller.performance.analysis.result.valueobject.ValueObject;

/**
 * Used as base class for implementing {@link PerformanceQuantity}s.
 */
abstract public class AbstractPerformanceQuantity<U extends Unit, T extends ValueObject>
        extends AbstractValueObject<T>
        implements PerformanceQuantity<U> {

    protected final U unit;

    protected AbstractPerformanceQuantity(final T value, final U unit) {
        super(value);
        this.unit = unit;
    }

    @Override
    public U unit() {
        return this.unit;
    }

    @Override
    public String toHumanReadable() {
        return String.format("%s: %s", this.getHumanReadableDescription(), this.value.toHumanReadable());
    }

    /**
     * Returns the humand-readable name of this metric. This is used to create the
     * {@link PerformanceQuantity ::toHumanReadable} notation.
     */
    abstract protected String getHumanReadableDescription();
}
