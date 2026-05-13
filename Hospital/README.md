# Java Learning Material - Hospital Management System Project

## Overview

This is a beginner-friendly Java learning project that demonstrates fundamental Object-Oriented Programming (OOP) concepts through a practical Hospital Staff Management system. The project illustrates how inheritance, polymorphism, and abstract classes work together to create a scalable, maintainable application for managing different types of hospital staff.

## Java Fundamentals Covered

### 1. Classes and Objects

A class is a blueprint for creating objects. Objects are instances of classes with properties (attributes) and behaviors (methods).

**Example:** `HospitalStaff` class represents a hospital employee with name, staff ID, salary, and hours worked.

```java
public abstract class HospitalStaff {
    private String name;
    private int staffID;
    private double basicSalary;
    private int hoursWork;
}
```

### 2. Abstract Classes

An abstract class is a class that cannot be instantiated directly. It serves as a blueprint for subclasses and can contain abstract methods that must be implemented by child classes.

**Key Points:**
- Use `abstract` keyword to declare a class as abstract
- Abstract classes can have abstract methods (methods without implementation)
- Subclasses must implement all abstract methods from the parent class
- Abstract classes are useful for creating a common interface for related classes

**Example:** `HospitalStaff` is abstract because we don't want to create generic hospital staff; we want specific types like Doctor and Nurse.

```java
public abstract class HospitalStaff {
    public abstract double calculateMonthlySalary();
}
```

### 3. Inheritance

Inheritance allows a class (child/subclass) to inherit properties and methods from another class (parent/superclass). This promotes code reuse and establishes relationships between classes.

**Key Points:**
- Use `extends` keyword to inherit from a parent class
- Child classes inherit all public and protected members from the parent
- Child classes can add their own unique properties and methods
- Each child class has a specialized version of the parent class

**Example:** `Doctor` and `Nurse` classes inherit from `HospitalStaff`.

```java
public class Doctor extends HospitalStaff {
    private String department;
    
    public Doctor(String name, int staffID, double basicSalary, int hoursWork, String department) {
        super(name, staffID, basicSalary, hoursWork);
        this.department = department;
    }
}

public class Nurse extends HospitalStaff {
    private String department;
    
    public Nurse(String name, int staffID, double basicSalary, int hoursWork, String department) {
        super(name, staffID, basicSalary, hoursWork);
        this.department = department;
    }
}
```

### 4. Constructor and super() Keyword

A constructor is a special method called when an object is created. The `super()` keyword is used to call the parent class's constructor, ensuring proper initialization of inherited properties.

**Example:**

```java
public Doctor(String name, int staffID, double basicSalary, int hoursWork, String department) {
    super(name, staffID, basicSalary, hoursWork);  // Call parent constructor
    this.department = department;
}
```

### 5. Method Overriding

Method overriding occurs when a child class provides its own implementation of a method that is declared in the parent class. Use the `@Override` annotation to indicate intentional override.

**Key Points:**
- Child class method must have the same name as parent class method
- Return type and parameters must be the same
- Use `@Override` annotation for clarity and compile-time checking
- Enables different behavior for different child classes

**Example:** Both `Doctor` and `Nurse` override `calculateMonthlySalary()` with different salary calculation logic.

```java
// Doctor implementation: basic salary + (hours × RM50)
@Override
public double calculateMonthlySalary() {
    return super.getBasicSalary() + (super.getHoursWork() * 50);
}

// Nurse implementation: basic salary + (hours × RM30)
@Override
public double calculateMonthlySalary() {
    return super.getBasicSalary() + (super.getHoursWork() * 30);
}
```

### 6. Polymorphism

Polymorphism means "many forms." It allows you to use a parent class reference to point to child class objects. The correct method is called based on the actual object type, not the reference type.

**Key Points:**
- Create parent class references but assign child class objects
- Call methods using parent class reference
- The correct child class implementation is automatically called
- Enables flexible and extensible code

**Example:** Using `HospitalStaff` reference for both `Doctor` and `Nurse` objects.

```java
HospitalStaff hs;  // Parent class reference

hs = new Doctor("Syabil", 308451, 5000, 16, "Surgery");
hs.calculateMonthlySalary();  // Calls Doctor's implementation

hs = new Nurse("Nazihah", 65401, 3000, 13, "Medicine");
hs.calculateMonthlySalary();  // Calls Nurse's implementation
```

### 7. Encapsulation

Encapsulation is the bundling of data (attributes) and methods that operate on that data within a single unit (class). Private attributes with public getter methods provide controlled access to object data.

**Key Points:**
- Mark sensitive data as `private`
- Provide public `getter` methods for reading values
- Prevent direct modification of sensitive attributes
- Allows validation and control over data access

**Example:** Private attributes with getter methods.

```java
private String name;
private double basicSalary;

public String getName() {
    return this.name;
}

public double getBasicSalary() {
    return this.basicSalary;
}
```

### 8. Getter Methods (Accessors)

Getter methods allow external code to read the values of private attributes. They provide controlled, read-only access to object data.

**Example:**

```java
public String getName() {
    return this.name;
}

public String getDepartment() {
    return this.ddepartment;
}
```

### 9. Method Overriding - toString()

The `toString()` method provides a custom string representation of an object. Overriding it allows you to control how objects are displayed when printed.

**Example:**

