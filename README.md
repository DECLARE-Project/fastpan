# ![fastpan](fastpan-logo.png?raw=true "fastpan")

[![GitHub tag](https://img.shields.io/github/tag/DECLARE-Project/fastpan.svg?maxAge=30)](https://github.com/DECLARE-Project/fastpan/releases)
[![Travis](https://img.shields.io/travis/DECLARE-Project/fastpan.svg?maxAge=30)](https://travis-ci.org/DECLARE-Project/fastpan)
[![Coverage](https://img.shields.io/codecov/c/github/DECLARE-Project/fastpan.svg?maxAge=30)](https://codecov.io/gh/DECLARE-Project/fastpan)
[![license](https://img.shields.io/github/license/DECLARE-Project/fastpan.svg?maxAge=30)](LICENSE)

A framework for model-agnostic software performance analysis. The framework currently features:

- An opinionated way to define performance analyzers
- A strictly-typed definition of analysis results 

> **Attention:** This project is a work in progress and as such, the API is unstable and may change anytime. For recent changes refer to the change log.


## Installation

### Using Maven

Define a dependency to this project using [JitPack](https://jitpack.io/#DECLARE-Project/fastpan):

```xml
<dependency>
    <groupId>com.github.DECLARE-Project</groupId>
    <artifactId>fastpan</artifactId>
    <version>v0.4.0</version>
</dependency>
```

Make sure to define the JitPack repository: 

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```


### Download a JAR

Download the [latest release](https://github.com/DECLARE-Project/fastpan/releases/latest) from the GitHub releases.

### From Source

- Check out this project from source.
- Hop on a shell and run `mvn clean install`. You may also do this from your favorite IDE.
- You may export this project as standalone JAR library including all required dependencies by running `mvn clean package`. The JAR file is then created in `/target/*.jar`.


## Usage

### Performance Analyzer

To define a performance analyzer, you need to implement two interfaces: `PerformanceAnalyzer` and `AnalysisContext`. Both interfaces are generic and require you to write the analyzer for a certain `<SYSTEM>`, which refers to the class you use to model the system to be analyzed.

The `PerformanceAnalyzer` can be seen as a factory to setup and configure the actual analysis. By doing so, the variability analysis can make use of the analyzer to setup and run the analysis for an arbitrary number of systems. Implementing a `PerformanceAnalyzer` is straightforward:

```java
public class MyAnalyzer implements PerformanceAnalyzer<MySystem, MyAnalysisContext> {

    /**
     * Returns the capabilities of this performance analysis approach.
     */
    Set<AnalysisCapability> capabilities() {
        return new HashSet<>(Arrays.asList(AnalysisCapability.FAST_EXECUTION));
    }

    /**
     * Determines whether the analysis approach supports the given system.
     */
    boolean supports(MySystem system) {
        return true;
    }

    /**
     * Sets up and configures the analysis.
     */
    MyAnalysisContext setupAnalysis(MySystem system) {
        // setup dependencies, configurations, and so on
        return new MyAnalysisContext(system);
    }
}
```

The `AnalysisContext` now defines the actual analysis and provides the results:


```java
public class MyPerformanceResult extends AbstractPerformanceResult { 
    // tailor the result to provide additional context for MySystem
}

public class MyAnalysisContext implements AnalysisContext<MySystem> {

    private MySystem system;
    public MyAnalysisContext(MySystem system) { this.system = system; }

    /**
     * Runs the analysis and yields the performance results.
     */
    PerformanceResult<?> analyze() {
        // do some heavy computation
        
        MyPerformanceResult result = new MyPerformanceResult();
        // attach a mean service time of 240ms to a specific element of MySystem
        result.attach(Attach.to(mySystemElement).serviceTime(Duration.ofMilliseconds(240)).mean());
        return result;
    }
}
```


### Variability Analyzer

TBD.


## In the Wild

There are performance analyzers in the wild using this abstraction. Take them and integrate them into your project.


#### Performance Analyzers

* **[palladio-headless](https://github.com/DECLARE-Project/palladio-headless)**: Binds to the Palladio LQNS solver to deliver analysis results. Works without Eclipse and is open to be extended by more analyzers of the Palladio tool suite.


#### Variability Analyzers

* **[fastpan-variability-analyzer](https://github.com/DECLARE-Project/fastpan-variability-analyzer)**: Provides a decision-tree based approach to analyze a variability-aware performance model.


Want to add your analyzer to the list? [Just submit a pull request.](https://github.com/DECLARE-Project/fastpan-variability-analyzer/pull/new/master)


## Release

To release a new version, run the following commands:

```sh
mvn release:prepare
mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"
```


## Contributing

Open a PR :-)


## [Change Log](CHANGELOG.md)

See all changes made to this project in the [change log](CHANGELOG.md). This project follows [semantic versioning](http://semver.org/).


## [License](LICENSE)

This project is licensed under the terms of the [MIT license](LICENSE).


---

Project created and maintained by [Fabian Keller](http://www.fabian-keller.de) in the scope of his master's thesis.