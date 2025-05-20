import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MoodViewTab {
    private JPanel panel;
    private JournalMan journalMan;

    public MoodViewTab(JournalMan journalMan) {
        this.journalMan = journalMan;
        panel = new JPanel(new BorderLayout());

        // Text area to display mood entries, not editable by user
        final JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Scroll pane to add scrolling ability to the text area
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Button to refresh the displayed entries
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                displayArea.setText("");  // Clear previous content

                // Get all entries from journal manager
                List<Entry> entries = journalMan.getallEntry();

                // Loop through each entry and display its text
                for (Entry entry : entries) {
                    // Cast to MoodEntry and get string representation
                    displayArea.append(((MoodEntry) entry).Tostring() + "\n");
                }
            }
        });

        // Add scroll pane in the center and button at the bottom of the panel
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(refreshButton, BorderLayout.SOUTH);
    }

    // Getter to provide the panel for adding to the main frame
    public JPanel getPanel() {
        return panel;
    }
}
