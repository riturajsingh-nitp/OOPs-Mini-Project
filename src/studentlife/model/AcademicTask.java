package studentlife.model;

import java.time.LocalDate;
import studentlife.exception.InvalidEntryException;

public class AcademicTask extends Task {
    private final String subject;
    private final String type;

    public AcademicTask(String title, LocalDate dueDate, String priority, String subject, String type)
            throws InvalidEntryException {
        super(title, dueDate, priority);
        this.subject = subject;
        this.type = type;
    }
    @Override public String getCategory() { return "Academic"; }
    @Override public String getDetails() { return subject + " — " + type; }
}
