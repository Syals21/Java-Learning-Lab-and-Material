# Java Learning Material - LabTestAP Project

## Overview

This is a beginner to intermediate-level Java learning project that demonstrates fundamental Object-Oriented Programming (OOP) concepts and exception handling through a practical Product Inventory Management System. The application allows users to manage product inventory by adding products, increasing stock, decreasing stock, and displaying all products with custom exception handling for invalid operations.

## Java Fundamentals Covered

### 1. Classes and Objects
A class is a blueprint for creating objects. Objects are instances of classes with properties (attributes) and behaviors (methods).

**Example:** Product class represents a product in inventory with ID, name, and stock properties.

```java
public class Product {
    String productId;
    String productName;
    int stock;
}
```

### 2. Constructors
Special methods called when an object is created, used to initialize object properties. Can throw exceptions for invalid data.

**Example:** Product constructor validates that stock is never negative:

```java
public Product(String productId, String productName, int stock) throws NegativeStockException {
    if(stock < 0){
        throw new NegativeStockException("Stock can't be negative");
    }
    this.productId = productId;
    this.productName = productName;
    this.stock = stock;
}
```

### 3. Getter Methods (Accessors)
Methods that return the values of private or protected attributes, providing controlled access to object data.

**Example:** Methods to read product properties:

```java
public String getProductId() {
    return productId;
}

public String getProductName() {
    return productName;
}

public int getStock() {
    return stock;
}
```

### 4. Setter Methods (Mutators)
Methods that modify the values of attributes, allowing controlled updates to object state.

**Example:** Methods to modify product properties:

```java
public void setProductId(String productId) {
    this.productId = productId;
}

public void setStock(int stock) {
    this.stock = stock;
}
```

### 5. Method Overriding - toString()
Override the default toString() method for custom string representation, providing a readable format when printing objects.

**Example:** Converting a Product object to a meaningful string format:

```java
@Override
public String toString() {
    return "Product{" + "productId=" + productId + 
           ", productName=" + productName + ", stock=" + stock + '}';
}
```

### 6. Method Overriding - equals()
Override equals() to compare objects based on meaningful attributes rather than object reference.

**Example:** Two products are equal if they have the same product ID:

```java
@Override
public boolean equals(Object obj){
    if(this == obj){
        return true;
    }
    if (obj == null || getClass() != obj.getClass()){
        return false;
    }
    Product other = (Product)obj;
    return this.productId.equalsIgnoreCase(other.productId);
}
```

### 7. Custom Exceptions
Create custom exception classes that extend the Exception class for domain-specific error handling.

**Example:** NegativeStockException for inventory validation:

```java
public class NegativeStockException extends Exception {
    public NegativeStockException(){
        super();
    }
    public NegativeStockException(String m){
        super(m);
    }
}
```

### 8. Exception Handling - Try-Catch Blocks
Handle exceptions gracefully using try-catch blocks to prevent program crashes and provide meaningful error messages.

**Example:** Catching custom exceptions when creating products:

```java
try {
    System.out.print("Stock: ");
    stock = in.nextInt();
    product.add(new Product(id, name, stock));
    System.out.println("Product Add Successfully\n");
} catch (NegativeStockException e) {
    System.out.println("Exception: " + e.getMessage());
}
```

### 9. ArrayList Collection
A dynamic, resizable array that stores objects of any type, allowing efficient insertion and removal.

**Example:** Storing Product objects in an ArrayList:

```java
ArrayList<Product> product = new ArrayList<>();
product.add(new Product("P001", "Laptop", 10));
product.add(new Product("P002", "Mouse", 50));
```

### 10. Generics with Collections
Allow you to specify the type of elements a collection will hold, providing type safety and eliminating type casting.

**Syntax:** ArrayList<Type> specifies what type of objects the list will contain.

```java
ArrayList<Product> product = new ArrayList<>();  // Type-safe collection
Product item = product.get(0);                   // No casting needed
```

### 11. ArrayList Operations
Common methods for working with lists:

- **add():** Insert an element at the end of the list
- **get(index):** Retrieve element at a specific index
- **indexOf():** Find the index of an element
- **remove():** Remove an element from the list
- **size():** Get the number of elements

**Example:**

```java
ArrayList<Product> inventory = new ArrayList<>();
inventory.add(new Product("P001", "Laptop", 10));        // Add
Product item = inventory.get(0);                         // Get by index
int index = inventory.indexOf("P001");                   // Find index
System.out.println(inventory.size());                    // Get size
```

### 12. Enhanced For Loop
Also known as for-each loop, simplifies iteration through collections without using an index.

**Syntax:** `for (Type variable : collection)`

**Example:** Iterating through all products:

```java
for (Product s : product) {
    System.out.println(s);
}
```

### 13. User Input Handling - Scanner Class
Read user input from the console using Java's Scanner class for interactive applications.

**Example:** Reading different data types:

