package de.fakeller.performance.variability.analysis;

import de.fakeller.performance.analysis.AnalysisCapability;
import de.fakeller.performance.analysis.AnalysisContext;
import de.fakeller.performance.analysis.PerformanceAnalyzer;
import de.fakeller.performance.variability.SystemProvider;
import de.fakeller.performance.variability.configuration.ConfigurationProvider;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * @author Fabian Keller
 */
public class BaseAnalyzerTest {

    private PerformanceAnalyzer<String, AnalysisContext<String>> analyzer;
    private BaseAnalyzer<String, String> sut;


    @Before
    public void setUp() throws Exception {
        this.analyzer = mock(PerformanceAnalyzer.class);
        this.sut = new BaseAnalyzer<>(this.analyzer);
    }

    @Test
    public void capabilities() throws Exception {
        final Set<AnalysisCapability> capabilities = new HashSet<>();
        when(this.analyzer.capabilities()).thenReturn(capabilities);
        assertSame(capabilities, this.sut.capabilities());
        verify(this.analyzer, times(1)).capabilities();
    }

    @Test
    public void setupAnalysis() throws Exception {
        assertNotNull(this.sut.setupAnalysis(mock(ConfigurationProvider.class), mock(SystemProvider.class)));
    }

}