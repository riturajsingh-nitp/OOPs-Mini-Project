package studentlife.model;

public class Student extends Person {
    private final String course;
    private double monthlyBudget;

    public Student(String name, String email, String course, double monthlyBudget) {
        super(name, email);
        this.course = course;
        this.monthlyBudget = monthlyBudget;
    }

    @Override public String getRole() { return "Student"; }
    public String getCourse() { return course; }
    public double getMonthlyBudget() { return monthlyBudget; }
    public void setMonthlyBudget(double monthlyBudget) { this.monthlyBudget = monthlyBudget; }
}
