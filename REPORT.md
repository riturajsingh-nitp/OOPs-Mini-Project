# StudentLife — Project Report

## Aim

To build a personal college survival manager that lets students organise their study tasks, everyday spending, and wellbeing check-ins.

## Objectives

- Record and prioritise academic and personal tasks.
- Track expenses against a monthly budget.
- Log a daily mood and energy check-in.
- Demonstrate fundamental Java OOP concepts in a realistic mini project.
- Present the same product as a usable HTML/CSS interface.

## Modules

| Module | Purpose |
| --- | --- |
| Profile | Stores the student's identity and course. |
| Task planner | Creates, lists, prioritises, and completes tasks. |
| Budget | Records expenses and calculates the remaining budget. |
| Wellness | Saves simple daily mood and energy entries. |
| Dashboard | Produces a combined summary for the console/UI. |

## OOP concepts demonstrated

| Concept | Where it appears |
| --- | --- |
| Encapsulation | Private fields with validated constructors and getters/setters. |
| Inheritance | `Student` extends abstract `Person`; task types extend abstract `Task`. |
| Abstraction | `Person` and `Task` hold shared behaviour while hiding implementation details. |
| Polymorphism | `List<Task>` renders both `AcademicTask` and `PersonalTask` through overridden methods. |
| Interface | `Trackable` provides the shared completion contract. |
| Collections | `ArrayList` stores tasks, expenses, and wellness logs. |
| Exception handling | `InvalidEntryException` protects invalid user/domain entries. |

## Learning outcomes

After completing this project, a learner should be able to model a small real-world problem with Java classes, reuse behaviour using inheritance and interfaces, safely manage collections, validate data with custom exceptions, and separate a frontend prototype from a Java domain layer.
