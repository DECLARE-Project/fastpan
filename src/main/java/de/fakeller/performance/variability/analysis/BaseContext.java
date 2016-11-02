package de.fakeller.performance.variability.analysis;

import de.fakeller.performance.analysis.AnalysisContext;
import de.fakeller.performance.analysis.PerformanceAnalyzer;
import de.fakeller.performance.analysis.result.PerformanceResult;
import de.fakeller.performance.variability.SystemProvider;
import de.fakeller.performance.variability.VariabilityContext;
import de.fakeller.performance.variability.configuration.Configuration;
import de.fakeller.performance.variability.configuration.ConfigurationProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * See {@link BaseAnalyzer} for a description.
 *
 * @author Fabian Keller
 */
public class BaseContext<SYSTEM, FEATURE> implements VariabilityContext<SYSTEM, FEATURE> {

    private final ConfigurationProvider<FEATURE> configurationProvider;
    private final SystemProvider<SYSTEM, FEATURE> systemProvider;
    private final PerformanceAnalyzer<SYSTEM, AnalysisContext<SYSTEM>> analyzer;
    private final Map<Configuration<FEATURE>, PerformanceResult<?>> results = new HashMap<>();

    public BaseContext(final ConfigurationProvider<FEATURE> configurationProvider, final SystemProvider<SYSTEM, FEATURE> systemProvider, final PerformanceAnalyzer<SYSTEM, AnalysisContext<SYSTEM>> analyzer) {
        this.configurationProvider = configurationProvider;
        this.systemProvider = systemProvider;
        this.analyzer = analyzer;
    }

    @Override
    public void analyze() {
        this.configurationProvider.configurations().forEachRemaining(config -> {
            final SYSTEM system = this.systemProvider.systemFor(config);
            final PerformanceResult<?> result = this.analyzer.setupAnalysis(system).analyze();
            this.results.put(config, result);
        });
    }

    /**
     * Returns a map associating each configuration to its {@link PerformanceResult}.
     */
    public Map<Configuration<FEATURE>, PerformanceResult<?>> getResults() {
        return this.results;
    }
}
