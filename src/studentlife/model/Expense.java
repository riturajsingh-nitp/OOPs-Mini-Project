package studentlife.model;

import java.time.LocalDate;
import studentlife.exception.InvalidEntryException;

public class Expense {
    private final String title;
    private final String category;
    private final double amount;
    private final LocalDate date;

    public Expense(String title, String category, double amount, LocalDate date) throws InvalidEntryException {
        if (title == null || title.isBlank()) throw new InvalidEntryException("Expense title cannot be empty.");
        if (amount <= 0) throw new InvalidEntryException("Expense amount must be positive.");
        this.title = title; this.category = category; this.amount = amount; this.date = date;
    }
    public double getAmount() { return amount; }
    @Override public String toString() { return title + " (" + category + "): ₹" + String.format("%.2f", amount); }
}
