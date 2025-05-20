import javax.swing.*;
import java.awt.*;

public class MoodInputTab {
    private JPanel panel;
    private JournalMan journalMan;

    public MoodInputTab(JournalMan journalMan) {
        this.journalMan = journalMan;
        panel = new JPanel(null); // Use null layout for manual positioning

        // Label and TextField for Date
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setBounds(30, 30, 150, 25);
        JTextField dateField = new JTextField();
        dateField.setBounds(180, 30, 150, 25);

        // Label and TextArea for Note
        JLabel noteLabel = new JLabel("Note:");
        noteLabel.setBounds(30, 70, 150, 25);
        JTextArea noteArea = new JTextArea();
        noteArea.setBounds(180, 70, 300, 100);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);

        // Label and ComboBox for Mood selection
        JLabel moodLabel = new JLabel("Mood:");
        moodLabel.setBounds(30, 190, 150, 25);
        JComboBox<String> moodBox = new JComboBox<String>(Mood.Moods);
        moodBox.setBounds(180, 190, 150, 25);

        // Save button
        JButton saveButton = new JButton("Save Entry");
        saveButton.setBounds(180, 230, 150, 30);

        // Add action listener for save button
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String date = dateField.getText().trim();
                String note = noteArea.getText().trim();
                String mood = (String) moodBox.getSelectedItem();

                if (date.isEmpty() || note.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                MoodEntry entry = new MoodEntry(date, note, mood);
                journalMan.addEntries(entry);

                JOptionPane.showMessageDialog(panel, "Entry saved successfully!");

                // Clear input fields after saving
                dateField.setText("");
                noteArea.setText("");
            }
        });

        // Add all components to the panel
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(noteLabel);
        panel.add(noteArea);
        panel.add(moodLabel);
        panel.add(moodBox);
        panel.add(saveButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
