# Adapter Pattern in This Example

This example uses the Adapter pattern for a very common real-life problem:

- old wired earphones with a modern phone

The old earphones expect one type of connection.
The modern phone expects another.
They cannot work together directly, even though both are useful.

The Adapter pattern helps two incompatible interfaces work together.

## Classes and their roles

- `WiredEarphones`
  - This is the existing class with its own old-style method:
    - `connectTo3Point5MmJack()`

- `AudioAccessory`
  - This is the interface expected by the client in this example.

- `TypeCPortAdapter`
  - This is the adapter.
  - It wraps `WiredEarphones`.
  - It converts the expected call into the old-style call.

- `ModernPhone`
  - This is the client.
  - It only knows how to work with the target interface.

## How it works

In `Main`, we create the old object:

```java
WiredEarphones wiredEarphones = new WiredEarphones();
```

Then we wrap it inside the adapter:

```java
AudioAccessory adapter = new TypeCPortAdapter(wiredEarphones);
```

Now the phone can use the adapter:

```java
ModernPhone modernPhone = new ModernPhone(adapter);
modernPhone.useAccessory();
```

Inside the adapter:

```java
wiredEarphones.connectTo3Point5MmJack();
```

So the phone thinks it is working with the interface it expects, while the adapter translates the request to the old object.

## Why this is useful

Without Adapter, the client and the existing class remain incompatible.

With Adapter:

- old code can still be reused
- client code does not need big changes
- incompatible interfaces can cooperate

## Why this example feels practical

People use adapters all the time in daily life:

- USB-C to 3.5mm audio
- travel plug adapters
- old monitor to new laptop connectors

That is why Adapter is one of the easiest structural patterns to understand in real life.
