# Java Learning Material - Student Management System Project

## Overview

This is a beginner to intermediate Java learning project that demonstrates fundamental data structures, Object-Oriented Programming (OOP) concepts, and exception handling through a practical Student Management System. The application allows users to manage student records with sorting by multiple criteria using both Comparable and Comparator interfaces.

## Java Fundamentals Covered

### 1. Classes and Objects

A class is a blueprint for creating objects. Objects are instances of classes with properties (attributes) and behaviors (methods).

**Example: Student class represents a student with id, name, and marks properties**

```java
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}
```

### 2. Constructor

A special method called when an object is created. Used to initialize object properties and validate data.

**Example: Constructor with validation**

```java
public Student(int id, String name, int marks) {
    if (marks < 0 || marks > 100) {
        throw new IllegalArgumentException("Marks must be between 0-100");
    }
    this.id = id;
    this.name = name;
    this.marks = marks;
}
```

### 3. Getter Methods (Accessors)

Methods that return the values of private attributes. Provide controlled access to object data without allowing modification.

**Example: Getter methods for Student attributes**

```java
public int getId() {
    return id;
}

public String getName() {
    return name;
}

public int getMarks() {
    return marks;
}
```

### 4. Method Overriding - toString()

Override the default `toString()` method for custom string representation. Provides a readable format when printing objects.

**Example: Custom string representation of a Student**

```java
@Override
public String toString() {
    return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
}
```

### 5. Custom Exception Handling

Create custom exception classes by extending the `Exception` class. Use exceptions to handle specific error conditions and provide meaningful error messages.

**Example: Custom exceptions**

```java
// StudentNotFoundException.java
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Usage in code
if (studentNotFound) {
    throw new StudentNotFoundException("Student with ID " + id + " not found.");
}
```

### 6. Try-Catch Blocks

Handle exceptions gracefully by catching them and providing appropriate feedback to the user.

**Example: Catching exceptions during student operations**

```java
try {
    Student s = new Student(id, name, marks);
    stud.add(s);
    System.out.println("Student successfully added!");
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}
```

### 7. LinkedList Data Structure

A linear data structure where elements are stored in nodes. Each node contains a reference to the next node. LinkedList allows efficient insertion and deletion at any position.

**Example: Creating and using a LinkedList**

```java
LinkedList<Student> stud = new LinkedList<>();
stud.add(new Student(1, "Alice", 85));
stud.add(new Student(2, "Bob", 92));
```

### 8. Comparable Interface

Implement `Comparable<T>` to define the natural ordering for objects. Override `compareTo()` to specify how objects should be compared.

**Example: Natural ordering by marks (ascending)**

```java
public class Student implements Comparable<Student> {
    // ... other code ...
    
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }
}
```

### 9. Comparator Interface

Implement `Comparator<T>` to define alternative sorting strategies without modifying the original class.

**Example: Custom comparator to sort by name**

```java
public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}
```

### 10. Collections.sort() Method

Use `Collections.sort()` to sort collections using either the natural ordering (Comparable) or a custom comparator.

**Example: Sorting using both approaches**

```java
// Sort by marks (natural order - Comparable)
Collections.sort(stud);

// Sort by name (using Comparator)
Collections.sort(stud, new NameComparator());
```

### 11. equals() Method Override

Override `equals()` to define object equality based on specific attributes.

