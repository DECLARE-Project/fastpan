package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Represents the min value of the {@link PerformanceQuantity}.
 *
 * @param <Q>
 */
public class MinMetric<Q extends PerformanceQuantity> extends AbstractAggregateMetric<Q> implements CollectiveMetric<Q> {

    public MinMetric(final Q mean) {
        super(mean);
    }

    @Override
    public String toHumanReadable() {
        return "min=" + this.aggregate.toHumanReadable();
    }
}