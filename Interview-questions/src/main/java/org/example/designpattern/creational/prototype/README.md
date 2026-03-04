## Prototype Design Pattern – In Depth (Java)

### 1. What is the Prototype pattern?

- **Definition**: Prototype is a **creational design pattern** that lets you **create new objects by copying existing instances** (prototypes) rather than creating them from scratch.
- **Intent**: Avoid the cost of creating objects in a standard way (which can be expensive) and instead **clone existing instances** to create new ones. This is especially useful when:
  - Object creation is expensive (e.g., database queries, network calls, complex calculations).
  - You want to avoid subclassing to create different types of objects.
  - You need to create objects at runtime that are similar to existing ones.

In this package, the classes `BookStore`, `Book`, and `PrototypeDemo` demonstrate how to clone a `BookStore` object using the Prototype pattern.

---

### 2. Problem that Prototype solves (motivation)

When you need to create objects that are similar to existing ones, you typically have these options:

- **Creating new objects from scratch**:
  ```java
  BookStore bs1 = new BookStore();
  bs1.setStoreName("Student");
  bs1.loadBooks(); // Expensive operation - database query, file I/O, etc.
  
  BookStore bs2 = new BookStore();
  bs2.setStoreName("A1");
  bs2.loadBooks(); // Same expensive operation again!
  ```
  - **Problem**: If `loadBooks()` is expensive (database queries, file I/O, network calls), creating multiple similar objects becomes inefficient.
  - **Problem**: You have to repeat the same initialization logic.

- **Copying object references**:
  ```java
  BookStore bs2 = bs1; // Just copying reference
  ```
  - **Problem**: Both variables point to the same object. Changes to one affect the other.
  - **Problem**: Not creating a new independent object.

**Prototype** solves these problems by providing:

- A **`clone()` method** that creates a copy of the existing object.
- **Independent copies** that can be modified without affecting the original.
- **Performance benefits** by avoiding expensive initialization when you can clone instead.

---

### 3. Key participants in this example

