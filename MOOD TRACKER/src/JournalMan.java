import java.util.ArrayList;
import java.util.List;

class JournalMan {

    private List<Entry> entries = new ArrayList<>();

    public void addEntries(Entry entry) {
        entries.add(entry);
    }


    public List<Entry> getallEntry() {
        return entries;
    }
}

