package de.fakeller.performance.analysis.result.valueobject.statistics;

import de.fakeller.performance.analysis.result.valueobject.AbstractValueObject;

/**
 * Represents the variance: sigma^2.
 */
public class Variance extends AbstractValueObject<Double> {

    public Variance(double value) {
        super(value);
    }

    @Override
    public String toHumanReadable() {
        return String.format("variance=%.4f", this.value);
    }

    public double getVariance() {
        return this.value;
    }
}
