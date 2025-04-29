import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Habit {
    private String name;
    private Set<LocalDate> completedDates;

    // Konstructor
    // Initializes the name of the habit and creates an empty list for completed dates
    public Habit(String name) {
        this.name = name;
        this.completedDates = new HashSet<>(); // Using HashSet to avoid duplicates
        
    }

    // Getter and Setter methods
    // Returns the name of the habit
    public String getName() {
        return name;
    }

    public void markAsDone(LocalDate date) {
        // Marks the habit as done for the given date
        // Adds the date to the list of completed dates if it is not already present
        if (!completedDates.contains(date)) {
            completedDates.add(date);
        }
    }

    public Set<LocalDate> getCompletedDatesSet() {
        // Returns the set of completed dates
        return completedDates;
    }
    
  
    public double getCompletionRate() {
        if(completedDates.isEmpty()) {
            return 0;
        }

        LocalDate startDate = completedDates.stream().min(LocalDate::compareTo).orElse(LocalDate.now());
        long totalDays = startDate.until(LocalDate.now()).getDays() + 1; // Include the current day
        return (double) completedDates.size() / totalDays * 100; // Completion rate in percentage
    }
    
    // Returns the list of completed dates
    // Returns a copy of the list to prevent external modification
    public List<LocalDate> getCompletedDates() {
        return new ArrayList<>(this.completedDates);
    }

    public boolean isDoneOnDate(LocalDate date) {
        // Checks if the habit was completed on the given date
        return completedDates.contains(date);
    }

}