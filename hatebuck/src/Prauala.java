public class Prauala implements ParaulaStrategy{
    private String _paraula;

    public Prauala(String s) {
        _paraula=s;
    }

    @Override
    public void contingut() {
        System.out.print(_paraula);
    }
}
