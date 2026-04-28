# Java Learning Material - Shape Test Project

## Overview
This is a beginner-friendly Java learning project that demonstrates fundamental Object-Oriented Programming (OOP) concepts through a practical Shape calculation application.

---

## Java Fundamentals Covered

### 1. **Classes and Objects**
- A class is a blueprint for creating objects
- Objects are instances of classes with properties (attributes) and behaviors (methods)
- **Example**: `Shape`, `Rectangle`, `Cube`, `Cylinder` classes

### 2. **Abstraction**
- Abstract classes cannot be instantiated directly but serve as templates
- Use `abstract` keyword to define abstract classes
- Abstract methods must be implemented by subclasses
- **Example**: `Shape` is an abstract class that defines the structure for all shapes

```java
public abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculateVolume();
}
```

### 3. **Inheritance**
- Inheritance allows a class to acquire properties and methods from another class
- Use `extends` keyword to inherit from a parent class
- **Example**: `Cube`, `Cylinder`, and `Rectangle` inherit from `Shape`

```java
public class Cube extends Shape {
    // Cube-specific properties and methods
}
```

### 4. **Polymorphism**
- Ability to execute different methods with the same name based on the object type
- Method overriding: subclasses provide their own implementation of parent methods
- **Example**: Each shape implements `calculateArea()` and `calculateVolume()` differently

### 5. **Encapsulation**
- Wrapping data (variables) and methods within a class
- Use `protected` and `private` access modifiers to control access
- **Example**: Shape properties like `name` and `side` are protected

```java
protected String name;
private double side;
```

### 6. **Access Modifiers**
- `public`: Accessible from anywhere
- `protected`: Accessible within the same package and subclasses
- `private`: Accessible only within the class
- Package-private (default): Accessible within the same package

### 7. **Constructor**
- Special method called when an object is created
- Used to initialize object properties
- **Example**: `Cube(String name, double side)` initializes name and side

### 8. **User Input Handling**
- `Scanner` class is used to read user input from the console
- **Example**: Reading shape names and dimensions from the user

```java
Scanner in = new Scanner(System.in);
String name = in.nextLine();
double value = in.nextDouble();
```

### 9. **String Methods**
- `equalsIgnoreCase()`: Compare strings ignoring case sensitivity
- `toString()`: Convert object to string representation
- **Example**: Checking user input for shape types

### 10. **Mathematical Operations**
- Calculating geometric properties (area, volume)
- Example formulas:
  - **Rectangle Area**: length × width
  - **Cube Area**: 6 × side²
  - **Cube Volume**: side³
  - **Cylinder Area**: 2πr² + 2πrh
  - **Cylinder Volume**: πr²h

---

## Project Structure

```
ShapeTest/
├── src/shapetest/
│   ├── Shape.java          (Abstract parent class)
│   ├── Rectangle.java      (Concrete implementation)
│   ├── Cube.java          (Concrete implementation)
│   ├── Cylinder.java      (Concrete implementation)
│   └── ShapeTest.java     (Main application with user interaction)
├── build/                 (Compiled class files)
├── nbproject/            (NetBeans project configuration)
└── README.md            (This file)
```

---

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| **Abstract Class** | Define structure and enforce implementation in subclasses |
| **Inheritance** | Reuse code and establish relationships between classes |
| **Polymorphism** | Allow objects to be treated generically while acting specifically |
| **Encapsulation** | Hide internal details and control access to data |
| **Constructor** | Initialize objects with required properties |
| **Scanner** | Handle user input from console |

---

## How to Run

1. Compile the project:
   ```bash
   javac -d build/classes src/shapetest/*.java
   ```

2. Run the main application:
   ```bash
   java -cp build/classes shapetest.ShapeTest
   ```

3. Follow the prompts to:
   - Enter the shape type (Rectangle, Cube, or Cylinder)
   - Input the required dimensions
   - View calculated area and volume

---

**Created**: 25/5/2025  
**Language**: Java  
**Difficulty Level**: Beginner
