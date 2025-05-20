import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MoodEntryTab {
    private JournalMan journalMan = new JournalMan(); // Journal manager to hold entries

    public MoodEntryTab() {
        JFrame frame = new JFrame("Add Mood Entry");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        // Date label and field
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setBounds(30, 30, 150, 25);
        JTextField dateField = new JTextField();
        dateField.setBounds(180, 30, 150, 25);

        // Note label and area
        JLabel noteLabel = new JLabel("Note:");
        noteLabel.setBounds(30, 70, 150, 25);
        JTextArea noteArea = new JTextArea();
        noteArea.setBounds(180, 70, 300, 100);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);

        // Mood label and combo box
        JLabel moodLabel = new JLabel("Mood:");
        moodLabel.setBounds(30, 190, 150, 25);
        JComboBox<String> moodBox = new JComboBox<>(Mood.Moods);
        moodBox.setBounds(180, 190, 150, 25);

        // Save button
        JButton saveButton = new JButton("Save Entry");
        saveButton.setBounds(180, 230, 150, 30);

        // Display area
        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(30, 280, 500, 150);
        displayArea.setEditable(false);

        // Save button action
        saveButton.addActionListener(e -> {
            String date = dateField.getText().trim();
            String note = noteArea.getText().trim();
            String mood = (String) moodBox.getSelectedItem();

            if (date.isEmpty() || note.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                return;
            }

            MoodEntry entry = new MoodEntry(date, note, mood);
            journalMan.addEntries(entry);

            displayArea.setText(""); // clear area
            List<Entry> entries = journalMan.getallEntry();
            for (Entry en : entries) {
                displayArea.append(((MoodEntry) en).Tostring() + "\n");
            }

            dateField.setText("");
            noteArea.setText("");
        });

        // Add components to frame
        frame.add(dateLabel);
        frame.add(dateField);
        frame.add(noteLabel);
        frame.add(noteArea);
        frame.add(moodLabel);
        frame.add(moodBox);
        frame.add(saveButton);
        frame.add(displayArea);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MoodEntryTab();
    }
}

