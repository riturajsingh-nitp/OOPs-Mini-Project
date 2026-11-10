package studentlife.app;

import java.time.LocalDate;
import studentlife.exception.InvalidEntryException;
import studentlife.model.*;
import studentlife.service.StudentLifeManager;

public class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student("Aarav Sharma", "aarav@college.edu", "BCA, Semester 4", 12000);
            StudentLifeManager manager = new StudentLifeManager(student);
            Task assignment = new AcademicTask("Finish OOP mini project", LocalDate.now().plusDays(2), "High", "Java", "Project");
            manager.addTask(assignment);
            manager.addTask(new AcademicTask("Read DBMS chapter 6", LocalDate.now().plusDays(1), "Medium", "DBMS", "Reading"));
            manager.addTask(new PersonalTask("Call home", LocalDate.now(), "Low", "Family"));
            assignment.markComplete();
            manager.addExpense(new Expense("Lunch at campus", "Food", 165, LocalDate.now()));
            manager.addExpense(new Expense("Bus pass", "Travel", 520, LocalDate.now()));
            manager.addWellnessLog(new WellnessLog(LocalDate.now(), 4, 3, "Good focus after a walk."));
            manager.printDashboard();
        } catch (InvalidEntryException error) {
            System.out.println("Could not save entry: " + error.getMessage());
        }
    }
}
