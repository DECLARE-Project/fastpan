package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

public class DirectMetric<T extends PerformanceQuantity> extends AbstractPerformanceMetric<T> implements SingularMetric<T> {
    public final T val;

    public DirectMetric(final T value) {
        super((Class<T>) value.getClass());
        this.val = value;
    }

    @Override
    public T getMetric() {
        return this.val;
    }

    @Override
    public String toHumanReadable() {
        return this.val.toHumanReadable();
    }
}