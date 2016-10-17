package de.fakeller.performance.analysis.result.valueobject.statistics;

import de.fakeller.performance.analysis.result.valueobject.AbstractValueObject;

/**
 * Represents the variance: sigma^2.
 */
public class Variance extends AbstractValueObject<Double> {

    protected Variance(double value) {
        super(value);
    }

    @Override
    public String toHumanReadable() {
        return String.format("variance=%.4f", this.value);
    }
}
