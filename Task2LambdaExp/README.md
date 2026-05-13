# Java Learning Material - Task2LambdaExp Project

## Overview
This is a beginner-friendly Java learning project that demonstrates **Lambda Expressions** and **Functional Interfaces** through a practical Temperature Conversion application. This project showcases how modern Java (Java 8+) uses functional programming concepts to write cleaner, more concise code.

## Java Fundamentals Covered

### 1. Functional Interfaces
A functional interface is an interface with exactly one abstract method.
Functional interfaces are the foundation for lambda expressions.
Can be marked with `@FunctionalInterface` annotation for clarity.

Example: Temperature Converter Interface
```java
public interface TemperatureConverter {
    double convert(double value);
}
```

### 2. Lambda Expressions
Lambda expressions provide a concise way to implement functional interfaces.
Syntax: `(parameters) -> { body }`
Alternative syntax for single expressions: `parameter -> expression`
Eliminates the need for anonymous inner classes.

Example: Celsius to Fahrenheit Conversion
```java
TemperatureConverter celsiusToFahrenheit = x -> {
    double cf = (x * 9 / 5.0) + 32;
    return cf;
};
```

### 3. Lambda Expression Syntax Variations

**Single Parameter, No Parentheses:**
```java
x -> x * 2
```

**Multiple Parameters:**
```java
(x, y) -> x + y
```

**No Parameters:**
```java
() -> System.out.println("Hello")
```

**Block Body with Multiple Statements:**
```java
x -> {
    double result = x * 9 / 5.0 + 32;
    System.out.println("Converted: " + result);
    return result;
}
```

### 4. Functional Programming Benefits
**Conciseness**: Write less boilerplate code
**Readability**: Intent is clearer with lambdas
**Flexibility**: Easy to pass behavior as parameters
**Type Safety**: Compiler enforces type checking

Example Benefit - Without Lambda (Anonymous Class):
```java
TemperatureConverter converter = new TemperatureConverter() {
    @Override
    public double convert(double x) {
        return (x * 9 / 5.0) + 32;
    }
};
```

With Lambda:
```java
TemperatureConverter converter = x -> (x * 9 / 5.0) + 32;
```

### 5. Method References (Introduction)
An alternative to lambda expressions using the `::` operator.
Refers to existing methods by name.

Example: `System.out::println` instead of `s -> System.out.println(s)`

### 6. Scope and Variable Capturing
Lambda expressions can access variables from their enclosing scope.
Variables must be **effectively final** (not modified after first assignment).

Example:
```java
double fahrenheit = 32.0;
TemperatureConverter converter = x -> x + fahrenheit; // Valid
```

### 7. Type Inference
Lambda expressions use **type inference** to determine parameter types.
The compiler infers types from the functional interface.

Example - Compiler infers that `x` is `double`:
```java
TemperatureConverter converter = x -> (x * 9 / 5.0) + 32;
```

### 8. Higher-Order Functions
Functions that take other functions as parameters or return functions.
Enables powerful functional programming patterns.

Example: Method accepting a functional interface parameter
```java
public static void applyConversion(TemperatureConverter converter, double temp) {
    System.out.println("Result: " + converter.convert(temp));
}
```

### 9. Conditional Logic in Lambdas
Lambda expressions can contain complex logic including conditionals.
Useful for validation and conditional conversions.

Example: Celsius to Kelvin with validation
```java
TemperatureConverter celsiusToKelvin = x -> {
    double result = x + 273.15;
    if (result < 0) {
        System.out.println("Result is absolute zero for Celsius to Kelvin");
    }
    return result;
};
```

### 10. Input/Output and Temperature Conversions
Use `Scanner` to read user input.
Perform mathematical calculations with the lambda expressions.
Display formatted results to console.

Example: Reading temperature and applying conversions
```java
Scanner in = new Scanner(System.in);
System.out.print("Enter Temperature: ");
double temp = in.nextDouble();

double fahrenheit = celsiusToFahrenheit.convert(temp);
System.out.println("Celsius to Fahrenheit: " + fahrenheit + " F");
```

