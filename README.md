# Performance

A framework for model-agnostic software performance analysis. The framework currently features:

- An opinionated way to define performance analyzers
- A strictly-typed definition of analysis results 

> **Attention:** This project is a work in progress and as such, the API is unstable and may change anytime. For recent changes refer to the change log.


## Installation

- Check out this project from source.
- Hop on a shell and run `mvn clean install`. You may also do this from your favorite IDE.

#### Export as Library:

You may export this project as standalone JAR library including all required dependencies by running `mvn clean package`. The JAR file is then created in `/target/*.jar`.


## Usage

TBD


## Roadmap

- Define an abstraction for the analysis of variability-aware models.


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