package de.fakeller.performance.analysis.result.metric.probabilistic;

import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;
import de.fakeller.performance.analysis.result.valueobject.statistics.StandardDeviation;
import de.fakeller.performance.analysis.result.valueobject.statistics.Variance;

/**
 * Represents a normal distribution of the metric, parametrized by the mean mu and the variance sigma.
 */
public class NormalDistributionMetric<Q extends PerformanceQuantity> implements ProbabilisticMetric<Q> {

    private Q mu;
    private Variance sigma;

    public NormalDistributionMetric(Q mu, StandardDeviation std) {
        this(mu, new Variance(std.getStandardDeviation() * std.getStandardDeviation()));
    }

    public NormalDistributionMetric(Q mu, Variance sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }

    @Override
    public boolean isOfType(Class<? extends PerformanceQuantity> type) {
        return false;
    }

    @Override
    public String toHumanReadable() {
        return String.format("N(mu=%.4f, sigma=%.4f)", mu.value(), sigma.getVariance());
    }

    public Q getMu() {
        return mu;
    }

    public Variance getSigma() {
        return sigma;
    }
}
