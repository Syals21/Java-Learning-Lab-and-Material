# MyVectorBook2

## Overview

**MyVectorBook2** is a Java learning project that demonstrates how to work with the `Vector` collection class to manage a list of Book objects. The project illustrates practical implementation of CRUD operations (Create, Read, Update, Delete), custom object handling, and sorting mechanisms. It serves as an educational resource for understanding Java's Collections Framework and object comparison principles.

---

## Java Fundamentals Covered

| Concept | Description |
|---------|-------------|
| **Vector Collections** | Dynamic array implementation from `java.util` package |
| **Generic Types** | Type-safe collections using `Vector<Book>` syntax |
| **CRUD Operations** | Creating, reading, updating, and deleting collection elements |
| **Comparable Interface** | Implementing custom object comparison logic |
| **Method Overriding** | Overriding `toString()`, `equals()`, and `compareTo()` methods |
| **Enhanced For Loop** | Iterating through collections using for-each syntax |
| **Collections Framework** | Using `Collections.sort()` for sorting custom objects |
| **Encapsulation** | Private fields with public getters and setters |

---

## Project Structure

```
MyVectorBook2/
│
├── src/                          # Source code directory
│   └── myvectorbook2/
│       ├── Book.java             # Model class for Book objects
│       └── MyVectorBook2.java     # Main application class
│
├── build/                        # Compiled output
│   └── classes/
│       └── myvectorbook2/
│
├── nbproject/                    # NetBeans IDE configuration
│   ├── build-impl.xml
│   ├── project.xml
│   └── private/
│
├── build.xml                     # Ant build script
├── manifest.mf                   # JAR manifest file
└── README.md                     # This file
```

### File Descriptions

- **Book.java**: Model class with properties (title, author, price) and methods for comparison and string representation
- **MyVectorBook2.java**: Main class demonstrating Vector operations including add, remove, access, and sorting

---

## Key Concept Summary

### 1. Vector Class
- Thread-safe dynamic array implementation
- Grows and shrinks automatically
- Supports generic type parameters

### 2. CRUD Operations Demonstrated
- **Add**: `bookList.add(new Book(...))`
- **Read**: `bookList.get(index)`
- **Update**: Modify object properties via setters
- **Delete**: `bookList.remove(index)`

### 3. Comparable Interface
- Implements `Comparable<Book>`
- Defines natural ordering through `compareTo()`
- Enables sorting without custom comparators

### 4. Sorting
- Uses `Collections.sort()` method
- Automatically calls `compareTo()` for comparison
- Sorts books alphabetically by title

### 5. Object Methods
- `toString()`: Custom string representation for display
- `equals()`: Compares all properties for equality
- `compareTo()`: Defines sorting order by title

---

## Metadata

| Property | Value |
|----------|-------|
| **Created** | 23/11/2025 |
| **Language** | Java |
| **Programming Level** | Intermediate |

---

## Quick Start

### Compile
```bash
javac -d build/classes src/myvectorbook2/*.java
```

### Run
```bash
java -cp build/classes myvectorbook2.MyVectorBook2
```

### Using Ant (NetBeans)
```bash
ant run
```