```java
Scanner in = new Scanner(System.in);
String id = in.nextLine();      // Read string
int stock = in.nextInt();       // Read integer
in.nextLine();                   // Consume newline character
```

### 14. Control Flow - Switch Statements
Execute different code blocks based on different conditions, useful for menu-driven applications.

**Example:** Menu selection in inventory management:

```java
switch (choice) {
    case 1:
        // Add product logic
        break;
    case 2:
        // Increase stock logic
        break;
    case 3:
        // Decrease stock logic
        break;
}
```

### 15. Method Parameters and Return Values
Methods can accept parameters and return values of various types.

**Example:** Methods that modify inventory and return updated stock:

```java
public int IncreaseProduct(int amount){
    return this.stock += amount;
}

public int DecreaseProduct(int amount) throws NegativeStockException{
    int dec = this.stock - amount;
    if(dec < 0){
        throw new NegativeStockException("Stock is Reduced to a Negative Value");
    }
    return dec;
}
```

## Project Structure

```
LabTestAP/
├── src/labtestap/
│   ├── LabTestAP.java                (Main application with menu-driven interface)
│   ├── Product.java                  (Class representing a product in inventory)
│   └── NegativeStockException.java   (Custom exception for invalid stock operations)
├── build/                            (Compiled class files)
├── nbproject/                        (NetBeans project configuration)
├── manifest.mf                       (Manifest file)
├── build.xml                         (Ant build configuration)
└── README.md                        (This file)
```

## Key Classes

### Product.java
Represents a single product in the inventory system with:

**Attributes:**
- `productId` (String) - Unique identifier for the product
- `productName` (String) - Name of the product
- `stock` (int) - Current stock quantity

**Constructor:**
- `Product(String productId, String productName, int stock)` - Initialize product with validation

**Methods:**
- **Getters:** `getProductId()`, `getProductName()`, `getStock()`
- **Setters:** `setProductId()`, `setProductName()`, `setStock()`
- **Operations:** `IncreaseProduct(int amount)`, `DecreaseProduct(int amount)`
- **Overrides:** `toString()`, `equals()`, `compareTo()`

### NegativeStockException.java
Custom exception class that extends Exception for handling invalid stock operations.

**Constructors:**
- `NegativeStockException()` - No-argument constructor
- `NegativeStockException(String m)` - Constructor with error message

### LabTestAP.java
Main application class that demonstrates:

- Creating ArrayList of Product objects
- Interactive menu-driven user interface
- Adding products with exception handling
- Searching products by ID
- Increasing and decreasing stock with validation
- Displaying all products
- Menu loop with user choice validation

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| Classes & Objects | Model real-world entities (products) |
| Constructors | Initialize objects and validate data |
| Getters/Setters | Provide controlled access to attributes |
| Custom Exceptions | Handle domain-specific errors |
| Try-Catch Blocks | Gracefully handle exceptions |
| ArrayList | Store dynamic collections of objects |
| Generics | Ensure type safety in collections |
| toString() Override | Provide readable object representation |
| equals() Override | Compare objects by meaningful attributes |
| Scanner Input | Read user input interactively |
| Enhanced For Loop | Iterate through collections easily |
| Switch Statements | Handle multiple menu choices |
| Exception Throwing | Validate data and propagate errors |

## How to Run

### Using NetBeans IDE
1. Open the project in NetBeans
2. Click **Run → Run Project** (or press **F6**)
3. Follow the on-screen menu prompts

### Using Command Line

**Compile the project:**
```bash
javac -d build/classes src/labtestap/*.java
```

**Run the main application:**
```bash
java -cp build/classes labtestap.LabTestAP
```

## Expected Output

When you run the application, you will see an interactive menu:

```
===Choose Option Below===
1. Add product
2. Increase stock
3. Decrease stock
4. Display All
5. Stop Program

Choice:
```

### Sample Session

```
===Choose Option Below===
1. Add product
2. Increase stock
3. Decrease stock
4. Display All
5. Stop Program

Choice: 1
Product ID : P001
Name: Laptop
Stock: 10
Product Add Successfully

===Choose Option Below===
1. Add product
2. Increase stock
3. Decrease stock
4. Display All
5. Stop Program

Choice: 4
Product{productId=P001, productName=Laptop, stock=10}

===Choose Option Below===
1. Add product
2. Increase stock
3. Decrease stock
4. Display All
5. Stop Program

Choice: 5
```

## Notes

- The `indexOf()` method requires proper `equals()` implementation to work correctly with custom objects
- Exception handling ensures the application doesn't crash on invalid input
- The `compareTo()` method in Product class can be used for sorting products
- This project demonstrates separation of concerns: data (Product) and logic (LabTestAP)

---

**Created:** 8/12/2025  
**Language:** Java  
**Programming Level:** Intermediate  
**Topic:** Object-Oriented Programming & Exception Handling  
**Concepts:** Classes, Exceptions, Collections, User Input, Menu-Driven Applications
