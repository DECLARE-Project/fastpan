package de.fakeller.performance.analysis.result.quantity.time;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.unit.TimeUnit;
import de.fakeller.performance.analysis.result.valueobject.Duration;

/**
 * The idle time of a certain resource is the amount of time that the resource is not being active nor used.
 */
public class IdleTime extends AbstractTimeQuantity {

    public IdleTime(final Duration idletime) {
        super(idletime, TimeUnit.MILLISECONDS);
    }

    @Override
    protected String getHumanReadableDescription() {
        return "Idle time";
    }

    @Override
    public PerformanceQuantity wrap(final double value, final TimeUnit unit) {
        return new IdleTime(Duration.ofMilliseconds(value));
    }
}
