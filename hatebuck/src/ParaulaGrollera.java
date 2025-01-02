public class ParaulaGrollera implements ParaulaStrategy{
    String _paraula;

    public ParaulaGrollera(String s) {
        _paraula = s;
    }

    @Override
    public void contingut() {
        System.out.println(_paraula);
    }
}