```java
@Override
public String toString() {
    return String.format("Hospital Staff Name: %s \nStaff ID: %d \nBasic Salary: RM%.2f \nTotal Hours Work: %d Hours",
            this.name, this.staffID, this.basicSalary, this.hoursWork);
}
```

### 10. String Formatting with String.format()

The `String.format()` method creates formatted strings using format specifiers:
- `%s` - String
- `%d` - Integer
- `%.2f` - Floating-point number with 2 decimal places
- `\n` - Newline character

**Example:**

```java
String formatted = String.format("Name: %s, Salary: RM%.2f", "John", 5000.50);
System.out.println(formatted);  // Output: Name: John, Salary: RM5000.50
```

## Project Structure

```
Hospital/
├── src/hospital/
│   ├── HospitalStaff.java      (Abstract parent class)
│   ├── Doctor.java             (Child class for doctors)
│   ├── Nurse.java              (Child class for nurses)
│   └── Hospital.java           (Main application)
├── build/                       (Compiled class files)
├── nbproject/                   (NetBeans project configuration)
├── manifest.mf                  (Manifest file)
├── build.xml                    (Build configuration)
└── README.md                    (This file)
```

## Key Classes

### HospitalStaff.java

Abstract base class representing generic hospital staff with:

- **Attributes:**
  - `name` (String) - Staff member's name
  - `staffID` (int) - Unique staff identifier
  - `basicSalary` (double) - Monthly basic salary in RM
  - `hoursWork` (int) - Total hours worked
  
- **Constructor:** Initialize all attributes
- **Getter Methods:** `getName()`, `getStaffID()`, `getBasicSalary()`, `getHoursWork()`
- **Abstract Method:** `calculateMonthlySalary()` - Must be implemented by child classes
- **toString():** Custom string representation of staff information

### Doctor.java

Concrete class representing a doctor, extending `HospitalStaff`:

- **Additional Attributes:**
  - `ddepartment` (String) - Medical department (e.g., Surgery, Medicine)
  
- **Constructor:** Calls `super()` and initializes department
- **Getter Method:** `getdDepartment()`
- **calculateMonthlySalary() Implementation:** `basicSalary + (hoursWork × RM50)`
- **toString() Override:** Extends parent toString with department and calculated salary

### Nurse.java

Concrete class representing a nurse, extending `HospitalStaff`:

- **Additional Attributes:**
  - `ndepartment` (String) - Nursing department (e.g., Medicine, Pediatrics)
  
- **Constructor:** Calls `super()` and initializes department
- **Getter Method:** `getnDepartment()`
- **calculateMonthlySalary() Implementation:** `basicSalary + (hoursWork × RM30)`
- **toString() Override:** Extends parent toString with department and calculated salary

### Hospital.java

Main application class that demonstrates:

- Creating instances of `Doctor` and `Nurse`
- Using polymorphism with `HospitalStaff` references
- Calling overridden methods
- Displaying staff information using `toString()`

## Key Concepts Summary

| Concept | Purpose | Example |
|---------|---------|---------|
| **Abstract Class** | Define common interface for related classes without instantiation | `HospitalStaff` as base for Doctor/Nurse |
| **Inheritance** | Enable code reuse and establish class relationships | Doctor/Nurse extend HospitalStaff |
| **Polymorphism** | Use parent reference for different child objects | `HospitalStaff hs = new Doctor(...)` |
| **Method Overriding** | Provide specialized implementations in child classes | `calculateMonthlySalary()` different for Doctor vs Nurse |
| **Encapsulation** | Control access to object data with getters | Private attributes with public getter methods |
| **Constructor** | Initialize object attributes and call parent constructor | `super()` in child class constructors |
| **Getter Methods** | Provide read-only access to private attributes | `getName()`, `getBasicSalary()` |
| **toString() Override** | Custom string representation of objects | Display formatted staff information |
| **String Formatting** | Create formatted output strings | `String.format()` with format specifiers |

## How to Run

### Using NetBeans IDE

1. Open the project in NetBeans
2. Click **Run → Run Project** (or press **F6**)
3. Output will appear in the Output window

### Using Command Line

**Step 1: Compile the project**
```powershell
javac -d build/classes src/hospital/*.java
```

**Step 2: Run the main application**
```powershell
java -cp build/classes hospital.Hospital
```

## Expected Output

When you run the application, it will:

1. Create a Doctor object with name "Syabil"
2. Calculate the doctor's monthly salary (RM5000 + 16 hours × RM50 = RM5800)
3. Display the doctor's information
4. Create a Nurse object with name "Nazihah"
5. Calculate the nurse's monthly salary (RM3000 + 13 hours × RM30 = RM3390)
6. Display the nurse's information

**Sample Output:**

```
============== Doctor ==============
Hospital Staff Name: Syabil 
Staff ID: 308451 
Basic Salary: RM5000.00 
Total Hours Work: 16 Hours
Department: Surgery
Total Monthly Salary: RM5800.00
============== Nurse ==============
Hospital Staff Name: Nazihah 
Staff ID: 65401 
Basic Salary: RM3000.00 
Total Hours Work: 13 Hours
Department: Medicine
Total Monthly Salary: RM3390.00
```
---

**Created:** 25/5/2025  
**Language:** Java  
**Programming Level:** Beginner-Intermediate  
**Topic:** Object-Oriented Programming - Inheritance & Polymorphism  
**IDE:** NetBeans
