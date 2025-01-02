public class ParaulaNormal implements ParaulaStrategy{
    private String _paraula;

    public ParaulaNormal(String s) {
        _paraula=s;
    }


    @Override
    public void contingut() {
        System.out.print(_paraula);
    }
}
