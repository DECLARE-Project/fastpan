package de.fakeller.performance.variability;

import de.fakeller.performance.variability.configuration.BaseConfiguration;
import de.fakeller.performance.variability.configuration.Configuration;

/**
 * Provides the system configured with the given {@link BaseConfiguration}
 */
@FunctionalInterface
public interface SystemProvider<SYSTEM, FEATURE> {

    /**
     * Returns the system model that has all features enabled or disabled as defined in the given {@link BaseConfiguration}.
     */
    SYSTEM systemFor(Configuration<FEATURE> configuration);
}
