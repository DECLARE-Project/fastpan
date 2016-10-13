package de.fakeller.performance.analysis.result.unit;

import de.fakeller.performance.analysis.result.quantity.TimeQuantity;

/**
 * Time units for {@link TimeQuantity} performance quantities.
 */
public enum TimeUnit implements Unit<TimeQuantity> {
    MILLISECONDS,
    SECONDS,
    MINUTES,
    HOURS,
    DAYS,
    WEEKS,
    MONTHS,
    YEARS
}