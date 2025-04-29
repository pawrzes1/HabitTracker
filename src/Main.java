import java.time.LocalDate;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main{
    private static HabitTracker habitTracker = new HabitTracker();
    public static void main(String[] args) {
        //Tworzymy główne okno aplikacji
        JFrame frame = new JFrame("Habit Tracker");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Times New Roman", Font.PLAIN, 14);

        //Pamel do umieszczenia komponentów w oknie
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        //Tworzymy przyciski
        JButton addButton = new JButton("Dodaj nawyk");
        JButton markButton = new JButton("Zaznacz nawyk jako wykonany");
        JButton showButton = new JButton("Wyswietl wszystkie nawyki");
        JButton historyButton = new JButton("Wyswietl historie nawyku");
        JButton statisticsButton = new JButton("Statystyki nawyku");
        JButton exitButton = new JButton("Wyjdz");


        addButton.setFont(font);
        markButton.setFont(font);
        showButton.setFont(font);
        historyButton.setFont(font);
        statisticsButton.setFont(font);
        exitButton.setFont(font);


        //Dodajemy przyciski do panelu
        panel.add(addButton);
        panel.add(markButton);
        panel.add(showButton);
        panel.add(historyButton);
        panel.add(statisticsButton);
        panel.add(exitButton);

        //Dodajemy panel do okna
        frame.add(panel);

        //Ustawiamy widoczność okna
        frame.setVisible(true);

        //Obsługa zdarzeń przycisków
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habitName = JOptionPane.showInputDialog( "Podaj nazwe nawyku:");
                if(habitName != null && !habitName.isEmpty()) {
                    Habit habit = new Habit(habitName);
                    
                    habitTracker.addHabit(habit);
                    JOptionPane.showMessageDialog(frame, "Dodano nawyk: " + habitName);
                } else {
                    JOptionPane.showMessageDialog(frame, "Prosze podac nazwe nawyku.");
                }
            }
        });

        
        markButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habitName = JOptionPane.showInputDialog(frame, "Podaj nazwę nawyku:");
                String dateString = JOptionPane.showInputDialog(frame, "Podaj date (YYYY-MM-DD):");
                if(habitName != null && !habitName.isEmpty() && dateString != null && !dateString.isEmpty()) {
                    LocalDate date = LocalDate.parse(dateString);
                    habitTracker.markHabitIsDone(habitName, date);
                } else {
                    JOptionPane.showMessageDialog(frame, "Prosze podac nazwe nawyku i date.");
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habitTracker.showHabits();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habitName = JOptionPane.showInputDialog(frame, "Podaj nazwe nawyku:");
                if(habitName != null && !habitName.isEmpty()) {
                    habitTracker.showHabitHistory(habitName);
                } else {
                    JOptionPane.showMessageDialog(frame, "Prosze podac nazwe nawyku.");
                }
            }
        });

        statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habitName = JOptionPane.showInputDialog(frame, "Podaj nazwe nawyku:");
                if(habitName != null && !habitName.isEmpty()) {
                    habitTracker.showHabitStatistics(habitName);
                } else {
                    JOptionPane.showMessageDialog(frame, "Prosze podac nazwe nawyku.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}