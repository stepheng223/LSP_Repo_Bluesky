# Question 2 Answers

## Design Explanation

The Template Method pattern is used in the `Report` abstract class. The `generateReport()` method defines the fixed workflow: `loadData()`, `formatHeader()`, `formatBody()`, and `formatFooter()`. The subclasses `StudentReport` and `CourseReport` provide the report-specific implementations of those steps. The driver uses a `List<Report>` and calls `generateReport()` polymorphically, allowing different report types to follow the same workflow while producing different output.
