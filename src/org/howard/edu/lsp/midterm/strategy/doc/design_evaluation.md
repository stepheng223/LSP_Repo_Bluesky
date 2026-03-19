# Design Evaluation

The original `PriceCalculator` class works, but its design makes the system harder to maintain and extend. The method uses a series of `if` statements to decide which pricing rule to apply based on a string value. This places all discount behavior in one method instead of separating each pricing rule into its own focused class.

One problem is that the class is not easily extensible. If a new customer type or discount rule needs to be added, the `calculatePrice` method must be modified. This means the class is not well designed for growth, because every new pricing rule requires changing existing code.

Another issue is that the method depends on string comparisons such as `"REGULAR"` and `"VIP"`. This makes the design more fragile because spelling mistakes or inconsistent values can lead to incorrect behavior. It also mixes the responsibility of selecting a discount rule with the responsibility of performing the calculation, which weakens the object-oriented structure.

As the system grows, this design becomes harder to test, maintain, and reuse because all pricing logic remains in one place. A better approach is to separate each discount behavior into its own strategy class. Using the Strategy Pattern makes the design more flexible, easier to extend, and better aligned with object-oriented principles.