## Project Structure
```
Task2LambdaExp/
├── src/task2lambdaexp/
│   ├── TemperatureConverter.java   (Functional Interface)
│   └── Task2LambdaExp.java         (Main application with Lambda Expressions)
├── build/                           (Compiled class files)
├── nbproject/                       (NetBeans project configuration)
├── build.xml                        (Ant build file)
└── README.md                        (This file)
```

## Key Classes

### TemperatureConverter.java
A **functional interface** that defines the contract for temperature conversions:
- **Method**: `double convert(double value)` - Converts a temperature value
- **Purpose**: Serves as the foundation for lambda expressions

### Task2LambdaExp.java
Main application demonstrating lambda expressions with four temperature conversions:
- **Celsius to Fahrenheit**: `TemperatureConverter a = x -> { ... }`
- **Fahrenheit to Celsius**: `TemperatureConverter b = x -> { ... }`
- **Celsius to Kelvin**: `TemperatureConverter c = x -> { ... }`
- **Kelvin to Celsius**: `TemperatureConverter d = x -> { ... }`

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| Functional Interface | Interface with single abstract method supporting lambdas |
| Lambda Expression | Concise syntax for implementing functional interface methods |
| Type Inference | Compiler determines parameter types automatically |
| Variable Capturing | Lambda accesses variables from enclosing scope |
| Block Body | Multiple statements with explicit return statement |
| Conditional Logic | Control flow (if/else) within lambda expressions |
| Scanner Input | Read user input from console |
| Mathematical Formulas | Temperature conversion calculations |

## Temperature Conversion Formulas

| Conversion | Formula |
|-----------|---------|
| Celsius to Fahrenheit | °F = (°C × 9/5) + 32 |
| Fahrenheit to Celsius | °C = (°F - 32) × 5/9 |
| Celsius to Kelvin | K = °C + 273.15 |
| Kelvin to Celsius | °C = K - 273.15 |

## How to Run

### Using NetBeans IDE
1. Open the project in NetBeans
2. Click **Run → Run Project** (or press **F6**)
3. Enter a temperature value when prompted

### Using Command Line
Compile the project:
```bash
javac -d build/classes src/task2lambdaexp/*.java
```

Run the main application:
```bash
java -cp build/classes task2lambdaexp.Task2LambdaExp
```

## Expected Output

When you run the application, it will:
1. Prompt you to enter a temperature value
2. Convert the temperature using all four lambda expressions
3. Display the conversion results in Fahrenheit, Celsius, and Kelvin
4. Show validation messages for absolute zero scenarios

Example Run:
```
Enter Temperature: 25
===== Temperature Conversion Result =====
Celsius to Fahrenheit: 77.0 F
Fahrenheit to Celsius: -3.8888888888888884 C
Celsius to Kelvin: 298.15 K
Kelvin to Celsius: -248.15 C
```

Example with Edge Case:
```
Enter Temperature: 0
===== Temperature Conversion Result =====
Celsius to Fahrenheit: 32.0 F
Fahrenheit to Celsius: -17.777777777777778 C
Celsius to Kelvin: 273.15 K
Kelvin to Celsius: -273.15 C
```

## Key Differences: Traditional vs Lambda Approach

**Traditional Approach (Before Java 8):**
```java
TemperatureConverter converter = new TemperatureConverter() {
    @Override
    public double convert(double x) {
        return (x * 9 / 5.0) + 32;
    }
};
```

**Modern Approach (Java 8+):**
```java
TemperatureConverter converter = x -> (x * 9 / 5.0) + 32;
```

## Further Exploration

1. **Streams API**: Use lambdas with collections (`Stream`, `filter()`, `map()`)
2. **Method References**: Refactor lambdas using the `::` operator
3. **Functional Composition**: Combine multiple lambda expressions
4. **Custom Functional Interfaces**: Design your own functional interfaces for specific use cases
5. **Lambda Exception Handling**: Handle checked exceptions in lambda expressions

---

**Created**: 24/11/2025  
**Language**: Java  
**Programming Level**: Intermediate  
**Topic**: Lambda Expressions & Functional Interfaces  
**Prerequisites**: Basic Java knowledge (classes, interfaces, methods)  

