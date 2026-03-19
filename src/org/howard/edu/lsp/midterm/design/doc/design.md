# Proposed Improved Design Using CRC Cards

Class: Order  
Responsibilities:
- Store order information such as customer name, email, item, and price
- Provide controlled access to order data
- Represent a single customer order
  Collaborators:
- OrderProcessor
- PricingService
- ReceiptPrinter
- OrderRepository
- NotificationService

Class: OrderProcessor  
Responsibilities:
- Coordinate the steps required to process an order
- Delegate calculations, saving, printing, notifications, and logging to the appropriate classes
- Ensure the order is processed in the correct sequence
  Collaborators:
- Order
- PricingService
- ReceiptPrinter
- OrderRepository
- NotificationService
- ActivityLogger

Class: PricingService  
Responsibilities:
- Calculate tax
- Apply discount rules
- Compute the final total for an order
  Collaborators:
- Order

Class: ReceiptPrinter  
Responsibilities:
- Format receipt information
- Print or display the receipt for the processed order
  Collaborators:
- Order
- PricingService

Class: OrderRepository  
Responsibilities:
- Save processed order information
- Handle file or storage operations separately from business logic
  Collaborators:
- Order

Class: NotificationService  
Responsibilities:
- Send confirmation messages to customers
- Keep notification logic separate from order processing
  Collaborators:
- Order

Class: ActivityLogger  
Responsibilities:
- Record when an order is processed
- Keep logging responsibilities separate from the rest of the system
  Collaborators:
- OrderProcessor