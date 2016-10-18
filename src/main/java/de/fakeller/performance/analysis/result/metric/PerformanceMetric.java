package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.quantity.ServiceTime;
import de.fakeller.performance.analysis.result.quantity.Utilization;
import de.fakeller.performance.analysis.result.valueobject.ValueObject;

/**
 * A performance metric represents a certain {@link PerformanceQuantity}, i.e. {@link ServiceTime} or
 * {@link Utilization}. Various metrics exist to express the semantics of the quantity measured:
 * <p>
 * - {@link SingularMetric}: for single values at a certain point in time
 * - {@link CollectiveMetric}: represents a collection of metrics (i.e. the mean value)
 *
 * @param <Q>
 */
public interface PerformanceMetric<Q extends PerformanceQuantity> extends ValueObject {

    /**
     * Determines whether this metric reasons about the given {@link PerformanceQuantity}.
     * <p>
     * For example, you can determine whether this metric reasons about the {@link ServiceTime} by calling:
     * <code>metric.isOfType(ServiceTime.class)</code>
     * In general, metrics of the same type are comparable.
     */
    boolean isOfType(Class<? extends PerformanceQuantity> type);
}