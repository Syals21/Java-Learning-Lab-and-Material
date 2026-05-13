# Java Learning Material - HealthTrackingSystem Project

## Overview
This is a beginner to intermediate Java learning project that demonstrates fundamental Object-Oriented Programming (OOP) concepts and data structures through a practical Health Tracking application. The system manages user health records including nutrition, sleep, and daily activity tracking using ArrayLists and inheritance patterns.

## Java Fundamentals Covered

### 1. Classes and Objects
A class is a blueprint for creating objects with specific properties and behaviors.
Objects are instances of classes with attributes and methods.

**Example: User class represents a person with health metrics**
```java
public class User {
    private int userId;
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;
    
    // Methods and constructors follow
}
```

### 2. Constructor
Special method called when an object is created to initialize object properties.

**Example: Initializing a User with personal information**
```java
public User(int userId, String name, int age, String gender, double weight, double height) {
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.weight = weight;
    this.height = height;
}
```

### 3. Getter Methods (Accessors)
Methods that return the values of private attributes, providing controlled access to object data.

**Example: Accessing User properties**
```java
public String getName() {
    return name;
}

public int getAge() {
    return age;
}

public double getWeight() {
    return weight;
}
```

### 4. Abstract Classes and Methods
Abstract classes serve as blueprints for subclasses and cannot be instantiated directly.
Abstract methods must be implemented by subclasses.

**Example: HealthRecord abstract class with abstract displayRecord() method**
```java
public abstract class HealthRecord {
    protected User user;
    private int userID;
    private int recordID;
    private String date;
    
    public abstract String displayRecord();
}
```

### 5. Inheritance and Method Overriding
Inheritance allows a subclass to inherit properties and methods from a parent class.
Subclasses override parent methods to provide specific implementations.

**Example: DailyActivity extends HealthRecord and overrides displayRecord()**
```java
public class DailyActivity extends HealthRecord {
    private String activityType;
    private double duration;
    
    @Override
    public String displayRecord() {
        // Custom implementation for activity records
        return String.format("Activity: %s, Duration: %.2f minutes", 
                           activityType, duration);
    }
}
```

### 6. ArrayList Data Structure
ArrayList is a resizable array implementation that can grow or shrink dynamically.
It provides efficient access by index and flexible insertion/deletion operations.

**Example: Storing multiple users and health records**
```java
private List<User> users;
private List<HealthRecord> healthRecords;

public TrackingList(){
    this.users = new ArrayList<>();
    this.healthRecords = new ArrayList<>();
}
```

### 7. Generics
Generics provide type safety by specifying the type of elements a collection will hold.
This eliminates type casting and catches type errors at compile time.

**Syntax: `List<Type>` specifies what type of objects the collection will contain**
```java
private List<User> users;              // ArrayList of User objects
private List<HealthRecord> healthRecords;  // ArrayList of HealthRecord objects
```

### 8. Basic Operations on Collections
Common ArrayList operations for managing data:

- **add()**: Insert an element at the end of the list
- **get()**: Retrieve element at a specific index
- **remove()**: Remove an element from the list
- **size()**: Get the number of elements
- **isEmpty()**: Check if list is empty

**Example: Managing users in TrackingList**
```java
public void addUser(User user){
    users.add(user);
}

public User findUser(int userId){
    for (User user : users){
        if (user.getUserId() == userId){
            return user;
        }
    }
    return null;
}

public List<User> getAllUsers(){
    return new ArrayList<>(users);
}
```

### 9. Enhanced For Loop
Also known as for-each loop, simplifies iteration through collections without using index.

**Syntax: `for (Type variable : collection)`**
```java
// Iterate through all users
for (User user : users){
    if (user.getUserId() == userId){
        return user;
    }
}

// Iterate through all health records
for (HealthRecord record : healthRecords){
    System.out.println(record.displayRecord());
}
```

### 10. Object Creation and Initialization
Use the `new` keyword to create object instances with appropriate constructors.

**Example: Creating User and health record objects**
```java
User user = new User(1, "John Doe", 30, "Male", 75.5, 1.80);
trackingList.addUser(user);

NutritionRecord meal = new NutritionRecord("Breakfast", 450.0, user, 1, 101, "2025-05-14");
trackingList.addHealthRecord(meal);
```

### 11. Method Overloading and Polymorphism
Different methods can have the same name but different parameter lists.
Polymorphism allows treating different subclasses through a common interface.

**Example: Different record types with common displayRecord() method**
```java
// All subclasses implement displayRecord() differently
DailyActivity activity = new DailyActivity(...);
NutritionRecord nutrition = new NutritionRecord(...);
SleepRecord sleep = new SleepRecord(...);

// Each displays in its own format
System.out.println(activity.displayRecord());
System.out.println(nutrition.displayRecord());
System.out.println(sleep.displayRecord());
```

### 12. Business Logic Methods
Methods that perform calculations and analysis on health data.

**Example: Calculating BMI and METs (Metabolic Equivalent of Task)**
```java
// BMI Calculation in User class
public double calculateBMI() {
    if (this.height > 0) {
        return weight / (height * height);
    }
    return 0;
}

// METs Calculation in DailyActivity class
public double calculateMet() {
    switch (this.activityType) {
        case "Rest":   return 1.0;
        case "Walk":   return 4.0;
        case "Run":    return 8.0;
        default:       return 0;
    }
}
```

## Project Structure

