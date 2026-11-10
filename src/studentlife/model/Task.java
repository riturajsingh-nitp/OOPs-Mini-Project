package studentlife.model;

import java.time.LocalDate;
import studentlife.exception.InvalidEntryException;

public abstract class Task implements Trackable {
    private final String title;
    private final LocalDate dueDate;
    private final String priority;
    private boolean complete;

    protected Task(String title, LocalDate dueDate, String priority) throws InvalidEntryException {
        if (title == null || title.isBlank()) throw new InvalidEntryException("Task title cannot be empty.");
        if (dueDate == null) throw new InvalidEntryException("A due date is required.");
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority == null ? "Medium" : priority;
    }

    public String getTitle() { return title; }
    public LocalDate getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
    @Override public void markComplete() { complete = true; }
    @Override public boolean isComplete() { return complete; }
    @Override public String getStatus() { return complete ? "Done" : "Open"; }
    public abstract String getCategory();
    public abstract String getDetails();

    @Override public String toString() {
        return "[" + getStatus() + "] " + title + " | " + getCategory() + " | " + dueDate
                + " | " + priority + " | " + getDetails();
    }
}
