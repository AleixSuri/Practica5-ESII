import sun.plugin2.message.Message;

import java.util.List;
import java.util.Map;

public class UsuariRegistrat {
    String _name;
    String _nickname;
    String _password;
    String _email;
    Map<UsuariRegistrat, TipusRelacio> relation;
    Map<UsuariRegistrat, List<MissatgePrivat>> messages;
    List<Text> publications;


    public UsuariRegistrat(String name, String nick, String pswrd, String mail) {
        _name = name;
        _nickname = nick;
        _password = pswrd;
        _email = mail;
    }

    public void showUser() {
        System.out.println("Name: " + _name + "\nNickname: " + _nickname + "Email: " + _email);
    }

    public boolean comparePassword(String pswrd) {
        return pswrd == _password;
    }

    public void createRelation(UsuariRegistrat user, TipusRelacio typeRelation) {
        relation.put(user, typeRelation);
    }

    public TipusRelacio knowRelation(UsuariRegistrat user) {
        return relation.get(user);
    }

    public void giveMessage(UsuariRegistrat user, MissatgePrivat message) {
        messages.get(user).add(message);
    }

    public void showMessages(UsuariRegistrat user) {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println("Missatge " + i + ": " + messages.get(user).get(i) +"\n");
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