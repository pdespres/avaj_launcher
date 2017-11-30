package fr._42.pdespres.avaj_launcher.MD5;

import java.util.HashMap;

public class Decrypt {

    private HashMap     dico = new HashMap();
    private enum FirstWord {Baloon, JetPlane, Helicopter, BALOON, JETPLANE, HELICOPTER};
    private enum NamePrefix {B,H,J};

    public Decrypt() {
        genDictionary();
    }

    public String getDecrypted(String encrypted) {
        return (dico.get(encrypted).toString());
    }

    private void genDictionary() {
        for(FirstWord firstWord : FirstWord.values()) {
           dico.put(Crypt.Crypt(firstWord.toString()), firstWord.toString());
        }
        for(int i = 0; i < 1000; i++) {
            dico.put(Crypt.Crypt(String.valueOf(i)), i);
        }
        for(int i = 0; i < 100; i++){
            for(NamePrefix prefix : NamePrefix.values()) {
                dico.put(Crypt.Crypt(prefix.toString() + String.valueOf(i)), prefix.toString() + String.valueOf(i));
            }
        }
    }
}