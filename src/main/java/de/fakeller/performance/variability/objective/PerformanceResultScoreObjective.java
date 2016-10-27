package de.fakeller.performance.variability.objective;

import de.fakeller.performance.analysis.result.PerformanceResult;

import java.util.Optional;

/**
 * Reduces a {@link PerformanceResult} to a simple score.
 */
@FunctionalInterface
public interface PerformanceResultScoreObjective {

    /**
     * Assigns a numeric score to a {@link PerformanceResult}.
     * <p>
     * Note: Return an {@link Optional#empty()} if the {@link PerformanceResult} cannot be scored.
     */
    Optional<Double> toObjective(PerformanceResult<?> result);
}
