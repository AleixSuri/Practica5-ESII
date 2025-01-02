public class ParaulaAmagada implements ParaulaStrategy{
    String _paraula;
    public ParaulaAmagada(String s) {
        _paraula = s;
    }

    @Override
    public void contingut() {
        System.out.print(_paraula);
    }
}
