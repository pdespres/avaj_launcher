package fr._42.pdespres.avaj_launcher;

import fr._42.pdespres.avaj_launcher.MD5.Decrypt;
import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;

import java.io.File;
import java.util.ArrayList;

public class Crypto {

    private String          filePath;
    private static File     target;

    Crypto(ArrayList<String> lines) throws FileWriteException {
        Decrypt             decrypt = new Decrypt();
        try {
            for (int i = 1; i < lines.size(); i++) {
                String[] word = lines.get(i).split(" ");
                for (int j = 0; j < word.length; j++) {
                    if (decrypt.getDecrypted(word[j]) == null)
                        throw new FileWriteException("Error while decrypting the file.");
                    else {

                    }
                }
            }
        } catch (FileWriteException e) {
            System.err.print(e);
            System.exit(42);
        }
    }

    protected String getNewFile() {
        return (filePath);
    }
}
