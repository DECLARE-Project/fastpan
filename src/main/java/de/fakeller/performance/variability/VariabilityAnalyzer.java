package de.fakeller.performance.variability;

import de.fakeller.performance.analysis.AnalysisCapability;
import de.fakeller.performance.variability.configuration.ConfigurationProvider;

import java.util.Set;

/**
 * Interface used to create variability-aware performance analyses of a system.
 * <p>
 * Analyzers implementing this interface do not perform any performance analyses. They simply create and configure a
 * specific {@link VariabilityContext} that is able to execute the actual analysis.
 *
 * @param <SYSTEM>  the representation of the model to analyze
 * @param <CONTEXT> the class that is able to perform the actual performance analysis
 * @param <FEATURE> the feature model that is used to represent configurations
 */
public interface VariabilityAnalyzer<SYSTEM, CONTEXT extends VariabilityContext<SYSTEM, FEATURE>, FEATURE> {

    /**
     * Returns the capabilities of this performance analysis approach.
     */
    Set<AnalysisCapability> capabilities();

    /**
     * Set up and configure the variability-aware analysis.
     *
     * @param configurationProvider the configurations to analyze
     * @param systemProvider        a provider turning configurations into an analyzable system
     */
    CONTEXT setupAnalysis(ConfigurationProvider<FEATURE> configurationProvider, SystemProvider<SYSTEM, FEATURE> systemProvider);
}
