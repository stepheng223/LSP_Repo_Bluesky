# CSCI 363 – Assignment 3 Reflection
## Object-Oriented Redesign of ETL Pipeline

In Assignment 2, I implemented the ETL pipeline primarily using a single class that handled extraction, transformation, loading, and error handling all within the same file. While the program functioned correctly, most of the logic was centralized, meaning one class was responsible for many different tasks.

For Assignment 3, I redesigned the pipeline using a more object-oriented structure while preserving the exact same behavior, inputs, outputs, transformations, error handling, and relative file paths from Assignment 2.

---

## Differences Between Assignment 2 and Assignment 3

### Assignment 2 Design
Assignment 2 used a procedural-style design where:

- A single ETLPipeline class handled file reading, validation, transformation logic, writing output, and printing summaries.
- Data was processed line-by-line directly from the CSV.
- Transformation rules were implemented inline within the main loop.

This approach worked, but it mixed multiple responsibilities into one class.

---

### Assignment 3 Design
In Assignment 3, I separated responsibilities into multiple classes:

- **ETLDriver** – entry point of the program.
- **ETLPipeline** – orchestrates the ETL workflow.
- **CsvProductReader** – responsible for reading and validating input data.
- **CsvProductWriter** – responsible for writing output data.
- **ProductRecord** – represents each row as an object.
- **Transformer Interface** – defines transformation behavior.
- **Transformer Implementations** – handle individual transformation rules.
- **PipelineSummary** – handles counters and reporting.

Instead of performing all logic in one place, the pipeline now coordinates interactions between specialized objects.

---

## How Assignment 3 is More Object-Oriented

Assignment 3 applies object-oriented decomposition by assigning clear responsibilities to different classes.

### Encapsulation
Encapsulation is demonstrated through the `ProductRecord` class. Each product row is represented as an object containing fields such as productId, name, price, and category. These fields are private and accessed through getters and setters, preventing direct external manipulation.

This differs from Assignment 2, where raw strings and arrays were manipulated directly.

---

### Classes and Objects
Assignment 3 introduces explicit modeling of data and behavior:

- Product data is represented as objects rather than temporary variables.
- Each transformation is represented as its own class.

This makes the design easier to understand and extend.

---

### Polymorphism
Polymorphism is implemented through the `Transformer` interface.

Multiple transformation classes implement the same method:

```java
void apply(ProductRecord record)