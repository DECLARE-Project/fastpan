package de.fakeller.performance.analysis.result.quantity.time;

import de.fakeller.performance.analysis.result.quantity.AbstractPerformanceQuantity;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.unit.TimeUnit;
import de.fakeller.performance.analysis.result.valueobject.Duration;

/**
 * @author Fabian Keller
 */
abstract public class AbstractTimeQuantity extends AbstractPerformanceQuantity<TimeUnit, Duration> implements TimeQuantity {

    protected AbstractTimeQuantity(Duration value, TimeUnit unit) {
        super(value, unit);
    }

    @Override
    public double value() {
        return this.value.getMilliseconds();
    }
}
