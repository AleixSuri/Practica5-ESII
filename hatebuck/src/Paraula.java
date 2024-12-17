import java.util.*;

public class Paraula extends ElementText{
    private ParaulaStrategy _p;

    public Paraula() {
        super();
        this._p = new ParaulaStrategy();
    }

    public String contingut() {
        // iterar sobre totes les paraules aleatoriament i retornar una

        return this._p.contingut();
    }
}
