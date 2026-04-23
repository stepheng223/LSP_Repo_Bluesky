# Question 5 Answers

Heuristic 1:
Name:
Keep related data and behavior together in the same class.

Explanation:
This improves readability and maintainability because a class is easier to understand when the data it stores and the operations that use that data are located together. In lecture, this idea was illustrated by showing that a class should represent a clear responsibility instead of forcing other classes to reach inside it and manage its internal details. When behavior is placed with the correct object, changes are easier to make because the logic is not scattered across the program.

Heuristic 2:
Name:
Hide implementation details and keep data private.

Explanation:
This improves maintainability because outside code should depend on a class's public behavior, not on how the class stores or manages its data internally. In lecture, this was connected to encapsulation: clients should call meaningful public methods instead of directly changing internal fields or relying on helper methods that should be private. This makes the code safer because the class can protect its own state and change its implementation later without breaking other code.

Heuristic 3:
Name:
A class should have a small, clear public interface.

Explanation:
This improves readability because users of the class only see the operations they actually need. In lecture, this was illustrated by discussing that public methods should represent services the object provides, while internal helper methods should not be exposed. A smaller public interface reduces confusion, prevents misuse, and makes the design easier to maintain.
