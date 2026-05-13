# Java Learning Material - BookStoreApp Project

## Overview

This is a beginner-friendly Java learning project that demonstrates fundamental Object-Oriented Programming (OOP) concepts and design patterns through a practical Bookstore Purchase Management application. The application allows customers to purchase different types of items (Books, Magazines, and Stationery) with dynamic discount calculations based on purchase amounts.

## Java Fundamentals Covered

### 1. Classes and Objects

A class is a blueprint for creating objects. Objects are instances of classes with properties (attributes) and behaviors (methods).

**Example:** The `Customer` class represents a customer with name and phone number properties.

```java
public class Customer {
    private String name;
    private int phoneNum;
    
    public Customer(String name, int phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
}
```

### 2. Constructor

Special method called when an object is created. Used to initialize object properties with values provided during object instantiation.

**Example:** The `Customer` constructor initializes a customer with a name and phone number.

```java
public Customer(String name, int phoneNum) {
    this.name = name;
    this.phoneNum = phoneNum;
}
```

### 3. Getter Methods (Accessors)

Methods that return the values of private attributes. They provide controlled read-only access to object data without allowing direct modification.

**Example:** The `getCustName()` and `getPhoneNum()` methods provide access to customer information.

```java
public String getCustName() {
    return this.name;
}

public int getPhoneNum() {
    return this.phoneNum;
}
```

### 4. Inheritance

A mechanism allowing a class to inherit properties and methods from a parent class, promoting code reuse and establishing a hierarchy.

**Example:** `Book`, `Magazine`, and `Stationary` classes extend the abstract `Item` class.

```java
public class Book extends Item {
    private String bookName;
    private String genre;
    
    public Book(String itemName, String itemID, double price, 
                int itemQuantity, String bookName, String genre) {
        super(itemName, itemID, price, itemQuantity);
        this.bookName = bookName;
        this.genre = genre;
    }
}
```

### 5. Abstract Classes and Methods

Abstract classes cannot be instantiated directly and may contain abstract methods that subclasses must implement. They define a contract for subclasses.

**Example:** The `Item` class is abstract with an abstract method `getDiscountRate()`.

```java
public abstract class Item {
    private String itemName;
    private String itemID;
    private double price;
    private int itemQuantity;
    
    public Item(String itemName, String itemID, double price, int itemQuantity) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.price = price;
        this.itemQuantity = itemQuantity;
    }
    
    public abstract double getDiscountRate(double amountPurchase);
}
```

### 6. Method Overriding

Subclasses provide their own implementation of methods defined in a parent class. Enables polymorphic behavior where different objects respond differently to the same method call.

**Example:** Different item types have different discount structures.

```java
// Book class
@Override
public double getDiscountRate(double amountPurchase) {
    if(amountPurchase > 80 && amountPurchase <= 200) {
        return 0.12;
    } else if(amountPurchase > 200) {
        return 0.25;
    } else {
        return 0.0;
    }
}

// Magazine class
@Override
public double getDiscountRate(double amountPurchase) {
    if(amountPurchase > 80 && amountPurchase <= 200) {
        return 0.5;
    } else if(amountPurchase > 200) {
        return 0.15;
    } else {
        return 0.0;
    }
}
```

### 7. Method Overriding - toString()

Override the default `toString()` method for custom string representation. Provides a readable format when printing objects.

**Example:** Custom toString() for formatted output.

```java
@Override
public String toString() {
    return String.format("Item Name        : %s\nItem ID          : %s\nPrice per unit   : RM%.2f\nQuantity         : %d",
            itemName, itemID, price, itemQuantity);
}
```

### 8. Encapsulation

The practice of bundling data (attributes) and methods together while hiding internal details. Achieved through private attributes and public getter/setter methods.

**Example:** Item class encapsulates all item properties with private visibility and public accessor methods.

```java
public class Item {
    private String itemName;        // Encapsulated: not directly accessible
    private String itemID;
    private double price;
    private int itemQuantity;
    
    public String getItemName() {   // Public accessor method
        return this.itemName;
    }
}
```

### 9. Object Composition

Combining objects to create more complex structures. Objects contain references to other objects to achieve functionality.

**Example:** `CustPurchase` contains `Customer` and `Item` objects.

