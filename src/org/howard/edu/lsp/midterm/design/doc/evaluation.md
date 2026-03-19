# Design Evaluation

The `OrderProcessor` class has several object-oriented design problems because it combines many unrelated responsibilities into a single class. It holds order data, calculates tax, applies discounts, prints a receipt, saves data to a file, sends a confirmation message, and logs activity. This creates a class that is doing too much, which makes the design harder to understand, test, and maintain.

Another major issue is poor encapsulation. The fields `customerName`, `email`, `item`, and `price` are all public, which means other parts of the program can directly change the state of an `OrderProcessor` object without any control. This makes the object more fragile and increases the chance of invalid or inconsistent data.

The class is also tightly coupled to specific implementation details. For example, it directly uses `System.out.println`, `FileWriter`, and `Date` inside `processOrder()`. Because of this, the class is tied to console output, file storage, and a specific logging style. If the system later needs to save orders to a database, send real emails, or use a different logging mechanism, the class would need to be modified instead of simply collaborating with different helper classes.

The pricing logic is also not well designed. Tax and discount rules are hardcoded directly in the method. This makes the code less flexible because business rules often change over time. A better design would place pricing and discount behavior in a separate class responsible for calculations.

There is also a workflow problem in the method. The total is printed and written to the file before the discount is applied. That means the receipt and stored order information may not match the final discounted amount. This shows that the method mixes responsibilities in a way that makes mistakes easier to introduce.

Overall, the design has weak separation of concerns, poor encapsulation, and high coupling. A better object-oriented design would divide these responsibilities across multiple classes so that each class has a clearer purpose and the system is easier to extend and maintain.