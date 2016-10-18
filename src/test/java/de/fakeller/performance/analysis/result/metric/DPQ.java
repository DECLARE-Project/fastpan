package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.metric.aggregate.AggregateMetricTest;
import de.fakeller.performance.analysis.result.quantity.AbstractPerformanceQuantity;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.unit.Unitless;
import de.fakeller.performance.analysis.result.valueobject.Percentage;

/**
 * A simple {@link PerformanceQuantity} used for testing.
 *
 * @author Fabian Keller
 */
public class DPQ extends AbstractPerformanceQuantity<Unitless, Percentage> {

    public static DPQ of(double val) {
        return new DPQ(Percentage.of(val));
    }

    protected DPQ(Percentage value) {
        super(value, Unitless.UNITLESS);
    }

    @Override
    protected String getHumanReadableDescription() {
        return "DPQ";
    }

    @Override
    public double value() {
        return this.value.getPercentage();
    }

    @Override
    public PerformanceQuantity wrap(double value, Unitless unit) {
        return new DPQ(Percentage.of(value));
    }
}
