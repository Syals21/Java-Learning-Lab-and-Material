# Java Learning Material - ExcerciseFunctional Project

## Overview
This is an intermediate-level Java learning project that demonstrates **Functional Programming** concepts through practical examples. The project explores Java's built-in Functional Interfaces from the `java.util.function` package, including how to use lambdas and method references with various functional interfaces.

Functional programming is a programming paradigm that treats computation as the evaluation of mathematical functions. Java 8 introduced lambda expressions and functional interfaces, allowing developers to write more concise and expressive code.

## Java Fundamentals Covered

### 1. Functional Programming Paradigm
A programming style focused on functions as first-class citizens rather than objects.
Emphasizes immutability and avoiding changing state.
Enables writing cleaner, more readable, and more testable code.

### 2. Lambda Expressions
Anonymous functions written with concise syntax.
Syntax: `(parameters) -> expression` or `(parameters) -> { statements; }`
Provides a shorthand way to implement functional interfaces.
Example:
```java
Supplier<String> greetingMessage = () -> "Welcome to the Program!";
```

### 3. Functional Interfaces
Interfaces with a single abstract method (SAM - Single Abstract Method).
Can be implemented using lambda expressions.
Enables passing functions as parameters to methods.

### 4. Supplier\<T\>
**Purpose:** Produces/supplies a value with no input parameters
**Method:** `T get()`
**Use Case:** Generate or provide values on demand

Example from project:
```java
Supplier<String> greetingMessage = () -> "Welcome to the Program!";
String message = greetingMessage.get();  // Get the greeting
System.out.println("Greeting Message: " + message);
```

### 5. Consumer\<T\>
**Purpose:** Consumes/accepts a value and performs an action (no return value)
**Method:** `void accept(T t)`
**Use Case:** Process or handle a single value

Example from project:
```java
Consumer<String> number = s -> System.out.println(s);
number.accept("18");  // Prints: 18
```

### 6. Predicate\<T\>
**Purpose:** Tests a condition and returns a boolean result
**Method:** `boolean test(T t)`
**Use Case:** Filter or validate data based on a condition

Example from project:
```java
Predicate<Integer> mark = n -> n > 25 && n < 100;
System.out.println("Mark 88 Pass?: " + mark.test(88));  // true
System.out.println("Mark 20 Pass?: " + mark.test(20));  // false
```

### 7. Function\<T, R\>
**Purpose:** Transforms/maps input of one type to output of another type
**Method:** `R apply(T t)`
**Use Case:** Convert or transform data from one type to another

Example from project:
```java
Function<Double, Double> cf = n -> (n * 9 / 5.0) + 32;
System.out.println("30 Celsius to Fahrenheit: " + cf.apply(30.0));  // 86.0
```

### 8. UnaryOperator\<T\>
**Purpose:** Performs an operation on a single value of the same type
**Method:** `T apply(T t)`
**Use Case:** Transform a value and return the same type

Example from project:
```java
UnaryOperator<String> uppercase = s -> s.toUpperCase();
String result = uppercase.apply("Hello World");  // HELLO WORLD
```

### 9. BiConsumer\<T, U\>
**Purpose:** Consumes two values and performs an action (no return value)
**Method:** `void accept(T t, U u)`
**Use Case:** Process two related values together

Example from project:
```java
BiConsumer<String, String> print = (a, b) -> System.out.println(a + ":" + b);
print.accept("Test", "One");  // Prints: Test:One
```

### 10. BiPredicate\<T, U\>
**Purpose:** Tests a condition with two values and returns a boolean
**Method:** `boolean test(T t, U u)`
**Use Case:** Compare or validate two values

Example from project:
```java
BiPredicate<Double, Double> compare = (a, b) -> a < b;
System.out.println("Price 30 < budget 50: " + compare.test(30.0, 50.0));  // true
```

### 11. BiFunction\<T, U, R\>
**Purpose:** Transforms two inputs to a different output type
**Method:** `R apply(T t, U u)`
**Use Case:** Combine or compute from two different inputs

Example from project:
```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
System.out.println("Add 30 and 25: " + add.apply(30, 25));  // 55
```

### 12. BinaryOperator\<T\>
**Purpose:** Combines two values of the same type
**Method:** `T apply(T t, T t)`
**Use Case:** Reduce or aggregate values of the same type

Example from project:
```java
BinaryOperator<Integer> findMax = Math::max;
System.out.println("Find Maximum of (15, 7): " + findMax.apply(15, 7));  // 15
```

### 13. Method References
Shorthand syntax for lambda expressions that call existing methods
Syntax: `ClassName::methodName` or `instance::methodName`
Improves readability when delegating to existing methods

Example from project:
```java
BinaryOperator<Integer> findMax = Math::max;  // Method reference instead of lambda
```

## Project Structure
```
ExcerciseFunctional/
├── src/excercisefunctional/
│   └── ExcerciseFunctional.java    (Main application demonstrating all functional interfaces)
├── build/                          (Compiled class files)
├── nbproject/                      (NetBeans project configuration)
├── build.xml                       (Ant build script)
└── README.md                       (This file)
```

