package de.fakeller.performance.analysis.result.quantity.time;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.unit.TimeUnit;
import de.fakeller.performance.analysis.result.valueobject.Duration;

/**
 * The busy time of a certain resource is the amount of time that the resource is actually being active or used.
 */
public class BusyTime extends AbstractTimeQuantity {

    public BusyTime(Duration busytime, TimeUnit unit) {
        super(busytime, unit);
    }

    @Override
    protected String getHumanReadableDescription() {
        return "Busy time";
    }

    @Override
    public PerformanceQuantity wrap(double value, TimeUnit unit) {
        return new BusyTime(Duration.ofMilliseconds(value), unit);
    }
}
