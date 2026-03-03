## Builder Design Pattern – In Depth (Java)

### 1. What is the Builder pattern?

- **Definition**: Builder is a **creational design pattern** that lets you **construct complex objects step by step**, separating the **construction process** from the **final representation**.
- **Intent**: Avoid long, confusing constructors (telescoping constructors) and make object creation:
  - **Readable** (self-documenting),
  - **Flexible** (optional parameters, different combinations),
  - **Safe** (no need to pass `null` for missing values).

In this package, the classes `Phone`, `PhoneBuilder`, and `Shop` demonstrate how to build a `Phone` object using the Builder pattern.

---

### 2. Problem that Builder solves (motivation)

When a class has many fields (some required, some optional), the usual options are:

- **Telescoping constructors**:
  ```java
  new Phone("Android", 4, "Snapdragon", 6.5, 5000, true, true, false);
  ```
  - Hard to read: What does each parameter mean?
  - Hard to maintain: Adding a new field requires more constructors.
  - Error-prone: Easy to swap parameters accidentally.

- **Setters (mutable objects)**:
  ```java
  Phone phone = new Phone();
  phone.setOs("Android");
  phone.setRam(4);
  // ...
  ```
  - Object may be in an **inconsistent state** until all setters are called.
  - Harder to make the class **immutable**.
  - Not ideal in multi-threaded systems or where strong invariants are needed.

**Builder** solves these problems by providing:

- A separate `Builder` class that knows how to construct the target object.
- A **fluent API** (method chaining) that makes object creation expressive and readable.
- A final **`build()`** method that produces the fully constructed object, often immutable.

---

### 3. Participants in this example

Although exact field names may differ in your code, the roles are typically:

- **`Phone` (Product)**
  - The complex object you want to create.
  - Contains several fields (e.g., OS, RAM, processor, screen size, battery, etc.).
  - Often made **immutable**: fields are `final` and only set in the constructor.

- **`PhoneBuilder` (Builder)**
  - Provides **setter-like methods** for each field, but each method returns `this` to support chaining.
  - Has a `build()` method that creates a `Phone` instance using the values accumulated in the builder.
  - Example methods (names may vary in your code):
    - `PhoneBuilder setOs(String os)`
    - `PhoneBuilder setRam(int ram)`
    - `PhoneBuilder setProcessor(String processor)`
    - `PhoneBuilder setScreenSize(double screenSize)`
    - `PhoneBuilder setBattery(int battery)`
    - `Phone build()`

- **`Shop` (Client / Director)**
  - Uses `PhoneBuilder` to create `Phone` objects.
  - Demonstrates how to call builder methods and then `build()` the final object.
  - Example (conceptually):
    ```java
    public class Shop {
        public static void main(String[] args) {
            Phone phone = new PhoneBuilder()
                    .setOs("Android")
                    .setRam(8)
                    .setProcessor("Snapdragon 8 Gen 1")
                    .setScreenSize(6.7)
                    .setBattery(5000)
                    .build();

            System.out.println(phone);
        }
    }
    ```

---

### 4. How the Builder pattern works (step by step)

1. **Create the Product class (`Phone`)**
   - Define all the fields that make up a `Phone`.
   - Provide a **constructor that accepts a `PhoneBuilder`** (or all fields).
   - Optionally, make the class **immutable** by:
     - Making fields `private final`.
     - Not exposing setters.

2. **Create the Builder class (`PhoneBuilder`)**
   - Mirror the fields of `Phone` (same or similar fields).
   - Provide **chained setter methods**:
     ```java
     public PhoneBuilder setOs(String os) {
         this.os = os;
         return this;
     }
     ```
   - Provide a `build()` method:
     ```java
     public Phone build() {
         return new Phone(this);
     }
     ```

3. **Use the Builder from client code (`Shop`)**
   - Create a builder instance.
   - Set only the fields you care about, in a readable order.
   - Call `build()` to obtain the fully constructed `Phone`.

