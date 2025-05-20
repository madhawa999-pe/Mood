import java.awt.*;

class Mood {
    public static String[] Moods = {"HAPPY","SAD","ANGRY","EXCITED","CALM"};
    public static Color GetMoodColor(String mood){
        switch (mood){
            case "HAPPY" : return new Color(255,223,82);
            case "SAD" : return new Color(100,149,237);
            case "ANGRY" : return new Color(220,20,60);
            case "EXCITED" : return new Color(255,140,60);
            case "CALM" : return new Color(135,206,235);
            default:return Color.LIGHT_GRAY;
        }
    }
}