```
HealthTrackingSystem/
├── src/healthtrackingsystem/
│   ├── User.java                      (Class representing a user with health metrics)
│   ├── HealthRecord.java              (Abstract base class for health records)
│   ├── DailyActivity.java             (Activity tracking records)
│   ├── NutritionRecord.java           (Nutrition/meal tracking records)
│   ├── SleepRecord.java               (Sleep tracking records)
│   ├── TrackingList.java              (Collection management with ArrayList)
│   ├── HealthTrackingSystem.java      (Main application entry point)
│   └── HealthTrackingSystemGUI.java   (GUI interface with Swing)
├── build/                             (Compiled class files)
├── nbproject/                         (NetBeans project configuration)
├── build.xml                          (Ant build configuration)
├── manifest.mf                        (JAR manifest file)
└── README.md                          (This file)
```

## Key Classes

### User.java
Represents a user with personal health information:
- **Attributes**: userId, name, age, gender, weight, height
- **Constructor**: Initialize user with all personal health data
- **Getter Methods**: Get all user properties
- **Business Methods**: 
  - `calculateBMI()`: Calculate Body Mass Index
  - `resultBMI()`: Classify BMI into health categories

### HealthRecord.java (Abstract)
Base class for all health records:
- **Attributes**: user, userID, recordID, date
- **Abstract Method**: `displayRecord()` - implemented by subclasses
- Provides common structure for all health record types

### DailyActivity.java
Track physical activities and calculate energy expenditure:
- **Attributes**: activityType (Rest, Walk, Run), duration
- **Methods**: 
  - `calculateMet()`: Calculate Metabolic Equivalent of Task
  - `displayRecord()`: Display activity details
- Inherits from HealthRecord

### NutritionRecord.java
Track nutritional intake:
- **Attributes**: mealType (Breakfast, Lunch, etc.), calories
- **Methods**: 
  - `displayRecord()`: Display meal details with formatting
- Inherits from HealthRecord

### SleepRecord.java
Track sleep quality and duration:
- **Attributes**: hourSleep (hours of sleep)
- **Methods**: 
  - `sleepCategory()`: Categorize sleep as "Ideal", "Oversleep", or "Not enough"
  - `displayRecord()`: Display sleep record details
- Inherits from HealthRecord

### TrackingList.java
Central management system using ArrayList:
- **Collections**: 
  - `List<User>` - stores all users
  - `List<HealthRecord>` - stores all health records
- **Key Methods**:
  - `addUser()`, `addHealthRecord()` - add new records
  - `findUser()`, `findRecord()` - search by ID
  - `getAllUsers()`, `getAllHealthRecord()` - retrieve all records
- Demonstrates ArrayList operations and generics

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| **Abstract Class** | Define common interface for different health record types |
| **Inheritance** | Share common attributes and methods across record types |
| **ArrayList** | Dynamic collection for storing variable number of users/records |
| **Generics** | Type-safe collections (List<User>, List<HealthRecord>) |
| **Constructor** | Initialize objects with required properties |
| **Getter Methods** | Provide controlled access to private attributes |
| **Method Overriding** | Each record type implements displayRecord() differently |
| **Enhanced For Loop** | Iterate through collections cleanly |
| **Polymorphism** | Different record types treated uniformly through common interface |
| **Business Logic** | Calculate health metrics (BMI, METs, sleep quality) |

## How to Run

### Using NetBeans IDE
1. Open the project in NetBeans
2. Right-click the project and select "Clean and Build"
3. Click Run → Run Project (or press F6)

### Using Command Line

**Compile the project:**
```bash
javac -d build/classes src/healthtrackingsystem/*.java
```

**Run the main application:**
```bash
java -cp build/classes healthtrackingsystem.HealthTrackingSystem
```

**Run with GUI:**
```bash
java -cp build/classes healthtrackingsystem.HealthTrackingSystemGUI
```

## Expected Output

When you run the application, it will:
1. Create a TrackingList to manage users and health records
2. Create User objects with personal health information
3. Create various health record objects (nutrition, sleep, activity)
4. Display formatted health records with relevant metrics
5. Demonstrate BMI calculations and sleep quality assessment

**Example Output:**
```
MEAL RECORD
---------------------
Record ID        : 101
User ID          : 1
Date             : 2025-05-14
Meal Type        : Breakfast
Calories         : 450.00 kcal

SLEEP RECORD
------------------------
Record ID        : 102
User ID          : 1
Date             : 2025-05-14
Hour Sleep       : 8
Sleep Category   : Ideal sleep

ACTIVITY RECORD
------------------------
Record ID        : 103
User ID          : 1
Date             : 2025-05-14
Activity Type    : Run
Duration         : 30.00 minutes
```

## Learning Outcomes

After completing this project, you will understand:

✓ How to design classes and create objects  
✓ How to use constructors and getter methods  
✓ How to work with abstract classes and inheritance  
✓ How to override abstract methods in subclasses  
✓ How to use ArrayList for dynamic collections  
✓ How to use Generics for type-safe collections  
✓ How to iterate through collections with enhanced for loops  
✓ How to implement polymorphism with abstract classes  
✓ How to structure a multi-class application  
✓ How to perform business logic calculations  

## Project Metadata

| Property | Value |
|----------|-------|
| **Created** | 23/6/2025 |
| **Language** | Java |
| **Programming Level** | Intermediate |
| **Topic** | OOP, Data Structures, Health Management System |
| **Build Tool** | Ant / NetBeans |
| **IDE** | NetBeans |

---
