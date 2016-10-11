package de.fakeller.performance.analysis.result.metric;

import de.fakeller.performance.analysis.result.valueobject.Duration;

/**
 * The time it takes for a single operation to complete.
 */
public class ServiceTime extends AbstractPerformanceMetric<Duration> {

    public ServiceTime(final Duration serviceTime) {
        super(serviceTime);
    }

    public Duration getServiceTime() {
        return this.value;
    }

    @Override
    protected String getHumanReadableDescription() {
        return "Service time";
    }
}