4. **Result**
   - The constructed object (`Phone`) is **complete** and, if designed that way, **immutable**.
   - The client code is **readable** and self-explanatory.

---

### 5. Typical structure (simplified example)

Below is a generic example to illustrate the pattern (your actual code may have different field names).

```java
public class Phone {

    private final String os;
    private final int ram;
    private final String processor;
    private final double screenSize;
    private final int battery;

    // Constructor usually accepts a builder
    public Phone(PhoneBuilder builder) {
        this.os = builder.getOs();
        this.ram = builder.getRam();
        this.processor = builder.getProcessor();
        this.screenSize = builder.getScreenSize();
        this.battery = builder.getBattery();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }
}
```

```java
public class PhoneBuilder {

    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBattery() {
        return battery;
    }

    public Phone build() {
        return new Phone(this);
    }
}
```

```java
public class Shop {
    public static void main(String[] args) {
        Phone phone = new PhoneBuilder()
                .setOs("Android")
                .setRam(8)
                .setProcessor("Snapdragon 8 Gen 1")
                .setScreenSize(6.7)
                .setBattery(5000)
                .build();

        System.out.println(phone);
    }
}
```

---

### 6. Benefits of the Builder pattern

- **Readable, self-documenting object creation**
  - The chain of calls clearly shows what each argument means:
    ```java
    new PhoneBuilder()
        .setOs("Android")
        .setRam(8)
        .setBattery(5000)
        .build();
    ```

- **Avoids telescoping constructors**
  - No need for many overloaded constructors with long parameter lists.

- **Supports optional parameters easily**
  - You call only the setter methods you need.
  - Defaults can be used for other fields inside the builder.

- **Improved immutability**
  - The built object (`Phone`) can be made immutable, improving safety and thread-friendliness.

- **Better validation and invariants**
  - You can add validation logic inside `build()`:
    - e.g., ensure required fields are set, ranges are valid, etc.

- **Easy to extend**
  - Adding a new field is as simple as:
    - Adding a field in `Phone` and `PhoneBuilder`.
    - Adding a new chained setter.
    - Updating the `build()` method and `Phone` constructor.

---

### 7. When to use the Builder pattern

Use **Builder** when:

- A class has **many fields**, especially when:
  - Many are optional.
  - Some are related or depend on each other.
- You want to avoid:
  - Long constructors with many parameters.
  - Confusing parameter order or types.
  - Having to pass `null` for unused optional parameters.
- You want the created object to be:
  - **Immutable**, or at least constructed in a controlled way.
  - **Consistent**, with validation done at construction time.
- You have different ways to **configure** or **assemble** the same object.

Typical real-world examples:

- Building configuration objects (e.g., HTTP client config, database config).
- Building complex domain objects (e.g., orders, invoices, user profiles).
- Building UI components with many options.

---

### 8. Builder vs other creational patterns

- **Builder vs Factory**
  - **Factory** focuses on **selecting which implementation** of an interface to create.
  - **Builder** focuses on **how to build a single complex object step by step**.
  - Use **Factory** when you care about **which concrete class** you instantiate.
  - Use **Builder** when you care about **how to configure many fields/steps** for a single class.

- **Builder vs Abstract Factory**
  - **Abstract Factory** creates **families of related objects**.
  - **Builder** creates **one complex object**.

- **Builder vs telescoping constructors**
  - Builder provides a **fluent, readable alternative** without huge constructors.

---

### 9. Summary

- The **Builder pattern** separates **object construction** from its **representation**, allowing you to build complex objects in a **clear, step-by-step, and flexible** way.
- In this package:
  - `Phone` is the **product** being built.
  - `PhoneBuilder` is the **builder** that knows how to configure and construct `Phone`.
  - `Shop` is the **client** that uses the builder to create `Phone` instances.
- Use Builder when:
  - Your constructor parameter list is growing.
  - You have many optional parameters.
  - You want cleaner, safer, and more maintainable object creation.

