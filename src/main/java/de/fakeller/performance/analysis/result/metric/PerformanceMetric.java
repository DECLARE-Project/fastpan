package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

public interface PerformanceMetric<T extends PerformanceQuantity> {
    boolean isOfType(Class<? extends PerformanceQuantity> type);
}