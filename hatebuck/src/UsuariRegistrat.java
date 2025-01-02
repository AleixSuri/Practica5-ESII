import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UsuariRegistrat {
    String _name;
    String _nickname;
    String _password;
    String _email;
    Map<UsuariRegistrat, TipusRelacio> relation;
    Map<UsuariRegistrat, List<MissatgePrivat>> messagesSend;
    Map<UsuariRegistrat, List<MissatgePrivat>> messagesRecived;
    List<Text> publications;


    public UsuariRegistrat(String name, String nick, String pswrd, String mail) {
        _name = name;
        _nickname = nick;
        _password = pswrd;
        _email = mail;
        relation = new HashMap<>();
        messagesSend = new HashMap<>();
        messagesRecived = new HashMap<>();
    }

    public void showUser() {
        System.out.println("Name: " + _name + "\nNickname: " + _nickname + "\nEmail: " + _email + "\n");
    }

    public void showNickname() {
        System.out.println(_nickname);
    }

    public boolean comparePassword(String pswrd) {return pswrd.equals(_password);
    }

    public boolean compareNickname(String nick) {return _nickname.equals(nick);}

    public void createRelation(UsuariRegistrat user, TipusRelacio typeRelation) {
        relation.put(user, typeRelation);
    }


    public void sendMessage(UsuariRegistrat user, MissatgePrivat message) {
        if (messagesSend.containsKey(user)) {messagesSend.get(user).add(message);}
        else{
            List<MissatgePrivat> newList = new LinkedList<>();
            newList.add(message);
            messagesSend.put(user, newList);
        }
    }

    public void reciveMessage(UsuariRegistrat user, MissatgePrivat message) {
        if (messagesRecived.containsKey(user)) {messagesRecived.get(user).add(message);}
        else{
            List<MissatgePrivat> newList = new LinkedList<>();
            newList.add(message);
            messagesRecived.put(user, newList);
        }
    }

    public void showMessages(UsuariRegistrat user) {
        for (int i = 0; i < messagesSend.size(); i++) {
            System.out.print("Missatge " + i + ": ");
            messagesSend.get(user).get(i).show();
            System.out.println("\n");
        }
    }

    public void publish(Text txt){
        publications.add(txt);
    }

    public void showPublication(){
        for(int i=0;i<publications.size();i++){
            System.out.println("Publication " + i + ": " + publications.get(i) + "\n");
        }
    }

}