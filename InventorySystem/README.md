# Java Learning Material - InventorySystem Project

## Overview

This is a practical Java learning project that demonstrates Object-Oriented Programming (OOP) principles, database connectivity, and GUI development through a complete Inventory Management System. The application allows users to manage supply items with features like adding, removing, updating, and viewing inventory data through an intuitive graphical interface.

## Java Fundamentals Covered

### 1. Classes and Objects

A class is a blueprint for creating objects. Objects are instances of classes with properties (attributes) and behaviors (methods).

**Example: SupplyItem class** represents an inventory item with properties and operations.

```java
public class SupplyItem {
    private int id, quantity;
    private String name, category;
    private double price;
    
    public SupplyItem(int id, String name, String category, int quantity, double price) 
        throws InventoryException {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }
}
```

### 2. Encapsulation & Access Modifiers

Encapsulation is bundling data (attributes) and methods that operate on that data together, while hiding implementation details.

- **private**: Restricts access to class members only
- **public**: Allows access from anywhere
- Protects data integrity by controlling how attributes are accessed

**Example: Private attributes with public getter/setter methods**

```java
private int quantity;

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}
```

### 3. Constructors

A constructor is a special method called when an object is created. It initializes object properties and sets up the object state.

**Example: Constructor initializes all SupplyItem properties**

```java
public SupplyItem(int id, String name, String category, int quantity, double price) 
    throws InventoryException {
    this.id = id;
    this.name = name;
    this.category = category;
    this.quantity = quantity;
    this.price = price;
}
```

### 4. Getter and Setter Methods

**Getter Methods (Accessors)** return the values of private attributes, providing controlled read-only access to object data.

```java
public String getName() {
    return name;
}

public int getId() {
    return id;
}
```

**Setter Methods (Mutators)** modify the values of private attributes, providing controlled write access.

```java
public void setName(String name) {
    this.name = name;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}
```

### 5. Method Overriding - toString()

Override the default `toString()` method to provide a custom string representation of objects for easier debugging and display.

**Example: Custom toString() implementation**

```java
@Override
public String toString() {
    return "SupplyItem{" + "id=" + id + "\n quantity=" + quantity + 
           "\n name=" + name + "\n category=" + category + 
           "\n price=" + price + '}';
}
```

### 6. Custom Exceptions

Create custom exception classes that extend the `Exception` class to handle domain-specific errors and validation.

**Example: Custom exception for inventory operations**

```java
public class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}
```

**Usage in validation:**

```java
if (item.getQuantity() < 0) {
    throw new InventoryException("Quantity cannot be negative");
}
if (item.getPrice() < 0) {
    throw new InventoryException("Price cannot be negative");
}
```

### 7. Exception Handling

Handle exceptions using try-catch-finally blocks to gracefully manage errors without crashing the application.

**Example: Proper resource management**

```java
try {
    String sql = "INSERT INTO supplies(ID, ItemName, Category, Quantity, Price) VALUES (?,?,?,?,?)";
    ps = conn.prepareStatement(sql);
    // ... operations
    ps.executeBatch();
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    if (ps != null) {
        ps.close();  // Always close resources
    }
}
```

### 8. JDBC (Java Database Connectivity)

JDBC is an API for connecting to and executing queries on relational databases.

**Key Components:**
- **Connection**: Establishes a link to the database
- **PreparedStatement**: Pre-compiled SQL statement for secure queries
- **ResultSet**: Contains query results that can be iterated

**Example: Retrieving data with JDBC**

```java
String sql = "SELECT * FROM supplies WHERE ID = ?";
ps = conn.prepareStatement(sql);
ps.setInt(1, id);
rs = ps.executeQuery();

if (rs.next()) {
    return new SupplyItem(
        rs.getInt("ID"),
        rs.getString("ItemName"),
        rs.getString("Category"),
        rs.getInt("Quantity"),
        rs.getDouble("Price")
    );
}
```

### 9. Collections Framework - ArrayList & List

Collections are containers for storing and manipulating groups of objects.

