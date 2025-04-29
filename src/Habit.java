import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habit {
    private String name;
    private List <LocalDate> completedDates;

    // Konstructor
    // Initializes the name of the habit and creates an empty list for completed dates
    public Habit(String name) {
        this.name = name;
        this.completedDates = new ArrayList<>();
        
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
    
    // Adds a completed date to the list of completed dates
    // The date is added only if it is not already present in the list
    public void addCompletedDate(LocalDate date) {
        this.completedDates.add(date);
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