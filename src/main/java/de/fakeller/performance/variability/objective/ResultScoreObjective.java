package de.fakeller.performance.variability.objective;

import de.fakeller.performance.analysis.result.Result;

import java.util.Optional;

/**
 * Reduces a {@link Result} to a simple score.
 */
@FunctionalInterface
public interface ResultScoreObjective {

    /**
     * Assigns a numeric score to a single {@link Result}.
     * <p>
     * Note: Return an {@link Optional#empty()} if the {@link Result} cannot be scored.
     */
    Optional<Double> toObjective(Result<?> result);
}
