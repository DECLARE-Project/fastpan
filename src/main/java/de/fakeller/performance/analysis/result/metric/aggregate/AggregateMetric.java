package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Defines a metric for a certain aggregation function.
 */
public interface AggregateMetric<Q extends PerformanceQuantity> extends CollectiveMetric<Q> {

    /**
     * Returns the aggregate {@link PerformanceQuantity} value.
     */
    Q getAggregate();
}
