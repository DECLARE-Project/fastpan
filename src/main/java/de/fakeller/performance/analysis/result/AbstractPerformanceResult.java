package de.fakeller.performance.analysis.result;

import de.fakeller.performance.analysis.result.metric.PerformanceMetric;
import de.fakeller.performance.analysis.result.quantity.PerformanceQuantity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Provides a base class to implement the {@link PerformanceResult} and {@link PerformanceResultWriter} interfaces.
 */
abstract public class AbstractPerformanceResult<T> implements PerformanceResult<T>, PerformanceResultWriter<T> {

    /**
     * Stores the actual results.
     */
    private final Map<T, List<Result<T>>> results = new LinkedHashMap<>();

    @Override
    public void attach(final Result<T> result) {
        final T key = result.attachedTo();
        if (!this.results.containsKey(key)) {
            this.results.put(key, new ArrayList<>());
        }
        this.results.get(key).add(result);
    }

    @Override
    public PerformanceResult<T> get() {
        return this;
    }

    @Override
    public boolean hasResults() {
        return this.results.size() > 0;
    }

    @Override
    public Collection<Result<T>> getResults() {
        assert this.hasResults();
        // return a flat view on all results
        return this.results
                .entrySet()
                .stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Set<T> getElementsHavingResults() {
        assert this.hasResults();
        return this.results.keySet();
    }

    @Override
    public boolean hasResults(final T element) {
        return this.results.containsKey(element) && this.results.get(element).size() > 0;
    }

    @Override
    public Collection<Result<T>> getResults(final T element) {
        assert this.hasResults(element);
        return this.results.get(element);
    }

    @Override
    public <M extends PerformanceQuantity> Optional<PerformanceMetric<M>> getMetric(final T element, final Class<M> metricClazz) {
        if (!this.results.containsKey(element)) {
            return Optional.empty();
        }
        for (final Result res : this.results.get(element)) {
            final PerformanceMetric metric = res.value();
            if (metric.isOfType(metricClazz)) {
                return Optional.of((PerformanceMetric<M>) metric);
            }
        }
        return Optional.empty();
    }
}
