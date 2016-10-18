package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * A collective metric represents a set of unique metrics, such as aggregation functions or distribution functions do.
 *
 * @param <Q>
 */
public interface CollectiveMetric<Q extends PerformanceQuantity> extends PerformanceMetric<Q> {

}