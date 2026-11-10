package studentlife.service;

import java.util.ArrayList;
import java.util.List;
import studentlife.model.Expense;
import studentlife.model.Student;
import studentlife.model.Task;
import studentlife.model.WellnessLog;

public class StudentLifeManager {
    private final Student student;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Expense> expenses = new ArrayList<>();
    private final List<WellnessLog> wellnessLogs = new ArrayList<>();
    public StudentLifeManager(Student student) { this.student = student; }
    public void addTask(Task task) { tasks.add(task); }
    public void addExpense(Expense expense) { expenses.add(expense); }
    public void addWellnessLog(WellnessLog log) { wellnessLogs.add(log); }
    public List<Task> getTasks() { return List.copyOf(tasks); }
    public double getTotalSpent() { return expenses.stream().mapToDouble(Expense::getAmount).sum(); }
    public double getRemainingBudget() { return student.getMonthlyBudget() - getTotalSpent(); }
    public long getOpenTaskCount() { return tasks.stream().filter(task -> !task.isComplete()).count(); }
    public void printDashboard() {
        System.out.println("\nSTUDENTLIFE DASHBOARD — " + student.getName());
        System.out.println(student.getCourse() + " | " + getOpenTaskCount() + " open tasks");
        System.out.printf("Budget remaining: ₹%.2f of ₹%.2f%n", getRemainingBudget(), student.getMonthlyBudget());
        System.out.println("\nTasks:");
        tasks.forEach(System.out::println); // polymorphic Task rendering
        System.out.println("\nExpenses:");
        expenses.forEach(System.out::println);
        System.out.println("\nLatest wellness logs:");
        wellnessLogs.forEach(System.out::println);
    }
}
