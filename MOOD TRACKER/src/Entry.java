 class Entry{
    private String date;//set data using access modifier.
    private String note;
    public Entry(String date,String note){
        this.date = date;
        this.note = note;
    }
public String GetDate(){
        return date;
}
public String GetNote(){
        return note;
}
public String GetSummary(){   //call the get summary function.
        return date + "|Note :" + note;
}
public String Tostring(){ // override.
        return date + "\n" + note + "\n";
 }
}