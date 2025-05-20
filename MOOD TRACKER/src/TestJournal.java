public class TestJournal {
    public static void main(String[] args) {
        // Create JournalManager instance
        JournalMan journalManager = new JournalMan();

        // Create MoodEntry objects (inheritance + polymorphism)
        MoodEntry entry1 = new MoodEntry("2025-05-20", "Happy", "Had a great day at the park.");
        MoodEntry entry2 = new MoodEntry("2025-05-21", "Sad", "Feeling a bit down today.");
        MoodEntry entry3 = new MoodEntry("2025-05-22", "Excited", "Looking forward to the weekend!");

        // Add entries to manager
        journalManager.addEntries(entry1);
        journalManager.addEntries(entry2);
        journalManager.addEntries(entry3);

        // Print all entries using getSummary()
        for (Entry entry : journalManager.getallEntry()) {
            System.out.println(entry.GetSummary());
        }
    }
}
