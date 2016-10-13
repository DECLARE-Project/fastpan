package de.fakeller.performance.analysis.result.quantity;

import de.fakeller.performance.analysis.result.unit.Unitless;
import de.fakeller.performance.analysis.result.valueobject.Percentage;

/**
 * Represents the utilization of a resource.
 */
public class Utilization extends AbstractPerformanceQuantity<Unitless, Percentage> {

    public Utilization(final Percentage utilization) {
        super(utilization, Unitless.UNITLESS);
    }

    public Percentage getUtilization() {
        return this.value;
    }

    @Override
    protected String getHumanReadableDescription() {
        return "Utilization";
    }

    @Override
    public double value() {
        return this.value.getPercentage();
    }

    @Override
    public PerformanceQuantity wrap(final double value, final Unitless unit) {
        assert unit.equals(Unitless.UNITLESS);
        return new Utilization(Percentage.of(value));
    }
}
