## Abstract Factory Design Pattern – In Depth (Java)

### 1. What is the Abstract Factory pattern?

- **Definition**: Abstract Factory is a **creational design pattern** that provides an **interface for creating families of related objects** (products) **without specifying their concrete classes**.
- **Intent**: Group together and encapsulate the creation of **related objects that must be used together**, so the client can switch entire families (variants) of products in one place.

In this package, the Abstract Factory pattern is used to create **`Shape`** and **`Color`** objects in a consistent way, depending on which factory you obtain from `FactoryProducer`.

---

### 2. Key participants in this example

- **`AbstractFactory` (Abstract Factory)**
  - Declares methods for creating families of products:
    - `Shape getShape(String shapeType);`
    - `Color getColor(String colorType);`
  - Concrete factories will implement one or both of these methods depending on what they produce.

- **`ShapeFactory` (Concrete Factory)**
  - Creates **shape-related products** (e.g., `Rectangle`, `Square`, `Circle` in the `shape` package).
  - Implements `getShape(...)` and usually returns `null` or no-op for `getColor(...)`.

- **`ColorFactory` (Concrete Factory)**
  - Creates **color-related products** (e.g., `Red`, `Green`, `Blue` in the `color` package).
  - Implements `getColor(...)` and usually returns `null` or no-op for `getShape(...)`.

- **`Shape` and `Color` (Product interfaces)**
  - `Shape` defines operations for geometric shapes (for example, `draw()`).
  - `Color` defines operations for colors (for example, `fill()`).
  - Concrete classes such as `Red`, `Blue`, `Green`, and individual shapes implement these interfaces.

- **`FactoryProducer` (Factory of factories / Abstract Factory provider)**
  - Returns the right concrete factory depending on a **high-level choice**:
    - e.g., if you ask for `"SHAPE"`, it returns a `ShapeFactory`.
    - if you ask for `"COLOR"`, it returns a `ColorFactory`.
  - This is sometimes called a **“factory of factories”**.

- **`AbstractFactoryDemo` (Client)**
  - Uses `FactoryProducer` to get the appropriate factory.
  - Uses the factory to obtain `Shape` or `Color` instances, and calls their methods **without knowing their concrete types**.

---

### 3. How the Abstract Factory works (conceptually)

1. **Client decides which family of products it needs**  
   For example, you may want to work with *shapes* or *colors*.

2. **Client asks `FactoryProducer` for a factory for that family**  
   - For shapes: `AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");`
   - For colors: `AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");`

3. **Client uses the returned factory to create products**  
   - From `shapeFactory`, call `getShape("CIRCLE")`, `getShape("RECTANGLE")`, etc.
   - From `colorFactory`, call `getColor("RED")`, `getColor("BLUE")`, etc.

4. **Client uses products only via interfaces (`Shape`, `Color`)**  
   The client is **decoupled** from the concrete product classes; it only depends on:
   - The **abstract factory interface** (`AbstractFactory`)
   - The **product interfaces** (`Shape`, `Color`)

5. **Switching entire families becomes easy**  
   By changing which factory you get from `FactoryProducer`, you can switch to a different family/variant of products (for example, a “3D shapes” factory vs. “2D shapes” factory, or “light theme” vs. “dark theme” widgets).

---

### 4. Why use Abstract Factory?

- **Consistent families of related objects**  
  Ensures that **only compatible products are used together**. For example, shapes and colors coming from the same “theme” or “variant”.

- **Centralized creation logic for product families**  
  All the rules for constructing related objects are grouped inside factories instead of being spread across client code.

- **Better separation of concerns & decoupling**  
  Clients do not know about concrete classes (`Red`, `Blue`, `Square`, etc.), only about interfaces (`Color`, `Shape`) and factories.

- **Easy to swap entire product families**  
  You can introduce a new factory (e.g., `ModernUIFactory`, `ClassicUIFactory`, or `DarkThemeFactory`) without changing client code. Clients only switch which factory they ask for.

- **Open/Closed Principle**  
  You can **add new product families (new factories) without modifying existing client code**, only extending the codebase.

---

### 5. Factory vs Abstract Factory – What is the difference?

Both patterns are **creational** and **encapsulate object creation**, but they are used at different levels of complexity.

- **Factory (Simple Factory)**
  - **Purpose**: Encapsulate the creation of **one kind of product** (one product hierarchy).
  - **Example in this project**: `PaymentFactory` in the `factory` package creates different implementations of `Payment` (`CreditCardTransfer`, `AccountTransfer`) based on input.
  - **Client viewpoint**:
    - Asks the factory for **one product**: e.g., `Payment payment = paymentFactory.pay("CREDIT_CARD");`
    - The decision is **which concrete implementation** of a single interface to use.

- **Abstract Factory**
  - **Purpose**: Encapsulate creation of **multiple related products** (multiple product hierarchies) that are meant to be used together.
  - **Example in this project**: `AbstractFactory` + `ShapeFactory` + `ColorFactory`:
    - `ShapeFactory` creates `Shape` objects.
    - `ColorFactory` creates `Color` objects.
  - **Client viewpoint**:
    - First chooses a **factory** (a family), e.g., `ShapeFactory` or `ColorFactory`.
    - Then uses that factory to get related products, like different shapes or different colors.

---

### 6. When to use Factory vs Abstract Factory

#### Use **Factory (Simple Factory)** when:

- You have **one main product interface** and several concrete implementations.
- The choice of implementation depends on some parameter (string, enum, config, user input).
- You want to avoid having `new` + `if/else` or `switch` logic spread across your code.
- Example (from this project):
  - `PaymentFactory` decides whether to create `AccountTransfer` or `CreditCardTransfer` based on `PaymentConstant`.

#### Use **Abstract Factory** when:

- You have **multiple related product types** that should be created together as a group (family).
  - Example: `Shape` + `Color`, or `Button` + `Checkbox` + `TextField` for a UI toolkit.
- You want to **ensure compatibility** between the products you use (e.g., all from the same “theme” or “variant”).
- You may need to **switch entire product families** at once:
  - e.g., switch from “Windows UI” widgets to “Mac UI” widgets, or from “light theme” to “dark theme”.
- You want client code to be **independent from the concrete classes** of all these products.

---

### 7. Quick summary

- **Factory pattern**:
  - Focuses on creating **one type of product** (one interface hierarchy).
  - Centralizes object creation to avoid scattered `new` + conditionals.
  - Example: `PaymentFactory` → returns different `Payment` implementations.

- **Abstract Factory pattern**:
  - Focuses on creating **families of related products** (multiple interface hierarchies) that should be used together.
  - Provides an **interface for creating related objects** without specifying their concrete classes.
  - Example: `AbstractFactory`, `ShapeFactory`, `ColorFactory`, and `FactoryProducer` → together allow you to create consistent combinations of `Shape` and `Color`.

Use **Factory** when you just need to decide *which single implementation* of an interface to create.  
Use **Abstract Factory** when you need to create **coherent sets of related objects** and be able to **swap entire families** easily.