## Key Classes

### ExcerciseFunctional.java
Main application that demonstrates all functional interfaces with practical examples:

- **Supplier Example:** Creating a greeting message on demand
- **Consumer Example:** Printing a number to console
- **Predicate Example:** Validating exam marks (25-100 range)
- **Function Example:** Converting Celsius to Fahrenheit
- **UnaryOperator Example:** Converting strings to uppercase
- **BiConsumer Example:** Printing key-value pairs
- **BiPredicate Example:** Comparing prices against budget
- **BiFunction Example:** Adding two integers
- **BinaryOperator Example:** Finding maximum value using method reference

## Key Concepts Summary

| Concept | Method | Parameters | Returns | Use Case |
|---------|--------|-----------|---------|----------|
| **Supplier\<T\>** | `T get()` | None | Single value | Generate/provide values |
| **Consumer\<T\>** | `void accept(T)` | 1 value | Nothing | Process a value |
| **Predicate\<T\>** | `boolean test(T)` | 1 value | Boolean | Validate/filter data |
| **Function\<T,R\>** | `R apply(T)` | 1 value (T) | Different type (R) | Transform/convert |
| **UnaryOperator\<T\>** | `T apply(T)` | 1 value | Same type | Transform same type |
| **BiConsumer\<T,U\>** | `void accept(T,U)` | 2 values | Nothing | Process two values |
| **BiPredicate\<T,U\>** | `boolean test(T,U)` | 2 values | Boolean | Compare two values |
| **BiFunction\<T,U,R\>** | `R apply(T,U)` | 2 values | Different type | Combine two inputs |
| **BinaryOperator\<T\>** | `T apply(T,T)` | 2 same type | Same type | Reduce/aggregate |

## Lambda Expression Syntax Guide

### No parameters
```java
() -> expression
Supplier<String> greeting = () -> "Hello";
```

### Single parameter (parentheses optional)
```java
x -> expression
UnaryOperator<String> upper = s -> s.toUpperCase();
```

### Single parameter with type
```java
(Type x) -> expression
UnaryOperator<String> upper = (String s) -> s.toUpperCase();
```

### Multiple parameters
```java
(x, y) -> expression
BiConsumer<String, String> print = (a, b) -> System.out.println(a + ":" + b);
```

### Multiple statements
```java
(parameters) -> {
    // multiple statements
    return value;
}
Function<Integer, Integer> square = n -> {
    int result = n * n;
    return result;
};
```

## How to Run

### Using NetBeans IDE
1. Open the project in NetBeans
2. Click **Run → Run Project** (or press **F6**)
3. View output in the NetBeans output console

### Using Command Line

**Compile the project:**
```bash
javac -d build/classes src/excercisefunctional/*.java
```

**Run the main application:**
```bash
java -cp build/classes excercisefunctional.ExcerciseFunctional
```

### Using Apache Ant
```bash
ant run
```

## Expected Output

When you run the application, it will demonstrate each functional interface with examples:

```
Supplier: 
Greeting Message: Welcome to the Program!
===================================
Consumer: 
18
===================================
Predicate: 
Mark 88 Pass?: true
Mark 20 Pass?: false
===================================
Function: 
30 Celsius to Fahreinheit: 86.0
===================================
UnaryOperator: 
Hello word toUpperCase:HELLO WORLD
===================================
BiConsumer: 
Print "name:value"
Test:One
===================================
BiPredicate: 
Price 78 < budget 20:false
Price 30 < budget 50:true
===================================
BiFunction: 
Add 30 and 25: 55
===================================
BinaryOperator: 
Find Maximum of (15,7): 15
```

## Benefits of Functional Programming in Java

1. **Conciseness:** Lambda expressions reduce boilerplate code
2. **Readability:** Intent is clearer with functional approach
3. **Composability:** Functions can be easily combined
4. **Testability:** Pure functions are easier to test
5. **Parallelization:** Functional code works better with streams
6. **Reduced Side Effects:** Encourages immutability and pure functions

## Learning Objectives

After completing this exercise, you should understand:

✓ What functional programming is and its benefits
✓ How to write and use lambda expressions
✓ The purpose and usage of each functional interface
✓ When to use each type of functional interface
✓ How to use method references as shorthand for lambdas
✓ How functional interfaces enable functional programming in Java

## Next Steps

Once you've mastered these functional interfaces, explore:

- **Streams API:** Process collections with functional operations
- **Function Composition:** Combine functions using `compose()` and `andThen()`
- **Optional\<T\>:** Handle null values functionally
- **Custom Functional Interfaces:** Create your own interfaces with single abstract methods
- **Functional Reactive Programming:** Advanced functional patterns with libraries like RxJava

## Project Metadata

| Property | Value |
|----------|-------|
| **Created** | 27/11/2025 |
| **Language** | Java |
| **Programming Level** | Intermediate |
| **Topic** | Functional Programming & Functional Interfaces |
| **Build Tool** | Apache Ant / NetBeans |

