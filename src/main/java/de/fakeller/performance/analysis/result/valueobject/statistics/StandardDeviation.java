package de.fakeller.performance.analysis.result.valueobject.statistics;

import de.fakeller.performance.analysis.result.valueobject.AbstractValueObject;

/**
 * Represents the standard deviation sigma.
 */
public class StandardDeviation extends AbstractValueObject<Double> {

    protected StandardDeviation(double value) {
        super(value);
    }

    @Override
    public String toHumanReadable() {
        return String.format("std=%.4f", this.value);
    }
}
