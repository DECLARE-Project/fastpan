package de.fakeller.performance.analysis.result;

/**
 * Interface is used by performance analyis approaches to store performance analysis results.
 *
 * @param <T> The top most node of the model to which performance results are attached.
 */
public interface PerformanceResultWriter<T> {

    /**
     * Stores a single performance result.
     */
    void attach(Result<T> result);

    /**
     * Returns the actual performance result.
     */
    PerformanceResult<T> get();
}
