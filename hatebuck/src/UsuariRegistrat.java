import java.util.HashMap;
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

    public TipusRelacio knowRelation(UsuariRegistrat user) {return relation.get(user);
    }

    public void sendMessage(UsuariRegistrat user, MissatgePrivat message) {
        messagesSend.get(user).add(message);
    }

    public void reciveMessage(UsuariRegistrat user, MissatgePrivat message) {
        messagesRecived.get(user).add(message);
    }

    public void showMessages(UsuariRegistrat user) {
        for (int i = 0; i < messagesSend.size(); i++) {
            System.out.println("Missatge " + i + ": " + messagesSend.get(user).get(i) +"\n");
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