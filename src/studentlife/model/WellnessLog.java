package studentlife.model;

import java.time.LocalDate;

public class WellnessLog {
    private final LocalDate date;
    private final int mood;
    private final int energy;
    private final String note;
    public WellnessLog(LocalDate date, int mood, int energy, String note) {
        this.date = date; this.mood = mood; this.energy = energy; this.note = note;
    }
    @Override public String toString() { return date + " | mood " + mood + "/5 | energy " + energy + "/5 | " + note; }
}
