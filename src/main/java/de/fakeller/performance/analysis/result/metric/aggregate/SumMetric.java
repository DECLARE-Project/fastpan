package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Represents the sum of the {@link PerformanceQuantity}.
 *
 * @param <Q>
 */
public class SumMetric<Q extends PerformanceQuantity> extends AbstractAggregateMetric<Q> implements CollectiveMetric<Q> {

    public SumMetric(final Q mean) {
        super(mean);
    }

    @Override
    public String toHumanReadable() {
        return String.format("sum(%s)", this.aggregate.toHumanReadable());
    }
}