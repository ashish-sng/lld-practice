# Strategy Pattern in This Example

This example uses the Strategy pattern for something very human and relatable:

- how a student studies in the evening

People do not always study in the same way. Sometimes they revise notes, sometimes they solve questions, and sometimes they explain the topic aloud to test understanding. The topic may stay the same, but the approach can change.

That changing approach is the strategy.

## Classes and their roles

- `StudyStrategy`
  - This is the strategy interface.
  - It defines one common method:
    - `study(String topic)`

- `RevisionStrategy`
  - Used when the student wants to quickly refresh concepts.

- `PracticeQuestionsStrategy`
  - Used when the student wants active problem solving.

- `TeachBackStrategy`
  - Used when the student wants to explain the topic aloud and check true understanding.

- `EveningStudySession`
  - This is the context class.
  - It does not contain the study logic itself.
  - It only stores a reference to a `StudyStrategy` and delegates the work.

## How it works step by step

In `Main`, we create the context with one default strategy:

```java
EveningStudySession studySession = new EveningStudySession(new RevisionStrategy());
```

This means the study session currently knows:

- what topic to work on
- which study behavior to use

When this runs:

```java
studySession.startSession("Operating Systems");
```

the context does not decide how to study on its own.
Instead it forwards the action to the selected strategy:

```java
studyStrategy.study(topic);
```

## How behavior changes without changing the context

Later in `Main`, the strategy is replaced:

```java
studySession.setStudyStrategy(new PracticeQuestionsStrategy());
studySession.startSession("Dynamic Programming");
```

Now the same `EveningStudySession` object behaves differently.

Then it changes again:

```java
studySession.setStudyStrategy(new TeachBackStrategy());
studySession.startSession("Computer Networks");
```

So the context remains the same, but the behavior changes at runtime.

## Why this is Strategy

The key idea is:

- the algorithm or behavior is not hardcoded inside the context
- it is kept in separate interchangeable classes

In this example, the interchangeable behaviors are:

- revising
- solving practice questions
- teaching back the topic

All of them follow the same interface, so `EveningStudySession` can use any of them without caring about the details.

## Why this is useful

Without Strategy, `EveningStudySession` might have a lot of `if-else` logic like:

- if low energy, revise
- if exam tomorrow, solve questions
- if confused, teach back

That becomes harder to maintain as more study methods are added.

With Strategy:

- each study method has its own class
- new strategies can be added without changing existing behavior much
- the context stays simple

## Why this example feels practical

This is not a machine-only problem.
Humans often change their approach based on mood, time, confidence, or urgency.

A student may think:

- "I am tired, let me revise notes"
- "I need speed, let me solve questions"
- "I want confidence, let me explain it aloud"

That is exactly the kind of real-life behavior the Strategy pattern models well:

- same goal
- different ways to achieve it
- easy switching between approaches
