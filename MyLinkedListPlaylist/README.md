# Java Learning Material - MyLinkedListPlaylist Project

## Overview
This is a beginner-friendly Java learning project that demonstrates fundamental data structures and Object-Oriented Programming (OOP) concepts through a practical Music Playlist application using LinkedLists.

## Java Fundamentals Covered

### 1. Classes and Objects
- A class is a blueprint for creating objects
- Objects are instances of classes with properties (attributes) and behaviors (methods)
- Example: `Song` class represents a music track with title and artist properties

```java
public class Song {
    String title, artist;
    
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
}
```

### 2. Constructor
- Special method called when an object is created
- Used to initialize object properties
- Example: `Song(String title, String artist)` initializes a song with title and artist

```java
public Song(String title, String artist) {
    this.title = title;
    this.artist = artist;
}
```

### 3. Getter Methods (Accessors)
- Methods that return the values of private or protected attributes
- Provide controlled access to object data
- Example: `getTitle()` and `getArtist()` methods allow reading song properties

```java
public String getTitle() {
    return title;
}

public String getArtist() {
    return artist;
}
```

### 4. Method Overriding - toString()
- Override the default `toString()` method for custom string representation
- Provides a readable format when printing objects
- Example: Converting a Song object to a meaningful string format

```java
@Override
public String toString() {
    return "[title=" + title + ", artist=" + artist + "]";
}
```

### 5. LinkedList Data Structure
- A linear data structure where elements are stored in nodes
- Each node contains a reference to the next node
- LinkedList allows efficient insertion and deletion at any position
- Java provides `LinkedList<T>` class from `java.util` package

```java
LinkedList<String> songNames = new LinkedList<>();
songNames.add("Song1");
songNames.add("Song2");
```

### 6. Generics
- Allow you to specify the type of elements a collection will hold
- Provides type safety and eliminates type casting
- Syntax: `LinkedList<Type>` specifies what type of objects the list will contain
- Examples: `LinkedList<String>`, `LinkedList<Song>`

```java
LinkedList<String> artist = new LinkedList<>();
LinkedList<Song> playlist = new LinkedList<>();
```

### 7. Basic Operations on LinkedList
- `add()`: Insert an element at the end of the list
- `get(index)`: Retrieve element at a specific index
- `remove()`: Remove an element from the list
- `size()`: Get the number of elements
- `isEmpty()`: Check if list is empty

```java
LinkedList<Song> playlist = new LinkedList<>();
playlist.add(new Song("Imagine", "John Lennon"));  // Add
Song song = playlist.get(0);                        // Get
System.out.println(playlist);                       // Print all
```

### 8. Enhanced For Loop
- Also known as for-each loop
- Simplifies iteration through collections without using index
- Syntax: `for (Type variable : collection)`
- Example: Iterating through all songs in the playlist

```java
for (Song song : playlist) {
    System.out.println(song);
}
```

### 9. Object Creation and Initialization
- Use `new` keyword to create object instances
- Initialize with appropriate constructors
- Can create and add objects to collections in a loop
- Example: Creating Song objects and adding them to LinkedList

```java
for (int i = 0; i < 5; i++) {
    playlist.add(new Song(songNames.get(i), artistNames.get(i)));
}
```

### 10. System Output (println)
- Display data to console using `System.out.println()`
- Works with any object that has proper `toString()` implementation
- Useful for debugging and displaying results

```java
System.out.println("Playlist: " + playlist);
for (Song song : playlist) {
    System.out.println(song);
}
```

## Project Structure

```
MyLinkedListPlaylist/
├── src/mylinkedlistplaylist/
│   ├── Song.java                    (Class representing a song)
│   └── MyLinkedListPlaylist.java   (Main application with LinkedList operations)
├── build/                           (Compiled class files)
├── nbproject/                      (NetBeans project configuration)
└── README.md                       (This file)
```

## Key Classes

### Song.java
Represents a single song in the playlist with:
- **Attributes**: `title` (String), `artist` (String)
- **Constructor**: Initialize song with title and artist
- **Getter Methods**: `getTitle()`, `getArtist()`
- **toString()**: Custom string representation

### MyLinkedListPlaylist.java
Main application that demonstrates:
- Creating multiple LinkedLists
- Storing data in LinkedLists
- Creating Song objects
- Iterating through collections
- Displaying playlist information

## Key Concepts Summary

| Concept | Purpose |
|---------|---------|
| LinkedList | Dynamic data structure for storing ordered elements |
| Generics | Type-safe collections specifying element types |
| Constructor | Initialize objects with properties |
| Getter Methods | Provide controlled access to object attributes |
| toString() Override | Custom string representation of objects |
| Enhanced For Loop | Simple iteration through collections |
| Objects in Collections | Store complex data types, not just primitives |

## How to Run

### Using NetBeans IDE
1. Open the project in NetBeans
2. Click Run → Run Project (or press F6)

### Using Command Line

**Compile the project:**
```bash
javac -d build/classes src/mylinkedlistplaylist/*.java
```

**Run the main application:**
```bash
java -cp build/classes mylinkedlistplaylist.MyLinkedListPlaylist
```

## Expected Output
When you run the application, it will:
1. Create LinkedLists for song titles and artists
2. Create Song objects from the data
3. Display the raw song titles
4. Display the raw artist names
5. Display the formatted playlist with title and artist pairs

Example:
```
Song: [A, b, c, d, e]
artist: [q, w, e, r, t]
[title=A, artist=q]
[title=b, artist=w]
[title=c, artist=e]
[title=d, artist=r]
[title=e, artist=t]
```

## Learning Progression

This project is ideal for:
- **Beginner Java developers** learning about data structures
- Understanding how to use built-in Java collections
- Learning object-oriented principles (classes, objects, encapsulation)
- Practicing loops and iteration techniques

## Further Enhancements

To expand your learning, consider adding:
1. Methods to add/remove songs interactively
2. Search functionality to find songs by title or artist
3. Display playlist in different formats
4. Add song duration as a property
5. Implement custom comparators for sorting
6. Use ArrayList instead of LinkedList and compare performance

---

**Created:** May 13, 2026  
**Language:** Java  
**Programming Level:** Beginner to Intermediate  
**Topic:** Data Structures & Object-Oriented Programming
