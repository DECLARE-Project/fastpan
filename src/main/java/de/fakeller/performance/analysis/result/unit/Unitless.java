package de.fakeller.performance.analysis.result.unit;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

/**
 * Explicitly state that there is no unit for a certain {@link PerformanceQuantity}
 */
public enum Unitless implements Unit<PerformanceQuantity<?>> {
    UNITLESS
}