**Example: Two students are equal if they have the same ID**

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Student other = (Student) obj;
    return this.id == other.id;
}
```

### 12. Enhanced For Loop

Also known as for-each loop. Simplifies iteration through collections without using index.

**Example: Iterating through all students**

```java
for (Student s : stud) {
    System.out.println(s);
}
```

### 13. User Input with Scanner

Read user input from the console for interactive applications.

**Example: Reading student data from user**

```java
Scanner in = new Scanner(System.in);
System.out.print("Enter ID: ");
int id = in.nextInt();
in.nextLine(); // clear buffer
System.out.print("Enter Name: ");
String name = in.nextLine();
```

## Project Structure

```
LabPractice1/
├── src/labpractice1/
│   ├── Student.java                        (Class representing a student)
│   ├── NameComparator.java                (Custom comparator for sorting by name)
│   ├── StudentNotFoundException.java       (Custom exception class)
│   ├── EmptyListException.java            (Custom exception class)
│   ├── InvalidNameException.java          (Custom exception class)
│   └── LabPractice1.java                  (Main application with menu-driven system)
├── build/                                  (Compiled class files)
├── nbproject/                             (NetBeans project configuration)
└── README.md                              (This file)
```

## Key Classes

### Student.java

Represents a single student with:

- **Attributes**: `id` (int), `name` (String), `marks` (int)
- **Constructor**: Initialize student with validation for marks (0-100)
- **Getter Methods**: `getId()`, `getName()`, `getMarks()`
- **Comparable Interface**: Natural ordering by marks (ascending)
- **equals() Override**: Compare students by ID
- **toString() Override**: Custom string representation

### NameComparator.java

Implements `Comparator<Student>` to provide custom sorting:

- Compare students by name (case-insensitive)
- Enables sorting by name without modifying Student class
- Can be used with `Collections.sort(list, new NameComparator())`

### LabPractice1.java

Main application that demonstrates:

- Menu-driven system with 5 options
- **Add Student**: Create and add student with validation
- **Search Student**: Find student by ID (throws StudentNotFoundException)
- **Remove Student**: Remove student by ID (throws StudentNotFoundException)
- **Display All Students**: Sort by marks or by name
- **Exit**: Gracefully close the application

### Exception Classes

- **StudentNotFoundException**: Thrown when searching/removing non-existent student
- **EmptyListException**: For operations on empty list
- **InvalidNameException**: For invalid name input

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| **LinkedList** | Dynamic data structure for storing ordered elements |
| **Comparable** | Define natural ordering for a class |
| **Comparator** | Define alternative sorting strategies |
| **Custom Exceptions** | Handle specific error conditions |
| **Try-Catch** | Exception handling and error recovery |
| **Constructor** | Initialize objects with properties and validation |
| **Getter Methods** | Provide controlled access to object attributes |
| **toString() Override** | Custom string representation of objects |
| **Enhanced For Loop** | Simple iteration through collections |
| **Collections.sort()** | Sort lists using Comparable or Comparator |
| **equals() Override** | Define object equality criteria |

## How to Run

### Using NetBeans IDE

1. Open the project in NetBeans
2. Click **Run → Run Project** (or press **F6**)
3. Follow the on-screen menu prompts

### Using Command Line (Windows)

**Compile the project:**
```cmd
javac -d build\classes src\labpractice1\*.java
```

**Run the main application:**
```cmd
java -cp build\classes labpractice1.LabPractice1
```

### Using Command Line (Linux/Mac)

**Compile the project:**
```bash
javac -d build/classes src/labpractice1/*.java
```

**Run the main application:**
```bash
java -cp build/classes labpractice1.LabPractice1
```

## Expected Output

When you run the application, you'll see an interactive menu:

```
==== Student System ====
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students (Sorted)
5. Exit
Enter choice: 
```

### Sample Session

```
==== Student System ====
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students (Sorted)
5. Exit
Enter choice: 1
Enter ID: 1
Enter Name: Alice
Enter Marks: 85
Student successfully added!

==== Student System ====
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students (Sorted)
5. Exit
Enter choice: 1
Enter ID: 2
Enter Name: Bob
Enter Marks: 92
Student successfully added!

==== Student System ====
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students (Sorted)
5. Exit
Enter choice: 4

Sort By:
1. Marks (Natural Order - Comparable)
2. Name (Comparator)
Enter option: 1

--- Students Sorted by Marks ---
ID: 1 | Name: Alice | Marks: 85
ID: 2 | Name: Bob | Marks: 92

==== Student System ====
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students (Sorted)
5. Exit
Enter choice: 2
Enter ID to search: 1
Student FOUND:
ID: 1 | Name: Alice | Marks: 85

==== Student System ====
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students (Sorted)
5. Exit
Enter choice: 5
Exiting program...
```

## Project Information

| Detail | Value |
|--------|-------|
| **Language** | Java |
| **Programming Level** | Intermediate |
| **Topics** | Data Structures, OOP, Exception Handling, Sorting |
| **IDE** | NetBeans (Compatible with any Java IDE) |
| **Data Structure Used** | LinkedList |

## Tips for Learning

1. **Understand Comparable vs Comparator**: Comparable defines natural ordering in a class, while Comparator defines external sorting strategies
2. **Practice Exception Handling**: Modify the code to catch different exceptions and provide custom messages
3. **Extend the Project**: Add more features like update student marks, calculate GPA, filter students by marks range
4. **Experiment with Sorting**: Try implementing additional Comparators (by ID, by marks descending, etc.)
5. **Study Collections API**: Explore other methods in LinkedList and Collections classes

---

Created: 8/12/2025  
Language: Java  
Programming Level: Intermediate  
Topic: Data Structures & Object-Oriented Programming  
Focus: Comparable, Comparator, Custom Exceptions, LinkedList Management
