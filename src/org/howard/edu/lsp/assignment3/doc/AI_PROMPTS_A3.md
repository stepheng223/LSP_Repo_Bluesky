
---

```md
# AI Prompts & Excerpts – Assignment 3

## Prompt 1 – Object-Oriented Decomposition

**Prompt:**  
Suggest an object-oriented redesign for my Java ETL pipeline. The new version must preserve the exact same behavior, inputs, outputs, transformations, and error handling.

**AI Response Excerpt:**  
The AI suggested separating responsibilities into classes such as a Reader, Writer, Record model, Pipeline controller, and Transformer interface.

**How I Used It:**  
I adopted this structure by introducing CsvProductReader, CsvProductWriter, ProductRecord, ETLPipeline, and a Transformer interface. I ensured transformation order and logic remained identical to Assignment 2.

---

## Prompt 2 – Polymorphism Strategy

**Prompt:**  
How can I apply polymorphism to transformation logic in a Java ETL pipeline?

**AI Response Excerpt:**  
The AI recommended using a Transformer interface with multiple implementing classes for each transformation rule.

**How I Used It:**  
I implemented a Transformer interface and created multiple transformation classes such as UppercaseNameTransformer, ElectronicsDiscountTransformer, PremiumCategoryTransformer, and PriceRangeTransformer.

---

## Prompt 3 – Encapsulation of CSV Rows

**Prompt:**  
Should CSV rows be modeled as objects in an object-oriented ETL design?

**AI Response Excerpt:**  
The AI explained that representing rows as objects improves encapsulation and maintainability.

**How I Used It:**  
I introduced the ProductRecord class to encapsulate product fields rather than manipulating raw string arrays.

---

## Prompt 4 – Error Handling Consistency

**Prompt:**  
How can I redesign my pipeline without changing existing behavior or error handling?

**AI Response Excerpt:**  
The AI emphasized preserving validation logic, transformation order, and output formatting.

**How I Used It:**  
I carefully migrated Assignment 2 logic into Assignment 3 classes without modifying transformation rules, row-skipping logic, or summary output.

---

## Prompt 5 – Javadocs & Code Documentation

**Prompt:**  
Generate Javadocs for ETL-related classes in Java.

**AI Response Excerpt:**  
The AI provided documentation templates for classes and methods.

**How I Used It:**  
I reviewed and edited generated Javadocs to ensure accuracy and alignment with my implementation.