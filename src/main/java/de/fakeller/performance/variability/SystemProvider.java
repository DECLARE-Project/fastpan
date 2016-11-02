package de.fakeller.performance.variability;

import de.fakeller.performance.variability.configuration.BaseConfiguration;
import de.fakeller.performance.variability.configuration.Configuration;

/**
 * Provides the system configured with the given {@link Configuration}
 */
@FunctionalInterface
public interface SystemProvider<SYSTEM, FEATURE> {

    /**
     * Returns the system model that has all features enabled or disabled as defined in the given {@link Configuration}.
     */
    SYSTEM systemFor(Configuration<FEATURE> configuration);
}
