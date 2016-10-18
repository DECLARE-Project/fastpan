package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Represents a singular performance metric, such as the utilization at a certain point in time.
 * <p>
 * If you are looking to implement a metric that represents a collection of performance metrics, you should use
 * {@link CollectiveMetric} instead.
 *
 * @param <Q>
 */
public interface SingularMetric<Q extends PerformanceQuantity> extends PerformanceMetric<Q> {
    Q getMetric();
}