```java
public class CustPurchase {
    private Customer customer;      // Composition: contains Customer object
    private Item item;              // Composition: contains Item object
    private int purchaseID;
    
    public CustPurchase(Customer customer, Item item, int purchaseID) {
        this.customer = customer;
        this.item = item;
        this.purchaseID = purchaseID;
    }
}
```

### 10. Scanner for User Input

The `Scanner` class from `java.util` package allows reading user input from the console. Essential for interactive applications.

**Example:** Reading customer information.

```java
Scanner in = new Scanner(System.in);
System.out.print("Enter Name: ");
String name = in.nextLine();

System.out.print("Enter Phone Number: ");
int phoneNum = in.nextInt();
in.nextLine();  // Consume the newline character
```

### 11. Conditional Statements

Control program flow based on conditions. The `if-else` statement allows different code blocks to execute based on boolean conditions.

**Example:** Determining discount rates based on purchase amount.

```java
if(amountPurchase > 80 && amountPurchase <= 200) {
    return 0.12;
} else if(amountPurchase > 200) {
    return 0.25;
} else {
    return 0.0;
}
```

### 12. String Formatting

The `String.format()` method creates formatted strings. The `%s` placeholder represents strings, `%.2f` represents floating-point numbers with 2 decimal places, and `%d` represents integers.

**Example:** Creating formatted receipt output.

```java
String.format("Purchase ID      : %d\nAmount Purchase  : RM%.2f\nAfter Discount   : RM%.2f",
    purchaseID, amountPurchase, afterDiscount)
```

### 13. Control Flow - While Loop

A `while` loop repeats a block of code as long as a condition is true. Useful for continuous operation until a termination condition is met.

**Example:** Processing multiple customer purchases until "stop" is entered.

```java
while(true) {
    System.out.print("Enter Name(Type 'stop' to stop): ");
    name = in.nextLine();
    
    if (name.equalsIgnoreCase("stop")) {
        break;
    }
    // Process purchase...
}
```

### 14. Random Number Generation

The `Random` class from `java.util` package generates random numbers. Useful for creating unique identifiers like purchase IDs.

**Example:** Generating a unique purchase ID.

```java
Random rand = new Random();
purchaseID = 10000 + rand.nextInt(90000);  // Generates random ID between 10000-99999
```

### 15. Polymorphism

The ability of objects to take many forms. Allows you to write generic code that works with objects of different types that share a common parent class or interface.

**Example:** Handling different item types (Book, Magazine, Stationary) with the same `Item` reference.

```java
Item item = new Book(itemName, itemID, price, itemQuantity, bookName, genre);
// Or
Item item = new Magazine(itemName, itemID, price, itemQuantity, magazineName, type);
// Or
Item item = new Stationary(itemName, itemID, price, itemQuantity, stationType);

// All can call getDiscountRate() with different implementations
double discount = item.getDiscountRate(amount);
```

## Project Structure

```
BookStoreApp/
├── src/bookstoreapp/
│   ├── BookStoreApp.java           (Main application - entry point)
│   ├── Item.java                   (Abstract class for all items)
│   ├── Book.java                   (Book item subclass)
│   ├── Magazine.java               (Magazine item subclass)
│   ├── Stationary.java             (Stationery item subclass)
│   ├── Customer.java               (Customer information class)
│   └── CustPurchase.java           (Purchase transaction class)
├── build/                          (Compiled class files)
├── nbproject/                      (NetBeans project configuration)
├── build.xml                       (Ant build configuration)
└── README.md                       (This file)
```

## Key Classes

### Item.java (Abstract Base Class)
Represents a generic item with common properties for all store items.

**Attributes:**
- `itemName` (String): Name of the item type
- `itemID` (String): Unique item identifier
- `price` (double): Price per unit
- `itemQuantity` (int): Quantity purchased

**Methods:**
- `getItemName()`: Returns item name
- `getItemID()`: Returns item ID
- `getPrice()`: Returns unit price
- `getItemQuantity()`: Returns quantity
- `getDiscountRate(double)`: Abstract method - subclasses define their own discount logic
- `toString()`: Formats item information for display

### Book.java (Concrete Subclass)
Represents a book in the store with specific book attributes.

