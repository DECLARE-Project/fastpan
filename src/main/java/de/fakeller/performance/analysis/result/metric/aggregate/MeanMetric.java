package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.AbstractPerformanceMetric;
import de.fakeller.performance.analysis.result.metric.CollectiveMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

public class MeanMetric<T extends PerformanceQuantity> extends AbstractPerformanceMetric<T> implements CollectiveMetric<T> {
    public final T mean;

    public MeanMetric(final T mean) {
        super((Class<T>) mean.getClass());
        this.mean = mean;
    }

    @Override
    public T getMetric() {
        return this.mean;
    }
}