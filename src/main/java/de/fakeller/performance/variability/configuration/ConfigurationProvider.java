package de.fakeller.performance.variability.configuration;

import java.util.Iterator;

/**
 * Provides a list of configurations.
 */
@FunctionalInterface
public interface ConfigurationProvider<FEATURE> {

    /**
     * Returns an iterator that is capable of iterating over a set of configurations.
     */
    Iterator<Configuration<FEATURE>> configurations();
}
