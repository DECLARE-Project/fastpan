package de.fakeller.performance.analysis.result;

import de.fakeller.performance.analysis.result.metric.DirectMetric;
import de.fakeller.performance.analysis.result.quantity.RelativeThroughput;
import de.fakeller.performance.analysis.result.quantity.ServiceTime;
import de.fakeller.performance.analysis.result.quantity.Utilization;
import de.fakeller.performance.analysis.result.unit.ThroughputUnit;
import de.fakeller.performance.analysis.result.valueobject.Duration;
import de.fakeller.performance.analysis.result.valueobject.NormalPercentage;
import de.fakeller.performance.analysis.result.valueobject.Percentage;

/**
 * Interface is used by performance analyis approaches to store performance analysis results.
 *
 * @param <T> The top most node of the model to which performance results are attached.
 */
public interface PerformanceResultWriter<T> {

    /**
     * Stores a single performance result.
     */
    void attach(Result<T> result);

    /**
     * Returns the actual performance result.
     */
    PerformanceResult<T> get();

    default void attachUtilization(final T to, final double utilization) {
        this.attach(new AttachedResult<T>(to, new DirectMetric<Utilization>(new Utilization(Percentage.of(utilization)))));
    }

    default void attachServiceTime(final T to, final Duration duration) {
        this.attach(new AttachedResult<T>(to, new DirectMetric<ServiceTime>(new ServiceTime(duration))));
    }

    default void attachThroughput(final T to, final double throughout, final ThroughputUnit unit) {
        final RelativeThroughput throughput = new RelativeThroughput(NormalPercentage.of(throughout), unit);
        this.attach(new AttachedResult<T>(to, new DirectMetric<RelativeThroughput>(throughput)));
    }
}
