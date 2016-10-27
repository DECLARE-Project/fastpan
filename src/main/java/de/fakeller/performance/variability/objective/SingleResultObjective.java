package de.fakeller.performance.variability.objective;

import de.fakeller.performance.analysis.result.PerformanceResult;
import de.fakeller.performance.analysis.result.Result;

import java.util.Optional;

/**
 * A single result objective selects a certain {@link Result} from a {@link PerformanceResult}.
 * <p>
 * The interface could be used to answer: "Which configuration yields the best ServiceTime for model element X?".
 */
@FunctionalInterface
public interface SingleResultObjective<T> {

    /**
     * Reduces the {@link PerformanceResult} to a single {@link Result} to reason about that.
     * <p>
     * Return an {@link Optional#empty()} in case the given {@link PerformanceResult} does not contain the objective.
     */
    Optional<Result<T>> toObjective(PerformanceResult<T> result);
}
