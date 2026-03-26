# Composite Design Pattern

## Overview
The Composite Design Pattern is a structural design pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. It enables clients to treat individual objects and compositions of objects uniformly.

---

## Key Idea
The pattern organizes objects in a tree structure where:
- Leaf nodes represent individual objects
- Composite nodes represent groups of objects

Both share a common interface, allowing uniform operations.

---

## Problem It Solves
When working with hierarchical data structures (like file systems, UI components, or organization charts), handling individual objects and groups differently complicates the code.

The Composite pattern solves this by providing a unified interface.

---

## Structure

### 1. Component
Defines the common interface for both leaf and composite objects.

```java
interface Component {
    void operation();
}
```

### 2. Leaf
Represents individual objects with no children.

```java
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}
```

### 3. Composite
Represents a group of components and can contain both Leaf and Composite.

```java
import java.util.*;

class Composite implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite: " + name);
        for (Component child : children) {
            child.operation();
        }
    }
}
```

---

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        Leaf file1 = new Leaf("file1.txt");
        Leaf file2 = new Leaf("file2.txt");

        Composite folder = new Composite("Documents");
        folder.add(file1);
        folder.add(file2);

        Composite root = new Composite("Root");
        root.add(folder);

        root.operation();
    }
}
```

---

## Real-World Examples
- File systems (files and folders)
- UI components (buttons, panels)
- Organization structures
- Menu systems

---

## Advantages
- Simplifies client code
- Supports recursive composition
- Makes it easy to add new types of components
- Uniform treatment of objects and compositions

---

## Disadvantages
- Can make the design overly generic
- Difficult to enforce constraints (e.g., restricting child types)

---

## When to Use
- When dealing with tree-like hierarchical data
- When you want clients to ignore differences between objects and compositions
- When structure can be represented recursively

---

## Comparison with Similar Patterns

| Pattern | Purpose |
|--------|--------|
| Composite | Tree structure handling |
| Decorator | Add responsibilities dynamically |
| Proxy | Control access to an object |

---

## Best Practices
- Keep the component interface minimal
- Avoid putting too much logic in composite classes
- Use recursion carefully to avoid performance issues

---

## Conclusion
The Composite Design Pattern is ideal for representing hierarchical structures and enables consistent handling of both individual and grouped objects. It improves code flexibility and scalability when dealing wi