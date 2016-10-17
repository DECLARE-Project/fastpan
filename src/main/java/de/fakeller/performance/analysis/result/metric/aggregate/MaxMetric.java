package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Represents the max value of the {@link PerformanceQuantity}.
 *
 * @param <Q>
 */
public class MaxMetric<Q extends PerformanceQuantity> extends AbstractAggregateMetric<Q> implements CollectiveMetric<Q> {

    public MaxMetric(final Q mean) {
        super(mean);
    }

    @Override
    public String toHumanReadable() {
        return "max=" + this.aggregate.toHumanReadable();
    }
}