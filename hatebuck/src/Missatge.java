import java.util.*;

public class Missatge {
    List<ElementText> _elements;
    static Scanner scanner = new Scanner(System.in);

    public Missatge() {
        _elements = new LinkedList<>();
    }

    public void afegirElement(ElementText elemtxt) {
        _elements.add(elemtxt);
    }

    public void show(){
        for(int i=0;i<_elements.size();i++){
            _elements.get(i).contingut();
        }
    }
}
