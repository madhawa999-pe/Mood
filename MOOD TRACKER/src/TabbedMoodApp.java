import javax.swing.*;
import java.awt.*;

public class TabbedMoodApp {

    public static void main(String[] args) {
        // Make sure GUI runs on the Swing event thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TabbedMoodApp().createUI();
            }
        });
    }

    private void createUI() {
        // Create the main window (frame)
        JFrame frame = new JFrame("🌈 MoodMate - Mood Tracker");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center window on screen

        // Create a tabbed pane to hold tabs
        JTabbedPane tabs = new JTabbedPane();

        // Create the journal manager (handles mood data)
        JournalMan journalManager = new JournalMan();

        // Create the "Enter Mood" tab panel
        MoodInputTab inputTab = new MoodInputTab(journalManager);
        JPanel inputPanel = inputTab.getPanel();
        inputPanel.setBackground(new Color(255, 228, 225)); // Light pink background

        // Create the "View Entries" tab panel
        MoodViewTab viewTab = new MoodViewTab(journalManager);
        JPanel viewPanel = viewTab.getPanel();
        viewPanel.setBackground(new Color(224, 255, 255)); // Light blue background

        // Add tabs to the tabbed pane with titles and panels
        tabs.addTab("😊 Enter Mood", inputPanel);
        tabs.addTab("📚 View Entries", viewPanel);
        tabs.setBackground(new Color(240, 255, 240)); // Light green behind tabs

        // Set the background color of the main window content area
        frame.getContentPane().setBackground(new Color(245, 245, 220)); // Beige color

        // Add the tabbed pane to the window
        frame.add(tabs);

        // Make the window visible
        frame.setVisible(true);
    }
}
