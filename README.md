# Decola Tech 2025 Rest API
Simple Java RESTful API created for the "Decola Tech 2025" bootcamp.

## Class Diagram
```mermaid
classDiagram
    class User {
        +String name
        +String email
        +Loan[] loans
    }

    class Loan {
        +Item item
        +String checkoutDate
        +String returnDate
        +String status
    }

    class Item {
        +String name
        +String icon
        +String description
    }

    User "1" *-- "0..*" Loan : has
    Loan "0..*" o--* "1" Item : has
```
