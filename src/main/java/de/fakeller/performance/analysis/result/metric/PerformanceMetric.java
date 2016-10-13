package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.valueobject.ValueObject;

public interface PerformanceMetric<T extends PerformanceQuantity> extends ValueObject {
    boolean isOfType(Class<? extends PerformanceQuantity> type);
}