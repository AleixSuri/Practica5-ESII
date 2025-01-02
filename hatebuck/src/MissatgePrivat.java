import java.util.*;

public class MissatgePrivat extends Missatge{
    private boolean _notificar;

    public MissatgePrivat(boolean notifica) {
        _notificar = notifica;
    }

    public Missatge crearMissatge() {
        return null;
    }

    public boolean comprovarLlistaBloqueig() {
        return false;
    }

    public boolean comprovarLlistaPermesos() {
        return false;
    }
}
