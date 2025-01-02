public class MissatgePrivat{
    private boolean _notificar;
    private Missatge _m;

    public MissatgePrivat(boolean notifica) {
        _m = new Missatge();
        _notificar = notifica;
    }


    public void afegirElement(ElementText elemtxt) {
       _m.afegirElement(elemtxt);
    }

    public boolean comprovarLlistaBloqueig() {
        return false;
    }

    public boolean comprovarLlistaPermesos() {
        return false;
    }

}
