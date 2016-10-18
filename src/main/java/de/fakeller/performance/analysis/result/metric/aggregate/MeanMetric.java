package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Represents the arithmetic mean of the {@link PerformanceQuantity}.
 *
 * @param <Q>
 */
public class MeanMetric<Q extends PerformanceQuantity> extends AbstractAggregateMetric<Q> implements CollectiveMetric<Q> {

    public MeanMetric(final Q mean) {
        super(mean);
    }

    @Override
    public String toHumanReadable() {
        return String.format("mean(%s)", this.aggregate.toHumanReadable());
    }
}