import java.io.*;
import java.util.*;


public class HateBuck {
    private List<UsuariRegistrat> _usuarisRegistrats;

    public static void main(String[] args) {
        HateBuck hateBuck = new HateBuck();
        hateBuck._usuarisRegistrats = hateBuck.llegirUsuariRegistrats();

        for(int i=0;i<4;i++){
            hateBuck._usuarisRegistrats.get(i).showUser();
        }

    }

    private List<UsuariRegistrat> llegirUsuariRegistrats() {
        List<UsuariRegistrat> usuaris = new LinkedList<>();
        int comptAtrUsuari = 0;

        try (Scanner scanner = new Scanner(new File("hatebuck/dadesInicials/usuaris.txt"))) {
            String name = "", nick= "", pswrd= "", email= "";
            while (scanner.hasNextLine()) {
                switch(comptAtrUsuari) {
                    case 0:
                        name = scanner.nextLine();
                        break;
                    case 1:
                        nick = scanner.nextLine();
                        break;
                    case 2:
                        pswrd = scanner.nextLine();
                        break;
                    case 3:
                        email = scanner.nextLine();
                        break;
                    case 4:
                        usuaris.add(new UsuariRegistrat(name, nick, pswrd, email));
                        comptAtrUsuari=0;
                        break;
                }
                comptAtrUsuari++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Arxiu no trobat: " + e.getMessage());
        }
        return usuaris;
    }
}
