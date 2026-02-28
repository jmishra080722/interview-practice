## Factory Design Pattern (Simple Factory) – Payment Example

The **Factory pattern** is a **creational design pattern** that **centralizes object creation logic** in one place (a *factory*), instead of scattering `new` calls throughout the codebase.

In this package, `PaymentFactory` decides **which `Payment` implementation to create** based on the input payment method, using constants from `PaymentConstant` (instead of hard‑coded string literals).

---

## Why use a Factory?

- **Encapsulation of creation logic**  
  Object construction rules (e.g., which class to use) live in one class (`PaymentFactory`), not everywhere in your code.

- **Reduced coupling**  
  Client code (like `FactoryMainDemo`) depends only on the **interface** (`Payment`) and the **factory**, not on concrete classes (`AccountTransfer`, `CreditCardTransfer`).

- **Easier to extend**  
  To add a new payment type, you add a new class and extend the factory logic, with **no changes** needed in existing client code.

---

## Participants in this example

- **`Payment` (Product interface)**  
  Declares the operation that all concrete products must implement:
  - `void doPayment(String toAcc, long amount);`

- **`AccountTransfer` (Concrete Product)**  
  Implements `Payment` to perform an account-to-account transfer.

- **`CreditCardTransfer` (Concrete Product)**  
  Implements `Payment` to perform a credit card transfer.

- **`PaymentFactory` (Factory / Creator)**  
  Contains a method `pay(String paymentMethod)` that:
  - Receives a **parameter** (e.g., `PaymentConstant.creditCard`, `PaymentConstant.accountTransfer`)
  - Decides **which concrete class to instantiate**
  - Returns it as a `Payment` interface

- **`PaymentConstant` (Constants holder / configuration)**  
  Central place for payment method string values, to avoid magic strings:
  - `public static final String creditCard = "Credit card";`
  - `public static final String accountTransfer = "Account";`

- **`FactoryMainDemo` (Client)**  
  Requests an object from the factory and uses it **only via the `Payment` interface**, without knowing the exact implementation class.

---

## How the code works step by step

1. **Client chooses a payment method (using constants)**
   ```java
   String paymentMethod = PaymentConstant.creditCard;
   ```

2. **Client asks the factory for a `Payment` instance**
   ```java
   PaymentFactory paymentFactory = new PaymentFactory();
   Payment payment = paymentFactory.pay(paymentMethod);
   ```

3. **Factory decides which implementation to create (using `PaymentConstant`)**
   Inside `PaymentFactory`:
   ```java
   public Payment pay(String paymentMethod) throws InvalidObjectException {
       if (paymentMethod.equalsIgnoreCase(PaymentConstant.creditCard)) {
           return new CreditCardTransfer();
       } else if (paymentMethod.equalsIgnoreCase(PaymentConstant.accountTransfer)) {
           return new AccountTransfer();
       } else {
           throw new InvalidObjectException("Invalid payment option selected");
       }
   }
   ```

4. **Client calls the common interface method**
   ```java
   payment.doPayment("1234", 2000);
   ```

The client **never directly uses `new CreditCardTransfer()` or `new AccountTransfer()`**, which is the key idea of the factory.

---

## When to use the Factory pattern

Use a (simple) Factory when:

- You have **multiple implementations** of an interface or abstract class.
- The choice of which implementation to use depends on **some input** (string, enum, config, user choice, etc.).
- You want to **avoid spreading `new` calls and conditionals** (`if/else` or `switch`) across your code.
- You want to **centralize the logic** of which class to create.

---

## Benefits and trade‑offs

- **Benefits**
  - Cleaner, more maintainable client code.
  - Single place to update when adding new concrete types.
  - Clients depend on abstractions (`Payment`), not concrete classes.

- **Trade‑offs**
  - Adds an extra layer (the factory class).
  - If implemented with long `if/else` or `switch` blocks, the factory itself can grow large (can be improved later with more advanced patterns like Factory Method or Abstract Factory).

---

## Summary

- The **Factory pattern** is about **delegating object creation** to a separate component.
- In this example, `PaymentFactory` decides which `Payment` implementation (`AccountTransfer`, `CreditCardTransfer`) to provide, based on the payment method.
- Client code (`FactoryMainDemo`) only works with the `Payment` interface, making the code **flexible, extensible, and easier to maintain**.

