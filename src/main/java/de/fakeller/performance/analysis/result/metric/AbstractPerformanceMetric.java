package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

abstract public class AbstractPerformanceMetric<Q extends PerformanceQuantity> implements PerformanceMetric<Q> {

    public final Class<Q> clazz;

    public AbstractPerformanceMetric(final Class<Q> clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean isOfType(final Class<? extends PerformanceQuantity> type) {
        return this.clazz.equals(type);
    }
}