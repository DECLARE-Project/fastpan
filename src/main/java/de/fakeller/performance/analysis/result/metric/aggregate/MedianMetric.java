package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Represents the median of the {@link PerformanceQuantity}.
 *
 * @param <Q>
 */
public class MedianMetric<Q extends PerformanceQuantity> extends AbstractAggregateMetric<Q> implements CollectiveMetric<Q> {

    public MedianMetric(final Q mean) {
        super(mean);
    }

    @Override
    public String toHumanReadable() {
        return "median=" + this.aggregate.toHumanReadable();
    }
}