import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewEntriesTab {

    public ViewEntriesTab(JournalMan journalMan) {
        JFrame frame = new JFrame("View Saved Mood Entries");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea entriesArea = new JTextArea();
        entriesArea.setEditable(false);
        entriesArea.setFont(new Font("Arial", Font.PLAIN, 14));

        List<Entry> entries = journalMan.getallEntry();
        for (Entry entry : entries) {
            entriesArea.append(((MoodEntry) entry).Tostring() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(entriesArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
