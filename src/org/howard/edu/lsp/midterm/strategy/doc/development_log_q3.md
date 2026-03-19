# Development Log - Question 3

I began by analyzing the original `PriceCalculator` class and identifying that the use of multiple conditional statements made the design difficult to extend and maintain. I recognized that each discount type represented a separate behavior, which made the Strategy Pattern an appropriate solution.

I designed the solution by creating a common interface (`DiscountStrategy`) and implementing separate classes for each discount type (Regular, Member, VIP, and Holiday). I then refactored the `PriceCalculator` class to use these strategies and created a driver program to verify the required output.

I used ChatGPT as a supporting tool to clarify the structure of the Strategy Pattern and to double-check my implementation approach. It helped me confirm that my design aligned with object-oriented principles and assignment requirements.

All code, structure, and final outputs were implemented, tested, and verified by me.