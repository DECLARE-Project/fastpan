package de.fakeller.performance.analysis.result.unit;

import de.fakeller.performance.analysis.result.metric.RelativeThroughput;

public enum ThroughputUnit implements Unit<RelativeThroughput> {
    MESSAGES,
    KB,
    MB,
    TB,
    BYTES,
    CALLS
}