package studentlife.model;

import java.time.LocalDate;
import studentlife.exception.InvalidEntryException;

public class PersonalTask extends Task {
    private final String area;

    public PersonalTask(String title, LocalDate dueDate, String priority, String area)
            throws InvalidEntryException {
        super(title, dueDate, priority);
        this.area = area;
    }
    @Override public String getCategory() { return "Personal"; }
    @Override public String getDetails() { return area; }
}
