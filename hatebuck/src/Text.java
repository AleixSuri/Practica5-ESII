import java.util.*;

public class Text {
    private Missatge _missatge;
    private TipusPrivacitat _privacitat;

    public Text() {

    }

    public Text crearText() {
        Text t = new Text();
        return t;
    }

    public TipusPrivacitat getPrivacitat() {
        return _privacitat;
    }
}