- **`BookStore` (Prototype)**
  - Implements `Cloneable` interface (Java's built-in marker interface for cloning).
  - Contains fields: `storeName` and a list of `Book` objects.
  - Has a `loadBooks()` method that populates the books list (simulating an expensive operation).
  - Implements `clone()` method to create copies of itself.
  - Example:
    ```java
    public class BookStore implements Cloneable {
        private String storeName;
        private List<Book> books = new ArrayList<>();
        
        public void loadBooks() { /* ... */ }
        
        @Override
        protected BookStore clone() throws CloneNotSupportedException {
            // Deep cloning implementation
        }
    }
    ```

- **`Book` (Nested Prototype)**
  - Also implements `Cloneable` to support deep cloning.
  - Contains fields: `bookId` and `bookName`.
  - Implements `clone()` method to create copies of individual books.
  - Example:
    ```java
    public class Book implements Cloneable {
        private int bookId;
        private String bookName;
        
        @Override
        protected Book clone() throws CloneNotSupportedException {
            return (Book) super.clone();
        }
    }
    ```

- **`PrototypeDemo` (Client)**
  - Creates a prototype `BookStore` object and initializes it.
  - Uses `clone()` to create new `BookStore` instances from the prototype.
  - Demonstrates that cloned objects are independent.
  - Example:
    ```java
    BookStore bs = new BookStore();
    bs.setStoreName("Student");
    bs.loadBooks(); // Expensive operation done once
    
    BookStore bs1 = bs.clone(); // Fast clone operation
    bs1.setStoreName("A1"); // Modify clone independently
    ```

---

### 4. How the Prototype pattern works (step by step)

1. **Create the Prototype class (`BookStore`)**
   - Implement `Cloneable` interface (Java's marker interface).
   - Define all fields that need to be copied.
   - Implement `clone()` method:
     ```java
     @Override
     protected BookStore clone() throws CloneNotSupportedException {
         BookStore shop = new BookStore();
         shop.setStoreName(this.storeName); // Copy primitive/String fields
         // Deep clone: create new instances of nested objects
         for(Book b: this.getBooks()){
             shop.getBooks().add(b.clone()); // Clone each Book object
         }
         return shop;
     }
     ```

2. **Handle nested objects (`Book`)**
   - If your prototype contains other objects, they should also implement `Cloneable`.
   - In `BookStore.clone()`, call `clone()` on each nested object to perform **deep cloning**.

3. **Use the Prototype from client code (`PrototypeDemo`)**
   - Create and initialize a prototype object once (including expensive operations).
   - Clone the prototype to create new instances:
     ```java
     BookStore bs1 = bs.clone();
     ```
   - Modify cloned objects independently without affecting the original.

4. **Result**
   - New objects are created **quickly** by copying existing ones.
   - Cloned objects are **independent** (deep cloning ensures no shared references).
   - Expensive initialization is done **once** on the prototype.

---

### 5. Shallow Cloning vs Deep Cloning

This is a **critical concept** in the Prototype pattern:

#### Shallow Cloning
- **What it does**: Creates a new object but **shares references** to nested objects.
- **Problem**: Changes to nested objects in the clone affect the original.
- **Example**:
  ```java
  @Override
  protected Object clone() throws CloneNotSupportedException {
      return super.clone(); // Shallow clone
  }
  ```
  - If you remove a book from `bs1`, it also disappears from `bs` because both share the same `List<Book>` reference.

#### Deep Cloning
- **What it does**: Creates a new object **and new instances** of all nested objects.
- **Benefit**: Cloned objects are completely independent.
- **Example** (current implementation):
  ```java
  @Override
  protected BookStore clone() throws CloneNotSupportedException {
      BookStore shop = new BookStore();
      shop.setStoreName(this.storeName);
      // Deep clone: create new Book instances
      for(Book b: this.getBooks()){
          shop.getBooks().add(b.clone()); // Clone each Book
      }
      return shop;
  }
  ```
  - If you remove a book from `bs1`, `bs` remains unaffected because they have separate lists with separate `Book` objects.

#### Visual Comparison

**Shallow Cloning:**
```
bs (BookStore)          bs1 (BookStore)
    |                        |
    └─── books (List) ───────┘  (shared reference)
            |
            └─── [Book1, Book2, Book3]
```

**Deep Cloning:**
```
bs (BookStore)          bs1 (BookStore)
    |                        |
    └─── books (List)        └─── books (List)  (separate lists)
            |                        |
            └─── [Book1, Book2, Book3]    └─── [Book1', Book2', Book3']  (separate Book objects)
```

---

### 6. Typical structure (simplified example)

Below is a generic example to illustrate the pattern:

```java
// Prototype class
public class PrototypeClass implements Cloneable {
    private String field1;
    private List<NestedObject> nestedObjects;
    
    // Expensive initialization
    public void expensiveInitialization() {
        // Database query, file I/O, network call, etc.
    }
    
    // Deep clone implementation
    @Override
    protected PrototypeClass clone() throws CloneNotSupportedException {
        PrototypeClass clone = new PrototypeClass();
        clone.setField1(this.field1); // Copy primitive/String fields
        
        // Deep clone nested objects
        for(NestedObject obj : this.nestedObjects) {
            clone.getNestedObjects().add(obj.clone());
        }
        
        return clone;
    }
}

// Nested object (also implements Cloneable)
public class NestedObject implements Cloneable {
    private int id;
    private String name;
    
    @Override
    protected NestedObject clone() throws CloneNotSupportedException {
        return (NestedObject) super.clone(); // Simple clone for primitive fields
    }
}

// Client usage
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create and initialize prototype (expensive operation once)
        PrototypeClass prototype = new PrototypeClass();
        prototype.expensiveInitialization();
        
        // Clone to create new instances (fast operation)
        PrototypeClass clone1 = prototype.clone();
        PrototypeClass clone2 = prototype.clone();
        
        // Modify clones independently
        clone1.setField1("Modified");
        // prototype and clone2 remain unchanged
    }
}
```

---

### 7. Benefits of Prototype pattern

1. **Performance**: Avoids expensive object creation by cloning existing instances.
2. **Flexibility**: Create objects at runtime without knowing their exact classes.
3. **Reduced Subclassing**: Avoids creating subclasses just to configure objects differently.
4. **Dynamic Configuration**: Objects can be configured at runtime and then cloned.
5. **Independence**: Deep cloning ensures cloned objects are independent of the original.

---

### 8. When to use Prototype pattern

Use the Prototype pattern when:

- ✅ **Object creation is expensive** (database queries, network calls, file I/O, complex calculations).
- ✅ You need to **create many similar objects** with slight variations.
- ✅ You want to **avoid subclassing** to create different object configurations.
- ✅ Objects have **many possible configurations**, and you want to avoid creating many constructors.
- ✅ You need to **create objects at runtime** based on existing instances.

**Real-world examples:**
- **Game development**: Cloning game objects (characters, weapons) with different configurations.
- **Database operations**: Cloning objects that represent database records.
- **GUI applications**: Cloning UI components with similar properties.
- **Configuration objects**: Cloning configuration objects with different settings.

---

### 9. Implementation details in this example

#### BookStore.java
- Implements `Cloneable` interface.
- Contains `storeName` (String) and `books` (List<Book>).
- `loadBooks()` simulates an expensive operation (in real scenarios, this might be a database query).
- `clone()` method performs **deep cloning**:
  - Creates a new `BookStore` instance.
  - Copies `storeName` field.
  - Clones each `Book` object in the list to create independent copies.

#### Book.java
- Implements `Cloneable` interface.
- Contains `bookId` (int) and `bookName` (String).
- `clone()` method uses `super.clone()` which works fine for primitive/String fields.

#### PrototypeDemo.java
- Creates a prototype `BookStore` and initializes it with books.
- Clones the prototype to create a new `BookStore`.
- Demonstrates independence: removing a book from one store doesn't affect the other.

---

### 10. Best Practices

1. **Always implement deep cloning** for objects containing mutable nested objects (Lists, Maps, custom objects).
2. **Use `Cloneable` interface** in Java, but be aware it's a marker interface (no methods).
3. **Handle `CloneNotSupportedException`** properly (either catch it or declare it in method signature).
4. **Consider using copy constructors** as an alternative to `clone()`:
   ```java
   public BookStore(BookStore other) {
       this.storeName = other.storeName;
       this.books = new ArrayList<>();
       for(Book b : other.books) {
           this.books.add(new Book(b));
       }
   }
   ```
5. **Document cloning behavior** (shallow vs deep) in your code comments.
6. **Test cloning thoroughly** to ensure independence of cloned objects.

---

### 11. Common pitfalls and how to avoid them

1. **Shallow cloning when deep cloning is needed**
   - **Problem**: Nested objects are shared between original and clone.
   - **Solution**: Always clone nested objects explicitly in your `clone()` method.

2. **Forgetting to copy fields**
   - **Problem**: Some fields are not copied, leaving clone in inconsistent state.
   - **Solution**: Systematically copy all fields in `clone()` method.

3. **Not handling exceptions**
   - **Problem**: `CloneNotSupportedException` not handled properly.
   - **Solution**: Either catch the exception or declare it in method signature.

4. **Cloning immutable objects unnecessarily**
   - **Problem**: Cloning `String` or `Integer` objects (they're immutable, so sharing is safe).
   - **Solution**: For immutable objects, you can share references safely.

---

### 12. Running the example

To run the Prototype pattern example:

```bash
# Compile
javac -d out src/main/java/org/example/designpattern/creational/prototype/*.java

# Run
java -cp out org.example.designpattern.creational.prototype.PrototypeDemo
```

**Expected output:**
```
Loading books.....
BookStore{storeName='Student', books=[Book{bookId=1, bookName='Book 1'}, Book{bookId=2, bookName='Book 2'}, Book{bookId=4, bookName='Book 4'}, ...]}
BookStore{storeName='A1', books=[Book{bookId=1, bookName='Book 1'}, Book{bookId=2, bookName='Book 2'}, Book{bookId=3, bookName='Book 3'}, ...]}
```

Notice that:
- The first `BookStore` has book at index 2 removed (only 9 books).
- The second `BookStore` still has all 10 books (independent copy).
- Both have different `storeName` values.

This demonstrates that **deep cloning** creates truly independent objects.

---

### 13. Summary

The **Prototype pattern** is a powerful creational pattern that allows you to:
- Create new objects by cloning existing ones.
- Avoid expensive object creation operations.
- Create independent copies of complex objects.
- Configure objects at runtime and clone them.

**Key takeaway**: Always implement **deep cloning** when your prototype contains mutable nested objects to ensure true independence between the original and cloned objects.
