## Java Design Patterns – Quick Reference

### Creational Patterns
- **Singleton**: Ensures a class has only one instance and provides a global point of access to it.
- **Factory Method**: Defines an interface for creating objects but lets subclasses decide which class to instantiate.
- **Abstract Factory**: Provides an interface for creating families of related objects without specifying their concrete classes.
- **Builder**: Separates the construction of a complex object from its representation so the same construction process can create different representations.
- **Prototype**: Creates new objects by cloning existing instances instead of creating from scratch.

### Structural Patterns
- **Adapter**: Converts the interface of a class into another interface clients expect so incompatible classes can work together.
- **Bridge**: Decouples an abstraction from its implementation so the two can vary independently.
- **Composite**: Composes objects into tree structures to represent part–whole hierarchies and lets clients treat individual objects and compositions uniformly.
- **Decorator**: Attaches additional responsibilities to an object dynamically without changing its class.
- **Facade**: Provides a unified, simplified interface to a set of interfaces in a subsystem.
- **Flyweight**: Uses sharing to support large numbers of fine-grained objects efficiently.
- **Proxy**: Provides a surrogate or placeholder object to control access to another object.

### Behavioral Patterns
- **Strategy**: Defines a family of interchangeable algorithms and lets the client choose the algorithm at runtime.
- **Observer**: Defines a one-to-many dependency so when one object changes state, all its dependents are notified and updated automatically.
- **Template Method**: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
- **Command**: Encapsulates a request as an object, allowing parameterization, queuing, and logging of requests.
- **State**: Allows an object to change its behavior when its internal state changes, appearing to change its class.
- **Chain of Responsibility**: Passes a request along a chain of handlers until one of them handles it.
- **Mediator**: Encapsulates how a set of objects interact by centralizing complex communications.
- **Memento**: Captures and externalizes an object’s internal state so it can be restored later without violating encapsulation.
- **Iterator**: Provides a standard way to sequentially access elements of a collection without exposing its internal representation.
- **Visitor**: Represents an operation to be performed on elements of an object structure, allowing new operations without changing the element classes.

