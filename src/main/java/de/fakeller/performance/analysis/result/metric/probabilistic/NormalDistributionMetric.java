package de.fakeller.performance.analysis.result.metric.probabilistic;

import de.fakeller.performance.analysis.result.metric.AbstractPerformanceMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.valueobject.statistics.StandardDeviation;
import de.fakeller.performance.analysis.result.valueobject.statistics.Variance;

import java.util.Locale;

/**
 * Represents a normal distribution of the metric, parametrized by the mean mu and the variance sigma.
 */
public class NormalDistributionMetric<Q extends PerformanceQuantity> extends AbstractPerformanceMetric<Q> implements ProbabilisticMetric<Q> {

    private Q mu;
    private Variance sigma;

    public NormalDistributionMetric(Q mu, StandardDeviation std) {
        this(mu, new Variance(std.getStandardDeviation() * std.getStandardDeviation()));
    }

    public NormalDistributionMetric(Q mu, Variance sigma) {
        super((Class<Q>) mu.getClass());
        this.mu = mu;
        this.sigma = sigma;
    }

    @Override
    public boolean isOfType(Class<? extends PerformanceQuantity> type) {
        return false;
    }

    @Override
    public String toHumanReadable() {
        return String.format(Locale.ROOT, "N(mu=(%s), sigma=%.4f)", mu.toHumanReadable(), sigma.getVariance());
    }

    public Q getMu() {
        return mu;
    }

    public Variance getSigma() {
        return sigma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NormalDistributionMetric<?> that = (NormalDistributionMetric<?>) o;

        if (!mu.equals(that.mu)) return false;
        return sigma.equals(that.sigma);

    }

    @Override
    public int hashCode() {
        int result = mu.hashCode();
        result = 31 * result + sigma.hashCode();
        return result;
    }
}
