package de.fakeller.performance.analysis.result.unit;

import de.fakeller.performance.analysis.result.quantity.RelativeThroughput;

public enum ThroughputUnit implements Unit<RelativeThroughput> {
    // // general // //

    /**
     * The number of user requests served.
     */
    REQUESTS,

    /**
     * The number of messages sent (email, message queue, ...)
     */
    MESSAGES,

    // // data amount // //
    BYTES,
    KILOBYTE,
    MEGABYTE,
    GIGABYTE,
    TERABYTE,
    PETABYTE,
    EXABYTE,
    ZETTABYTE,
    YOTTABYTE,

    // // misc // //
    OTHER
}