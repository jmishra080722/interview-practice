## Adapter Design Pattern (Structural)

The **Adapter** pattern is a structural design pattern that allows objects with incompatible interfaces to work together.  
It acts as a **wrapper** around an existing (usually third‑party or legacy) class, translating one interface into another that the client expects.

In this module, we adapt a third‑party `PilotPen` class so that it can be used wherever our code expects a `Pen` interface.

---

## 1. Problem Statement

Assume you already have client code that works with a `Pen` abstraction:

- The client knows about a `Pen` interface with a `write(String)` method.
- A new third‑party library provides a powerful `PilotPen` class.
- `PilotPen` has a method named `mark(String)`, not `write(String)`.

You **cannot** (or should not):

- Change the client code to depend on `PilotPen` directly.
- Modify the third‑party `PilotPen` source (you usually don't own it).

**Goal:** Use `PilotPen` wherever `Pen` is expected, **without** changing client code or the third‑party class.

---

## 2. Key Participants (Roles)

- **Target** – the interface the client expects.
  - Here: `Pen` (our own interface).

- **Adaptee** – the existing / third‑party class with an incompatible interface.
  - Here: `PilotPen` (from `third_party_library`).

- **Adapter** – a class that implements the Target interface and internally uses the Adaptee, translating calls.
  - Here: `PilotPenAdapter` implements `Pen` and delegates to `PilotPen`.

- **Client** – the code that uses the Target interface, unaware of the Adaptee.
  - Here: `Assignment` and `School`.

---

## 3. Class Overview in This Package

- `Pen` – Target interface that the rest of the application depends on.
- `third_party_library.PilotPen` – Adaptee, a third‑party class we cannot change.
- `PilotPenAdapter` – Adapter that implements `Pen` and internally uses `PilotPen`.
- `Assignment` – Client class that uses a `Pen` to write an assignment.
- `School` – Contains the `main` method, wires everything together and demonstrates the pattern.

---

## 4. How the Adapter Works Here

### Target – `Pen`

`Pen` defines the interface the client expects:

```java
public interface Pen {
    void write(String str);
}
```

### Adaptee – `PilotPen`

The third‑party class has a different method name:

```java
public class PilotPen {

    public void mark(String str){
        System.out.println(str);
    }
}
```

### Adapter – `PilotPenAdapter`

`PilotPenAdapter` implements `Pen` and delegates the call to a `PilotPen` instance, translating `write()` to `mark()`:

```java
public class PilotPenAdapter implements Pen {

    private final PilotPen pilotPen;

    public PilotPenAdapter(PilotPen pilotPen) {
        this.pilotPen = pilotPen;
    }

    @Override
    public void write(String str) {
        pilotPen.mark(str);   // translation: write -> mark
    }
}
```

> Note: In this project, the adapter is named `PilotPenAdapter` to make it clear which Adaptee it is adapting.

### Client – `Assignment`

The client depends only on the `Pen` interface:

```java
public class Assignment {

    private Pen p;

    public Pen getP() {
        return p;
    }

    public void setP(Pen p) {
        this.p = p;
    }

    public void writeAssignment(String str){
        p.write(str);
    }
}
```

### Client Setup – `School`

In `School.main`, we inject the adapter into the client:

```java
public class School {
    public static void main(String[] args) {

        PilotPen pilotPen = new PilotPen();          // Adaptee instance
        Pen pen = new PilotPenAdapter(pilotPen);     // Adapter, seen as Pen

        Assignment as = new Assignment();
        as.setP(pen);                                // Client sees only Pen
        as.writeAssignment("Complete this work during vacation.... ");
    }
}
```

The client (`Assignment`) remains unaware of `PilotPen`. It just calls `p.write(...)`, and the adapter translates it into `pilotPen.mark(...)`.

---

## 5. When to Use Adapter Pattern

Use the Adapter pattern when:

- **You want to use an existing class**, but its interface does not match what your code expects.
- **You cannot modify** the existing class (e.g., it comes from a third‑party library or from legacy code).
- **You want to follow an existing abstraction** (like `Pen`) and plug multiple implementations underneath it.
- You need to **bridge between two incompatible APIs** in a clean and testable way.

### Typical Real‑World Examples

- Adapting different logging libraries to a common `Logger` interface.
- Adapting `Enumeration` to `Iterator` or vice versa.
- Using various payment gateways under a common `PaymentProcessor` abstraction.

---

## 6. Static Class vs. Object Adapter

There are two common styles of the Adapter pattern:

- **Class Adapter (inheritance‑based)** – Adapter inherits from Adaptee and implements Target.  
  - Not possible in Java when Adaptee is a `final` class or you already extend another class.
  - Rarely used in Java due to single inheritance.

- **Object Adapter (composition‑based)** – Adapter has a reference to Adaptee (field) and implements Target.  
  - This is what we use here with `PilotPenAdapter`.
  - More flexible and recommended in Java.

Our implementation is an **object adapter**: `PilotPenAdapter` holds a `PilotPen` instance and forwards calls to it.

---

## 7. Benefits and Trade‑offs

### Benefits

- **Reusability**: Reuse existing (third‑party or legacy) classes without changing them.
- **Loose Coupling**: Clients depend on the Target interface, not on concrete Adaptees.
- **Single Responsibility**: Translating between interfaces is isolated in the Adapter.
- **Open/Closed Principle**: You can add new adapters for new libraries without changing client code.

### Trade‑offs / Considerations

- **Extra Indirection**: Adds one more level of abstraction and a thin wrapper class.
- **Proliferation of Adapters**: Many external systems may require many adapter classes.
- **Not a Silver Bullet**: If you can change the client and the adaptee freely, a direct refactor might be simpler.

---

## 8. How to Recognize Adapter in Code

Typical signs you are looking at an Adapter:

- A class implements some interface (`Target`) but internally holds another object (`Adaptee`) and forwards calls to it.
- Method names are often **translated**:
  - e.g. `write()` → `mark()`, `log()` → `print()`, `run()` → `execute()`.
- The client code works only with the Target interface and is unaware of the actual concrete implementation underneath.

In this package:

- `Assignment` and `School` are completely unaware of `PilotPen`.
- Only `PilotPenAdapter` knows how to talk to `PilotPen`.

---

## 9. Summary

- The **Adapter** pattern lets you plug in **incompatible types** without modifying existing client code or third‑party libraries.
- In this example:
  - `Pen` is the Target.
  - `PilotPen` is the Adaptee.
  - `PilotPenAdapter` is the Adapter.
  - `Assignment`/`School` are Clients.
- This is a clean, idiomatic Java example of the **object adapter** variant of the Adapter design pattern.

