package de.fakeller.performance.analysis.result.metric.probabilistic;

import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Allows to express the value of a metric in probabilistic terms.
 */
public interface ProbabilisticMetric<Q extends PerformanceQuantity> extends CollectiveMetric<Q> {

}
