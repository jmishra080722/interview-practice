## Bridge Design Pattern (Structural) – In Depth (Java)

The **Bridge** pattern is a structural design pattern that **decouples an abstraction from its implementation**, so that **both can vary independently**.

In simple terms:

- You have **two dimensions of change** (two “axes”):
  - **What** the object is (the *abstraction* / high-level API your client uses)
  - **How** it is done (the *implementation* / low-level detail)
- Instead of using inheritance to combine those dimensions (which quickly explodes into many classes), Bridge uses **composition**:
  - The abstraction **has a reference** to an implementation interface.
  - The abstraction delegates the work to that implementation.

This package demonstrates Bridge using:

- `Shape` / `Circle` as the **abstraction hierarchy**
- `DrawAPI` / (`RedCircle`, `GreenCircle`) as the **implementation hierarchy**

---

## 1. Problem Statement (Motivation)

Imagine you are building a drawing system.

You have multiple **shapes**:

- Circle
- Rectangle
- Triangle

And you have multiple **ways to render** them:

- Red
- Green
- Blue
- Raster renderer vs Vector renderer
- OpenGL vs DirectX

### The inheritance trap (class explosion)

If you try to solve this by inheritance alone, you start creating classes like:

- `RedCircle`, `GreenCircle`, `BlueCircle`
- `RedRectangle`, `GreenRectangle`, `BlueRectangle`
- ...

If you have:

- $N$ shapes
- $M$ rendering implementations

Then inheritance pushes you toward **$N \times M$ concrete classes**.

This becomes hard to:

- Maintain (too many classes)
- Extend (adding a new renderer forces changes across many shape variants)
- Reuse (renderers get duplicated across shape subclasses)

**Goal:** Allow adding new shapes and new rendering strategies **without multiplying classes** and without changing existing client code.

---

## 2. Intent of Bridge

Bridge solves the above by separating:

- **Abstraction**: the public API used by clients (e.g., `Shape`)
- **Implementation**: the low-level operations that do the real work (e.g., `DrawAPI`)

The abstraction holds a reference to the implementation:

- `Shape` **has a** `DrawAPI`
- Concrete shapes (`Circle`) call methods on `DrawAPI` to do the actual drawing

This is the “bridge”: a **reference** that connects the two hierarchies.

---

## 3. Key Participants (Roles)

Bridge typically has these roles:

- **Abstraction**
  - Defines the high-level API used by the client.
  - Keeps a reference to an Implementor.
- **Refined Abstraction**
  - Extends the Abstraction.
  - Adds more behavior or specialized variants.
- **Implementor**
  - Defines the interface for implementation classes.
  - This interface is usually more low-level and focused.
- **Concrete Implementor**
  - Implements the Implementor interface.
  - Provides the actual low-level behavior.
- **Client**
  - Works only with the abstraction.
  - Can choose (or be configured with) a concrete implementor at runtime.

---

## 4. Mapping to Classes in This Package

Here’s how those roles map to your code:

- **Abstraction**: `Shape`
  - Holds a `DrawAPI` reference.
  - Exposes `draw()` as the abstraction-level operation.

- **Refined Abstraction**: `Circle`
  - Stores circle data (`x`, `y`, `radius`).
  - Implements `draw()` by delegating to `DrawAPI`.

- **Implementor**: `DrawAPI`
  - Declares the low-level drawing operation(s) needed by shapes.
  - Here: `drawCircle(int radius, int x, int y)`.

- **Concrete Implementors**: `RedCircle`, `GreenCircle`
  - Implement `DrawAPI`.
  - Provide the “how” (in this demo: printing with color).

- **Client**: `BridgePatternDemo`
  - Creates a `Circle` (abstraction) and supplies a `DrawAPI` (implementation).
  - Calls `draw()` on `Shape` without needing to know the implementation details.

---

## 5. How the Bridge Works (Step by Step)

### Step 1: Define the Implementor interface – `DrawAPI`

The implementor provides the primitive operations that concrete implementors will perform.

In this example, the implementor knows how to “draw a circle”.

### Step 2: Define the Abstraction – `Shape`

The abstraction:

- Defines the client-facing operation (`draw()`).
- Stores a reference to the implementor (`DrawAPI drawAPI`).

### Step 3: Create Refined Abstractions – `Circle`

`Circle` is a *shape* (abstraction side), but it does not decide *how* to draw.

Instead it delegates:

- `Circle.draw()` calls `drawAPI.drawCircle(radius, x, y)`

This means:

- The **shape hierarchy** can grow (Circle, Rectangle, etc.)
- The **drawing implementation hierarchy** can grow (Red, Green, Vector, Raster, etc.)
- They can evolve independently.

### Step 4: Choose implementation at runtime – `BridgePatternDemo`

In `main`, you can mix and match at runtime:

- A `Circle` with a `RedCircle` implementor
- A `Circle` with a `GreenCircle` implementor

That runtime wiring is the bridge in action.

---

## 6. Why Bridge is NOT the Same as Adapter

These two are commonly confused:

- **Adapter**: makes **existing incompatible interfaces** work together (usually retrofitting).
  - Often introduced *after* you discover a mismatch.

- **Bridge**: is designed **up-front** to separate abstraction from implementation so both can change independently.
  - It prevents class explosion and avoids tight coupling as the system grows.

In short:

- Adapter is about **compatibility**
- Bridge is about **independent extensibility**

---

## 7. When to Use Bridge

Use Bridge when:

- You have **two (or more) dimensions of change** and you don’t want subclass explosion.
- You want to **switch implementations at runtime** (different backends / renderers / platforms).
- You want to keep **high-level policies** separate from **low-level details**.

### Common real-world examples

- UI controls (abstraction) vs platform rendering (implementation): Windows/Linux/Mac
- Remote controls (abstraction) vs devices (implementation): TV/Radio/Speaker
- Storage API (abstraction) vs provider (implementation): local disk / S3 / Azure Blob

---

## 8. Benefits and Trade-offs

### Benefits

- **Avoids class explosion**: $N$ abstractions + $M$ implementations instead of $N \times M$ combinations.
- **Open/Closed Principle**:
  - Add new `Shape` types without changing `DrawAPI` implementations.
  - Add new `DrawAPI` implementations without changing `Shape` hierarchy.
- **Runtime flexibility**: swap implementors without changing abstraction code.
- **Better separation of concerns**: high-level logic stays clean and testable.

### Trade-offs / Considerations

- **More classes/indirection**: introduces an extra layer (an interface + composition).
- **Design effort up front**: you must identify the right abstraction/implementation split.
- **Overkill for small systems**: if you only have one implementation, Bridge may be unnecessary.

---

## 9. Quick Mental Model (How to Recognize Bridge)

You’re likely looking at Bridge when you see:

- An abstract class (or interface) that holds a field of another interface type.
- Concrete subclasses that delegate to that interface.
- Two separate hierarchies that can be mixed and matched.

In this package:

- `Shape` → abstraction hierarchy
- `DrawAPI` → implementation hierarchy
- `Circle` delegates drawing to `DrawAPI`

---

## 10. Summary

- **Bridge** separates **what you do** (abstraction) from **how you do it** (implementation).
- It prevents subclass explosion when you have multiple dimensions of variation.
- In this package:
  - Abstraction: `Shape` / `Circle`
  - Implementation: `DrawAPI` / (`RedCircle`, `GreenCircle`)
  - Client wires them together at runtime: `BridgePatternDemo`

