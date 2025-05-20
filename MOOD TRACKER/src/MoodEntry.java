class MoodEntry extends Entry {
    private String mood;

    public MoodEntry(String date, String note,String mood) {
        super(date, note);
        this.mood = mood;
    }
    public String Getmood(){
        return mood;
    }

    @Override
    public String GetSummary() {
        return GetDate() + "| Mood :" + mood + "Note :" + GetNote();
    }
    public String Tostring(){
        return GetDate() + "| Mood :" + mood + "\n" + "Note :" + GetNote();
    }
}
