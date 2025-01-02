import java.io.*;
import java.util.*;


public class HateBuck {
    private List<UsuariRegistrat> _usuarisRegistrats;
    private static List<Moderador> _moderadors;
    static Scanner scanner = new Scanner(System.in);
    private static UsuariRegistrat _user;


    public static void main(String[] args) {
        HateBuck hateBuck = new HateBuck();
        hateBuck.llegirUsuariRegistrats();

        hateBuck.login();
        int option;

        mostrarMenu();
        option = scanner.nextInt();

        while(option != 0){
            switch(option){
                case 1:
                    hateBuck.enviarMissatgePriv();
                    break;
                case 2:
                    if(hateBuck._user instanceof  Moderador) hateBuck.modificarTextUser();
                    else System.out.println("Opció vàlida només per moderadors");
                    break;
                case 3:
                    hateBuck.canviarRelation();
                    break;
                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
            mostrarMenu();
            option = scanner.nextInt();
        }
        System.out.println("\nSessió tancada correctament.\nFins aviat!");
    }

    private void llegirUsuariRegistrats() {
        _usuarisRegistrats = new LinkedList<>();
        _moderadors = new LinkedList<>();
        int comptAtrUsuari = 0;

        try (Scanner scanner = new Scanner(new File("hatebuck/dadesInicials/usuaris.txt"))) {
            String name = "", nick= "", pswrd= "", email= "";
            while (scanner.hasNextLine()) {
                switch(comptAtrUsuari) {
                    case 0:
                        name = scanner.nextLine();
                        break;
                    case 1:
                        pswrd = scanner.nextLine();
                        break;
                    case 2:
                        nick = scanner.nextLine();
                        break;
                    case 3:
                        email = scanner.nextLine();
                        break;
                    case 4:
                        if(scanner.nextLine().equals("ADMIN")) _moderadors.add(new Moderador(name, nick, pswrd, email));
                        _usuarisRegistrats.add(new UsuariRegistrat(name, nick, pswrd, email));
                        break;
                }
                comptAtrUsuari = (comptAtrUsuari == 4) ? 0 : comptAtrUsuari + 1;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Arxiu no trobat: " + e.getMessage());
        }

    }

    public void login(){
        String nick = "", pswrd = "";
        _user = null;
        boolean seguir=true;
        while(_user==null && seguir){
            System.out.println("Introduir sobrenom: ");
            nick = scanner.nextLine();
            System.out.println("Introduir contrasenya: ");
            pswrd = scanner.nextLine();
            _user= existeixUser(nick);
            if (_user == null || !_user.comparePassword(pswrd)) {
                System.out.println("Sobrenom o contrasenya incorrectes");
                System.out.println("Vols tornar-ho a intentar? (si/no) " );
                seguir = scanner.nextLine().equals("si");
                _user = null;
            }
        }

        if(!seguir) {
            System.out.println("\nCompte bloquejat per seguretat ");
            System.exit(0);
        }
        else{
            System.out.println("\nAccés correcte!! Ben vingut!!");
        }
    }

    public static void mostrarMenu(){
        System.out.println("\n=== Menú Principal ===");
        System.out.println("0. Sortir");
        System.out.println("1. Enviar missatge privat ");
        System.out.println("2. Modificar text penjat per un usuari");
        System.out.println("3. Canviar relació amb un usuari ");
        System.out.print("Escull una opció: ");
    }

    public void enviarMissatgePriv(){
        UsuariRegistrat user = seleccionarUsers();
        MissatgePrivat message = new MissatgePrivat(true);
        System.out.println("Missatge a enviar: ");
        message.crearMissatge();
        _user.sendMessage(user,message);
        user.reciveMessage(_user,message);
    }

    public void modificarTextUser(){
        UsuariRegistrat user = seleccionarUsers();
        System.out.println("Missatge a modificar: ");
        String message = scanner.nextLine();
        System.out.println("Escriu el nou text: ");
        String text = scanner.nextLine();
//fer
        System.out.println("Missatge actualitzat");
    }

    public void canviarRelation(){

        UsuariRegistrat user = seleccionarUsers();
        TipusCategoria relation = null;

        while (relation == null) {
            System.out.println("Nou tipus de relació: ");
            try {
                relation = TipusCategoria.valueOf(scanner.nextLine());
                System.out.println("Relació seleccionada: " + relation);
            } catch (IllegalArgumentException e) {
                System.out.println("Relació no válida. (Amic,Conegut,Saludat)");
            }
        }
        _user.createRelation(user,new TipusRelacio(_user,user,relation));
        System.out.println("Relació creada correctament");

    }

    public UsuariRegistrat seleccionarUsers(){
        System.out.println("\n=== Usuaris ===");
        for(int i=0;i<_usuarisRegistrats.size();i++){
            _usuarisRegistrats.get(i).showNickname();
        }
        System.out.println("===  ===");scanner.nextLine();

        System.out.println("Introduir sobrenom del usuari: ");
        String nick = scanner.nextLine();

        UsuariRegistrat user = existeixUser(nick);
        while (user == null) {
            System.out.println("Alerta!! Aquest usuari no existeix");
            System.out.println("Introduir sobrenom del usuari: ");
            nick = scanner.nextLine();
            user = existeixUser(nick);
        }
        return user;
    }

    public UsuariRegistrat existeixUser(String nick){
        int compt=0;
        while(compt<_usuarisRegistrats.size()){
            if(_usuarisRegistrats.get(compt).compareNickname(nick)){
                return _usuarisRegistrats.get(compt);
            }
            compt++;
        }
        return null;
    }

}
