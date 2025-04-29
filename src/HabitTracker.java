import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HabitTracker {
    private List<Habit> habits;

    // Constructor
    // Initializes the habit tracker with an empty list of habits
    public HabitTracker() {
        this.habits = new ArrayList<>();
    }

    // Adds a new habit to the tracker
    public void addHabit(Habit habit) {
        this.habits.add(habit);
    }

    public void markHabitIsDone(String name, LocalDate date) {
        // Finds the habit by name and marks it as done for the given date
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(name)) {
                habit.markAsDone(date);
                System.out.println("Zaznaczono nawyk jako wykonany: " + name + " w dniu: " + date);
                return;
            }
        }
        System.out.println("Nie znaleziono nawyku o nazwie: " + name);
    }

    public void showHabits() {
        if (habits.isEmpty()) {
            System.out.println("Brak nawyków w trackerze.");
        } else {
            System.out.println("Lista nawyków:");
            for (Habit habit : habits) {
                System.out.println("- " + habit.getName());
            }
        }
    }

    public void showHabitHistory(String name) {
        // Finds the habit by name and displays its details
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(name)) {
                System.out.println("Szczegóły nawyku: " + habit.getName());
                System.out.println("Daty wykonania:");
                for (LocalDate date : habit.getCompletedDates()) {
                    System.out.println("- " + date);
                }
                return;
            }
        }
        System.out.println("Nie znaleziono nawyku o nazwie: " + name);
    }
}