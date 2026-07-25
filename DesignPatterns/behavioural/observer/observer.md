# Observer Pattern in This Example

This example uses the Observer pattern to model something relatable:

- a shared laundry machine in a hostel or apartment
- multiple roommates who want updates about the same machine

Instead of each roommate repeatedly checking the machine, the machine sends updates whenever its status changes.

## Classes and their roles

- `Subject`
  - This is the publisher side of the pattern.
  - It defines:
    - `addObserver()`
    - `removeObserver()`
    - `notifyObservers()`

- `Observer`
  - This is the subscriber side of the pattern.
  - It defines one method:
    - `update(String machineId, String statusMessage)`

- `LaundryMachine`
  - This is the concrete subject.
  - It stores:
    - the machine id
    - the current status message
    - the list of observers
  - When its status changes, it notifies all registered observers.

- `Roommate`
  - This is the concrete observer.
  - Each roommate receives updates and reacts by printing the message.

## How it works step by step

In `Main`, we create one laundry machine:

```java
LaundryMachine laundryMachine = new LaundryMachine("Laundry Machine 2");
```

Then we create three observers:

```java
Observer aarav = new Roommate("Aarav");
Observer meera = new Roommate("Meera");
Observer kabir = new Roommate("Kabir");
```

These observers subscribe to the laundry machine:

```java
laundryMachine.addObserver(aarav);
laundryMachine.addObserver(meera);
laundryMachine.addObserver(kabir);
```

At this point, the machine has a list of people to notify.

## What happens when status changes

Whenever this method is called:

```java
laundryMachine.setStatus("Wash cycle started");
```

the following happens inside `LaundryMachine`:

1. The new status is stored in `statusMessage`.
2. `notifyObservers()` is called.
3. The machine loops through every registered observer.
4. Each observer receives the same update.

That logic is here:

```java
for (Observer observer : observers) {
    observer.update(machineId, statusMessage);
}
```

So the subject does not need to know what each observer does with the update.
It only knows that every observer supports `update(...)`.

## What `Roommate` does with the update

Each roommate implements:

```java
public void update(String machineId, String statusMessage) {
    System.out.println(name + " got update from " + machineId + ": " + statusMessage);
}
```

So every observer can react in its own way.
In this example, the reaction is simple printing, but in a real app it could be:

- sending a push notification
- showing a UI alert
- updating a dashboard

## What unsubscribe means here

This line removes Kabir from the observer list:

```java
laundryMachine.removeObserver(kabir);
```

After that, when the machine sends:

```java
laundryMachine.setStatus("Cycle complete, please collect your clothes");
```

only Aarav and Meera receive the update.
Kabir no longer gets notified because he is no longer subscribed.

## Why this pattern is useful

The main idea is that the laundry machine and roommates are loosely coupled.

The machine does not need to know:

- how many roommates exist
- who they are in detail
- what they do after receiving updates

It only knows:

- "I have a list of observers"
- "when my state changes, I notify them"

That gives us:

- cleaner communication
- easy subscription and unsubscription
- flexibility to add new observer types later

## Why this example feels practical

This is a human-centered use case because people really do wait for shared resources like:

- washing machines
- water tankers
- food deliveries
- society maintenance visits

The Observer pattern fits naturally when:

- one thing changes state
- many people care about that change
- they should be informed automatically

That is exactly what is happening in this laundry machine example.
