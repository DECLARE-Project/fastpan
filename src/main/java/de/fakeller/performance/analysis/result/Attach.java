package de.fakeller.performance.analysis.result;

import de.fakeller.performance.analysis.result.metric.DirectMetric;
import de.fakeller.performance.analysis.result.metric.PerformanceMetric;
import de.fakeller.performance.analysis.result.metric.aggregate.*;
import de.fakeller.performance.analysis.result.metric.probabilistic.NormalDistributionMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.quantity.RelativeThroughput;
import de.fakeller.performance.analysis.result.quantity.ServiceTime;
import de.fakeller.performance.analysis.result.quantity.Utilization;
import de.fakeller.performance.analysis.result.quantity.time.BusyTime;
import de.fakeller.performance.analysis.result.quantity.time.IdleTime;
import de.fakeller.performance.analysis.result.unit.ThroughputUnit;
import de.fakeller.performance.analysis.result.valueobject.Duration;
import de.fakeller.performance.analysis.result.valueobject.NormalPercentage;
import de.fakeller.performance.analysis.result.valueobject.Percentage;
import de.fakeller.performance.analysis.result.valueobject.statistics.StandardDeviation;
import de.fakeller.performance.analysis.result.valueobject.statistics.Variance;

/**
 * This is a builder for {@link AttachedResult}s. The builder features a nice API for all out-of-the-box
 * {@link PerformanceQuantity}s and {@link PerformanceMetric}s.
 * <p>
 * The API allows to concisely create results:
 * <p>
 * <code>
 * Result res = Attach.to(element).serviceTime(Duration.of(240)).mean();
 * </code>
 */
public class Attach<T> {

    private final T attachedTo;
    private PerformanceQuantity<?> quantity;

    private Attach(final T attachedTo) {
        this.attachedTo = attachedTo;
    }

    public static <T> Attach<T>.QuantityBuilder to(final T attachedTo) {
        assert null != attachedTo;
        return new Attach<>(attachedTo).new QuantityBuilder();
    }


    public class QuantityBuilder {

        private QuantityBuilder() {
        }

        public MetricBuilder serviceTime(final Duration time) {
            Attach.this.quantity = new ServiceTime(time);
            return new MetricBuilder();
        }

        public MetricBuilder busyTime(final Duration time) {
            Attach.this.quantity = new BusyTime(time);
            return new MetricBuilder();
        }

        public MetricBuilder idleTime(final Duration time) {
            Attach.this.quantity = new IdleTime(time);
            return new MetricBuilder();
        }

        public MetricBuilder relativeThroughput(final NormalPercentage relativeThroughput, final ThroughputUnit unit) {
            Attach.this.quantity = new RelativeThroughput(relativeThroughput, unit);
            return new MetricBuilder();
        }

        public MetricBuilder utilization(final Percentage utilization) {
            Attach.this.quantity = new Utilization(utilization);
            return new MetricBuilder();
        }
    }

    public class MetricBuilder {

        private MetricBuilder() {
            assert null != Attach.this.quantity;
        }

        public Result<T> direct() {
            return get(new DirectMetric<>(Attach.this.quantity));
        }

        public Result<T> min() {
            return get(new MinMetric<>(Attach.this.quantity));
        }

        public Result<T> max() {
            return get(new MaxMetric<>(Attach.this.quantity));
        }

        public Result<T> mean() {
            return get(new MeanMetric<>(Attach.this.quantity));
        }

        public Result<T> median() {
            return get(new MedianMetric<>(Attach.this.quantity));
        }

        public Result<T> sum() {
            return get(new SumMetric<>(Attach.this.quantity));
        }

        public Result<T> normalDistribution(final Variance sigma) {
            return get(new NormalDistributionMetric<>(Attach.this.quantity, sigma));
        }

        public Result<T> normalDistribution(final StandardDeviation sigma) {
            return get(new NormalDistributionMetric<>(Attach.this.quantity, sigma));
        }

        private Result<T> get(final PerformanceMetric metric) {
            return new AttachedResult<T>(Attach.this.attachedTo, metric);
        }
    }
}
