import java.util.*;

public class SignePuntuacio extends ElementText{
    private char _valor;

    public SignePuntuacio() {
        super();
    }

    public SignePuntuacio(char c) {_valor=c;}

    public char obtenirSigne() {
        return _valor;
    }
}
