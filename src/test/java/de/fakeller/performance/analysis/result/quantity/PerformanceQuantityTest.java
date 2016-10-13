package de.fakeller.performance.analysis.result.quantity;

import de.fakeller.performance.analysis.result.unit.ThroughputUnit;
import de.fakeller.performance.analysis.result.unit.TimeUnit;
import de.fakeller.performance.analysis.result.unit.Unit;
import de.fakeller.performance.analysis.result.unit.Unitless;
import de.fakeller.performance.analysis.result.valueobject.Duration;
import de.fakeller.performance.analysis.result.valueobject.NormalPercentage;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * @author Fabian Keller
 */
public class PerformanceQuantityTest {

    @Test
    public void testServiceTime() throws Exception {
        testQuantity(d -> new ServiceTime(Duration.ofMilliseconds(d)), TimeUnit.MILLISECONDS);
    }

    @Test
    public void testUtilization() throws Exception {
        testQuantity(d -> new Utilization(NormalPercentage.of(d)), Unitless.UNITLESS);
    }

    @Test
    public void testRelativeThroughput() throws Exception {
        testQuantity(d -> new RelativeThroughput(NormalPercentage.of(d), ThroughputUnit.MESSAGES), ThroughputUnit.MESSAGES);
    }


    private void testQuantity(final Function<Double, PerformanceQuantity> q, final Unit<?> unit) {
        final PerformanceQuantity st1 = q.apply(0.240);
        final PerformanceQuantity st2 = q.apply(0.241);

        assertQuantity(st1, 0.240, unit);
        assertQuantity(st2, 0.241, unit);

        assertEquals(q.apply(0.240), st1);
        assertNotEquals(st2, st1);

        assertNotNull(st1.toHumanReadable());
        assertNotEquals("", st1.toHumanReadable().trim());
    }


    private void assertQuantity(final PerformanceQuantity sut, final double expectedValue, final Unit<?> expectedUnit) {
        assertSame(sut.unit(), expectedUnit);
        assertEquals(sut.value(), expectedValue, Double.MIN_VALUE);
    }

}