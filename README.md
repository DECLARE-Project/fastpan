# fastpan

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
    <version>v0.1.2</version>
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