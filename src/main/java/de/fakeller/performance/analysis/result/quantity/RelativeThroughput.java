package de.fakeller.performance.analysis.result.quantity;

import de.fakeller.performance.analysis.result.unit.ThroughputUnit;
import de.fakeller.performance.analysis.result.valueobject.NormalPercentage;

/**
 * Defines the relative throughput of a single constrained resource, i.e. the number of time slices the resource is
 * utilized divided by the number of all available time slices.
 */
public class RelativeThroughput extends AbstractPerformanceQuantity<ThroughputUnit, NormalPercentage> {

    public RelativeThroughput(final NormalPercentage throughput, final ThroughputUnit unit) {
        super(throughput, unit);
    }

    public NormalPercentage getThroughput() {
        return this.value;
    }


    @Override
    protected String getHumanReadableDescription() {
        return "RelativeThroughput";
    }

    @Override
    public double value() {
        return this.value.getPercentage();
    }

    @Override
    public PerformanceQuantity wrap(final double value, final ThroughputUnit unit) {
        return new RelativeThroughput(NormalPercentage.of(value), unit);
    }
}
