package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

abstract public class AbstractPerformanceMetric<T extends PerformanceQuantity> implements PerformanceMetric<T> {

    public final Class<T> clazz;

    public AbstractPerformanceMetric(final Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean isOfType(final Class<? extends PerformanceQuantity> type) {
        return this.clazz.equals(type);
    }
}