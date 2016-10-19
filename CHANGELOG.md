# Change Log

This file keeps track of all changes to this project. This project follows [semantic versioning](http://semver.org/) and [keeps a change log](http://keepachangelog.com/).

> Please [view this change log on the master branch](https://github.com/DECLARE-Project/fastpan/blob/master/CHANGELOG.md), as otherwise it is probably outdated.


## [UNRELEASED]

### Added
- Convenient builder for `Result`s: `de.fakeller.performance.analysis.result.Attach`.

### Changed
- `BusyTime`/`IdleTime` do not require a time unit anymore. Times are in milliseconds by default.


## v0.2.0 - 2016-10-18

### Changed
- A `PerformanceResult` is now attached to an element and has a `PerformanceMetric` (which is to be seen as some mathematical operation, such as `mean()`). The `PerformanceMetric` itself then contains a `PerformanceQuantity` that reasons about the actual value and unit.


## v0.1.2 - 2016-10-12

### Added
- Added `getMetric()` to `PerformanceResult`.


## v0.1.1 - 2016-10-12 [Maintenance Release]

No changes


## v0.1.0 - 2016-10-12

### Changed
- The project has been named "fastpan". The naming has been updated throughput the project. Check your maven dependencies.

### Added
- Define variability analyzer abstraction with a simplified feature model.


## v0.0.2 - 2016-10-11

### Changed
- Maven groupId from `de.fabiankeller.performance` to `de.fakeller.performance`.


## v0.0.1 - 2016-10-11

### Added
- First draft of performance analyzer abstraction extracted from the [palladio headless](https://github.com/DECLARE-Project/palladio-headless) project.
 
### Changed
- Changed package namespace from `de.fabiankeller.*` to `de.fakeller.*` to comply with Java naming conventions.