**Additional Attributes:**
- `bookName` (String): Title of the book
- `genre` (String): Book genre/category

**Discount Structure:**
- RM80 < amount ≤ RM200: 12% discount
- amount > RM200: 25% discount

### Magazine.java (Concrete Subclass)
Represents a magazine in the store with specific magazine attributes.

**Additional Attributes:**
- `magazineName` (String): Title of the magazine
- `magazineType` (String): Type/category of magazine

**Discount Structure:**
- RM80 < amount ≤ RM200: 5% discount
- amount > RM200: 15% discount

### Stationary.java (Concrete Subclass)
Represents stationery items in the store.

**Additional Attributes:**
- `sType` (String): Type of stationery (e.g., Notebook, Pen)

**Discount Structure:**
- RM80 < amount ≤ RM200: 40% discount
- amount > RM200: 10% discount
- amount ≤ RM80: 10% discount

### Customer.java
Represents a customer making a purchase.

**Attributes:**
- `name` (String): Customer name
- `phoneNum` (int): Customer phone number

**Methods:**
- `getCustName()`: Returns customer name
- `getPhoneNum()`: Returns phone number
- `toString()`: Formats customer information

### CustPurchase.java
Represents a complete purchase transaction linking customer, items, and discount calculations.

**Attributes:**
- `customer` (Customer): Customer object
- `item` (Item): Item being purchased
- `purchaseID` (int): Unique transaction identifier
- `amountPurchase` (double): Total amount before discount
- `afterDiscount` (double): Final amount after discount

**Methods:**
- `calculateDiscount(Item)`: Calculates discount based on item type and purchase amount
- `getAmountPurchase()`: Returns amount before discount
- `getAfterDiscount()`: Returns amount after discount
- `toString()`: Formats complete receipt with all transaction details

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| **Inheritance** | Code reuse through parent-child class relationships |
| **Abstract Classes** | Define common structure for related classes |
| **Polymorphism** | Same method call, different behaviors per object type |
| **Encapsulation** | Hide internal details, control access via getters |
| **Composition** | Build complex objects from simpler objects |
| **Method Overriding** | Customize parent class methods in subclasses |
| **Scanner Input** | Read user input from console |
| **Conditional Logic** | Make decisions based on conditions |
| **String Formatting** | Create formatted output strings |
| **Random Generation** | Create unique identifiers |

## How to Run

### Using NetBeans IDE
1. Open the project in NetBeans
2. Click **Run** → **Run Project** (or press F6)
3. Follow the prompts to enter customer and purchase information

### Using Command Line
**Compile the project:**
```bash
javac -d build/classes src/bookstoreapp/*.java
```

**Run the main application:**
```bash
java -cp build/classes bookstoreapp.BookStoreApp
```

## Expected Output

When you run the application, it will:

1. Display available items (Books, Magazines, Stationery)
2. Prompt for customer information (name and phone number)
3. Ask for item selection and details
4. Generate a unique purchase ID
5. Calculate discount based on item type and purchase amount
6. Display a formatted receipt with all transaction information
7. Allow multiple purchases until "stop" is entered

**Sample Output:**
```
========== Welcome to Bookstore App ==========

------ CUSTOMER INFO ------
Enter Name(Type 'stop' to stop): John Doe
Enter Phone Number: 0123456789

------ ITEM DETAILS ------
Choose item in BookStore(Book/Magazine/Stationary): Book
Type item ID: 1245
Item Price: 13.00
Quantity: 20
Enter Book name: Java Coding
Enter Book genre: Education

==================== RECEIPT ====================
Purchase ID      : 45782

Customer Information:
Name             : John Doe
Phone Number     : 123456789

Item Details:
Item Name        : Book
Item ID          : 1245
Price per unit   : RM13.00
Quantity         : 20
Book Name        : Java Coding
Genre            : Education

Amount Purchase  : RM260.00
After Discount   : RM195.00
=================================================
```

## Project Information

- **Created:** 25/5/2025
- **Language:** Java
- **Programming Level:** Intermediate
- **Topics:** Object-Oriented Programming, Inheritance, Polymorphism, Encapsulation, Composition
- **IDE:** NetBeans (Recommended)
- **Build Tool:** Apache Ant
