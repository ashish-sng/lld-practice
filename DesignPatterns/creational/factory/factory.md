## The problem isn't that object creation is difficult.

The problem is:

## Your business code now knows exactly which concrete classes to create.

Everywhere you need a notification, you might repeat this logic.

## Factory says: Move object-creation logic into one dedicated place.

Start with an interface, then have concrete implementations classes, and finally a factory class that creates the objects.

## Basically we move the object creation logic out of the client code and put it into a class that we call the Factory.

Factory Pattern encapsulates object creation. Instead of the client directly creating concrete implementations using conditionals and new, it delegates creation to a Factory. The client works with the common abstraction, which reduces coupling and centralizes creation logic.