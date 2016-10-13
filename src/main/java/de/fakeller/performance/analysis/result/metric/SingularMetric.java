package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

public interface SingularMetric<T extends PerformanceQuantity> extends PerformanceMetric<T> {
    T getMetric();
}