package de.fakeller.performance.analysis.result.quantity.time;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.unit.TimeUnit;
import de.fakeller.performance.analysis.result.valueobject.Duration;

/**
 * The busy time of a certain resource is the amount of time that the resource is actually being active or used.
 */
public class BusyTime extends AbstractTimeQuantity {

    public BusyTime(final Duration busytime) {
        super(busytime, TimeUnit.MILLISECONDS);
    }

    @Override
    protected String getHumanReadableDescription() {
        return "Busy time";
    }

    @Override
    public PerformanceQuantity wrap(final double value, final TimeUnit unit) {
        return new BusyTime(Duration.ofMilliseconds(value));
    }
}
