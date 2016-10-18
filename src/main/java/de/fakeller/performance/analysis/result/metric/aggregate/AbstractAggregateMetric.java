package de.fakeller.performance.analysis.result.metric.aggregate;

import de.fakeller.performance.analysis.result.metric.AbstractPerformanceMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Ensure value object characteristics for aggregate metrics.
 */
abstract public class AbstractAggregateMetric<Q extends PerformanceQuantity> extends AbstractPerformanceMetric<Q> implements AggregateMetric<Q> {

    protected final Q aggregate;

    public AbstractAggregateMetric(final Q aggregate) {
        super((Class<Q>) aggregate.getClass());
        this.aggregate = aggregate;
    }

    @Override
    public Q getAggregate() {
        return this.aggregate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final AbstractAggregateMetric<?> that = (AbstractAggregateMetric<?>) o;

        return this.aggregate.equals(that.aggregate);

    }

    @Override
    public int hashCode() {
        return this.aggregate.hashCode();
    }
}
