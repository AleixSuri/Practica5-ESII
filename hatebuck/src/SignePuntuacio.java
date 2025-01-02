public class SignePuntuacio extends ElementText{
    private char _valor;

    public SignePuntuacio(char c) {_valor=c;}

    public void contingut(){
        System.out.print(_valor);
    }
}