- **List Interface**: Ordered collection allowing duplicates
- **ArrayList**: Resizable array implementation of List
- **Type Safety**: Use generics to specify collection element types

**Example: Using ArrayList to store items**

```java
List<SupplyItem> items = new ArrayList<>();
items.add(new SupplyItem(1, "Pencil", "Stationery", 100, 2.50));
items.add(new SupplyItem(2, "Pen", "Stationery", 50, 5.00));

for (SupplyItem item : items) {
    System.out.println(item);
}
```

### 10. Enhanced For Loop (For-Each Loop)

Simplified iteration through collections without manual indexing.

**Syntax:** `for (Type variable : collection)`

**Example: Iterating through supply items**

```java
for (SupplyItem item : items) {
    System.out.println(item.getName() + ": " + item.getQuantity());
}
```

### 11. Batch Operations

Insert, update, or delete multiple database records efficiently in a single transaction.

**Example: Batch insert for multiple items**

```java
for (SupplyItem item : items) {
    ps.setInt(1, item.getId());
    ps.setString(2, item.getName());
    ps.setString(3, item.getCategory());
    ps.setInt(4, item.getQuantity());
    ps.setDouble(5, item.getPrice());
    ps.addBatch();  // Add to batch
}
ps.executeBatch();  // Execute all at once
```

### 12. GUI Development with Swing

Swing is a toolkit for building graphical user interfaces in Java.

**Key Components:**
- **JFrame**: Top-level window container
- **JTable**: Display tabular data
- **JTabbedPane**: Create multiple tabs for organized UI
- **JButton, JLabel, JTextField**: Basic UI components
- **Event Listeners**: Respond to user actions

**Example: Creating a GUI frame**

```java
public class InventoryGUI extends javax.swing.JFrame {
    private Connection conn;
    
    public InventoryGUI() throws Exception {
        initComponents();
        this.setSize(1065, 830);
        loadDashboardTable();
    }
}
```

### 13. Lambda Expressions & Functional Programming

Use functional interfaces and lambda expressions for concise code and functional operations.

**Example: Using Predicate for filtering**

```java
List<SupplyItem> lowStockItems = items.stream()
    .filter(item -> item.getQuantity() < 10)
    .collect(Collectors.toList());
```

### 14. Inheritance (Implicit in Exception Handling)

Inheritance allows classes to inherit properties and methods from parent classes.

**Example: Custom exception inherits from Exception**

```java
public class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);  // Call parent constructor
    }
}
```

## Project Structure

```
InventorySystem/
├── src/inventorysystem/
│   ├── SupplyItem.java              (Model class for inventory items)
│   ├── InventoryManager.java        (Database operations and business logic)
│   ├── InventoryException.java      (Custom exception for inventory errors)
│   ├── DBConnection.java            (Database connection management)
│   ├── InventoryGUI.java            (Swing GUI application)
│   ├── InventoryGUI.form            (NetBeans GUI form definition)
│   └── InventorySystem.java         (Main entry point)
├── build/                            (Compiled class files)
├── nbproject/                        (NetBeans project configuration)
├── build.xml                         (Apache Ant build configuration)
└── README.md                         (This file)
```

## Key Classes

### SupplyItem.java

Model class representing a supply item in the inventory system.

**Attributes:**
- `id`: Unique identifier for the item
- `name`: Name of the supply item
- `category`: Category/type of the item
- `quantity`: Current stock quantity
- `price`: Unit price of the item

**Methods:**
- Getter methods: `getId()`, `getName()`, `getCategory()`, `getQuantity()`, `getPrice()`
- Setter methods: `setId()`, `setName()`, `setCategory()`, `setQuantity()`, `setPrice()`
- `toString()`: Returns formatted string representation of the item

### InventoryManager.java

Handles all database operations and business logic for inventory management.

**Key Methods:**
- `addSupplyItem(List<SupplyItem>)`: Add multiple items to database with batch operations
- `getSupplyItem(int id)`: Retrieve a specific item by ID
- Database operations with proper exception handling and resource cleanup

**Features:**
- Input validation (checking for negative quantities, empty names, etc.)
- Batch processing for efficient database operations
- Custom exception throwing for business logic violations

