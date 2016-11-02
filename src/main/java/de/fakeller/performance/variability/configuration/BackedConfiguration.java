package de.fakeller.performance.variability.configuration;

/**
 * Interface used to ease the integration of 3rd-party configurations.
 */
public interface BackedConfiguration<CONFIGURATION, FEATURE> extends Configuration<FEATURE> {

    /**
     * Returns the configuration that backs this configuration.
     */
    CONFIGURATION getBackingConfiguration();
}
