package de.fakeller.performance.analysis.result.valueobject.statistics;

import de.fakeller.performance.analysis.result.valueobject.AbstractValueObject;

import java.util.Locale;

/**
 * Represents the variance: sigma^2.
 */
public class Variance extends AbstractValueObject<Double> {

    public Variance(double value) {
        super(value);
    }

    @Override
    public String toHumanReadable() {
        return String.format(Locale.ROOT, "variance=%.4f", this.value);
    }

    public double getVariance() {
        return this.value;
    }
}