### DBConnection.java

Manages database connection pooling and provides access to the database.

**Functionality:**
- Establishes connections to the database using JDBC
- Handles connection configuration and management
- Provides singleton connection instance

### InventoryGUI.java

Main GUI application built with Swing/NetBeans GUI Builder.

**Features:**
- **Dashboard Tab**: View all inventory items in a table, sort by price, refresh data
- **Add Item Tab**: Add new items with quantity slider and validation
- **Remove Item Tab**: Remove items from inventory
- **Update Item Tab**: Modify existing item details
- Dynamic table refresh and combo box population
- Label updates for inventory statistics

### InventoryException.java

Custom exception class for handling inventory-specific errors.

**Usage:**
- Thrown when validation fails (negative prices, empty names)
- Provides clear error messages for business logic violations
- Allows specific exception handling in application logic

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| Classes & Objects | Blueprint for creating reusable data structures |
| Encapsulation | Hide internal details and control data access |
| Constructors | Initialize objects with required data |
| Getter/Setter Methods | Provide controlled access to private attributes |
| Custom Exceptions | Handle domain-specific errors with meaningful messages |
| JDBC | Connect to and interact with relational databases |
| Collections (ArrayList) | Store and manage multiple objects efficiently |
| Enhanced For Loop | Simple iteration through collections |
| Swing GUI | Build interactive graphical user interfaces |
| Batch Operations | Execute multiple database operations efficiently |
| Exception Handling | Gracefully manage errors with try-catch-finally |

## How to Run

### Using NetBeans IDE

1. Open the project in NetBeans
2. Click **Run → Run Project** (or press **F6**)
3. The application window will open with the inventory dashboard

### Using Command Line

**Compile the project:**

```powershell
javac -d build/classes src/inventorysystem/*.java
```

**Run the main application:**

```powershell
java -cp build/classes inventorysystem.InventoryGUI
```

### Using Apache Ant

```powershell
ant run
```

## Features Demonstrated

✓ Object-Oriented Programming (Classes, Objects, Encapsulation)
✓ Exception Handling (Custom exceptions, try-catch-finally)
✓ Database Connectivity (JDBC with PreparedStatement)
✓ Collections Framework (ArrayList, List interfaces)
✓ Graphical User Interface (Swing, JFrame, JTable, JTabbedPane)
✓ Data Validation (Input validation, error handling)
✓ Batch Database Operations
✓ Event Handling (Button clicks, user interactions)
✓ Resource Management (Connection and statement closing)

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- NetBeans IDE (for GUI development) - optional
- Relational Database (SQL Server, MySQL, etc.)
- JDBC Driver for your database

## Database Setup

Before running the application, ensure you have a database configured with a `supplies` table:

```sql
CREATE TABLE supplies (
    ID INT PRIMARY KEY,
    ItemName VARCHAR(100) NOT NULL,
    Category VARCHAR(50),
    Quantity INT,
    Price DECIMAL(10, 2)
);
```

## Learning Outcomes

After studying this project, you will understand:

1. How to design classes with proper encapsulation
2. How to implement exception handling for robust applications
3. How to connect Java applications to databases using JDBC
4. How to work with collections and iterate through data
5. How to build GUI applications with Swing
6. How to implement CRUD (Create, Read, Update, Delete) operations
7. How to validate user input and handle errors gracefully
8. How to structure a multi-layered application (Model, Manager, GUI)

## Best Practices Demonstrated

- **Separation of Concerns**: GUI, database logic, and model classes are separate
- **Resource Management**: Proper closing of database connections and statements
- **Data Validation**: Input validation before database operations
- **Custom Exceptions**: Domain-specific exception handling
- **Encapsulation**: Private attributes with public getter/setter methods
- **Error Handling**: Comprehensive exception handling with try-catch-finally

---

**Created:** 11/1/2026
**Language:** Java
**Programming Level:** Intermediate
**Topic:** Object-Oriented Programming, Database Connectivity & GUI Development
**IDE:** NetBeans
