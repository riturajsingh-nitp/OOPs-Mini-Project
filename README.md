# StudentLife — The Personal College Survival Manager

A Java OOP mini project that helps a student keep academic tasks, expenses, and wellbeing notes in one place. It contains a runnable console program and a polished static UI prototype.

## Project structure

```text
StudentLife/
├── src/studentlife/
│   ├── app/Main.java
│   ├── exception/InvalidEntryException.java
│   ├── model/Person.java
│   ├── model/Student.java
│   ├── model/Trackable.java
│   ├── model/Task.java
│   ├── model/AcademicTask.java
│   ├── model/PersonalTask.java
│   ├── model/Expense.java
│   ├── model/WellnessLog.java
│   └── service/StudentLifeManager.java
├── web/
│   ├── index.html
│   ├── styles.css
│   └── app.js
└── REPORT.md
```

## Run the Java console app

From this folder in PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out studentlife.app.Main
```

Requirements: JDK 17 or newer. The console app seeds sample data and demonstrates tasks, budget tracking, wellness logging, polymorphism, and exception handling.

## View the UI prototype

Open `web/index.html` in a browser. It has no framework or server dependency. You can add tasks, toggle completion, filter the schedule, and update the budget client-side.

## Practical Java-to-web integration

The HTML files are deliberately static so they run immediately. To connect them to Java without a heavyweight framework, add a small HTTP server using JDK's `com.sun.net.httpserver.HttpServer` (or use Spring Boot if your course covers it):

1. expose `GET /api/dashboard`, `GET/POST /api/tasks`, and `GET/POST /api/expenses`;
2. serialize the existing model objects as JSON;
3. replace the sample arrays in `web/app.js` with `fetch('/api/tasks')` and send form data with `fetch(..., { method: 'POST' })`;
4. persist later with a file or database when needed.

This keeps the domain model and business rules in Java while the browser only displays and collects data.
# OOPs-Mini-Project
