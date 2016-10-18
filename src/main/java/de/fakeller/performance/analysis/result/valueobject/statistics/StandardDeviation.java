package de.fakeller.performance.analysis.result.valueobject.statistics;

import de.fakeller.performance.analysis.result.valueobject.AbstractValueObject;

import java.util.Locale;

/**
 * Represents the standard deviation sigma.
 */
public class StandardDeviation extends AbstractValueObject<Double> {

    public StandardDeviation(double value) {
        super(value);
    }

    @Override
    public String toHumanReadable() {
        return String.format(Locale.ROOT, "std=%.4f", this.value);
    }

    public double getStandardDeviation() {
        return this.value;
    }
}
