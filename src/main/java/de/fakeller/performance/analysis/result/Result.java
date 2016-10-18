package de.fakeller.performance.analysis.result;

import de.fakeller.performance.analysis.result.metric.PerformanceMetric;

/**
 * Represents a single performance analysis result, that is specific for a certain model element.
 *
 * @param <T> constrain the types that a result can be attached to
 */
public interface Result<T> {

    /**
     * Returns the element this result is attached to.
     */
    T attachedTo();

    /**
     * The metric.
     */
    PerformanceMetric<?> value();
}
