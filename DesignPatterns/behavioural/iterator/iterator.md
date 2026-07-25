# Iterator Pattern in This Example

This example uses the Iterator pattern to walk through a person's weekend plan without exposing how the activities are stored internally.

## Classes and their roles

- `Activity`
  - A single item in the collection.
  - It stores the activity title, time slot, and whether it is cancelled.

- `WeekendPlan`
  - This is the collection object.
  - It keeps all activities inside a `List<Activity>`.
  - It does not expose that list directly.
  - Instead, it gives an iterator through `createIterator()`.

- `ActivityIterator`
  - This is the iterator interface.
  - It defines two operations:
    - `hasNext()` checks if there is another valid activity.
    - `next()` returns the next activity.

- `WeekendPlanIterator`
  - This is the concrete iterator.
  - It knows how to move through the `activities` list using the `index` field.

## How iteration is working step by step

When `Main` runs, it creates a `WeekendPlan` and adds four activities.

One of them is:

- `Dentist appointment`, marked as `cancelled = true`

Then this line creates the iterator:

```java
ActivityIterator iterator = weekendPlan.createIterator();
```

That returns a new `WeekendPlanIterator` with:

- the full list of activities
- `index = 0`

## What `hasNext()` is doing

The key logic is here:

```java
while (index < activities.size() && activities.get(index).isCancelled()) {
    index++;
}
return index < activities.size();
```

This means:

1. Check the current activity.
2. If it is cancelled, move `index` forward.
3. Keep skipping until a non-cancelled activity is found.
4. Return `true` only if a valid activity still exists.

So in this example, the cancelled dentist appointment is never printed.

## What `next()` is doing

```java
if (!hasNext()) {
    return null;
}
return activities.get(index++);
```

This means:

1. First make sure there is a valid next activity.
2. Return the activity at the current position.
3. Move the cursor forward for the next call.

## Flow in `Main`

`Main` uses:

```java
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

That loop keeps asking the iterator for the next valid activity until the plan ends.

## Why this is useful

The important idea is that `Main` does not care:

- whether data is stored in an array, list, queue, or something else
- how cancelled activities are skipped
- how the current position is tracked

All of that logic lives inside the iterator.

So the Iterator pattern gives:

- clean traversal logic
- separation between collection and navigation
- flexibility to change traversal rules later

In this example, a simple real-life rule was added:

- "skip cancelled weekend plans automatically"

That is what makes the iterator useful here instead of being just a basic loop.
