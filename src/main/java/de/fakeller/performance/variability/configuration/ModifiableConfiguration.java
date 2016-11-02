package de.fakeller.performance.variability.configuration;

import java.util.Arrays;
import java.util.Collection;

/**
 * A {@link Configuration} that is modifiable.
 */
public interface ModifiableConfiguration<FEATURE> extends Configuration<FEATURE> {

    /**
     * Sets the provided features to enabled.
     */
    ModifiableConfiguration<FEATURE> enable(Collection<FEATURE> features);

    /**
     * Sets the provided features to enabled.
     */
    default ModifiableConfiguration<FEATURE> enable(FEATURE... features) {
        return this.enable(Arrays.asList(features));
    }

    /**
     * Sets all feature flags to enabled.
     */
    ModifiableConfiguration<FEATURE> enableAll();


    /**
     * Sets the provided features to disabled.
     */
    ModifiableConfiguration<FEATURE> disable(Collection<FEATURE> features);

    /**
     * Sets the provided features to disabled.
     */
    default ModifiableConfiguration<FEATURE> disable(FEATURE... features) {
        return this.disable(Arrays.asList(features));
    }

    /**
     * Sets all feature flags to disabled.
     */
    ModifiableConfiguration<FEATURE> disableAll();
}
