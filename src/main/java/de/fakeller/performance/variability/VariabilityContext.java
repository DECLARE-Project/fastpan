package de.fakeller.performance.variability;

/**
 * Provides a stateful variability-aware analysis.
 *
 * @param <SYSTEM>  the representation of the model to analyze
 * @param <FEATURE> the feature model that is used to represent configurations
 */
public interface VariabilityContext<SYSTEM, FEATURE> {

    /**
     * Runs the analysis and yields the variability analysis result.
     * <p>
     * The results cannot be generalized as a variability analysis may provide answers to different questions:
     * - Which configuration has the best result (for the model in general, or for a specific part)?
     * - Which configurations violate the performance requirements?
     * <p>
     * Therefore, we leave the result generation to the context implementation.
     * <p>
     * Note: The analyze() method should only be called once.
     */
    void analyze();
}
