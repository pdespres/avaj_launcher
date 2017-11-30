package fr._42.pdespres.avaj_launcher;

import fr._42.pdespres.avaj_launcher.md5.Decrypt;
import fr._42.pdespres.avaj_launcher.exceptions.FileCreateException;
import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;
import java.util.ArrayList;

public class Crypto {

    private String          filePath = "./sim_test_decrypted.txt";

    Crypto(ArrayList<String> lines) throws FileWriteException, FileCreateException {
        Decrypt             decrypt = new Decrypt();
        Write               ofile = new Write(filePath);
        String              temp;
        try {
            for (int i = 0; i < lines.size(); i++) {
                String[] word = lines.get(i).split(" ");
                for (int j = 0; j < word.length; j++) {
                    temp = decrypt.getDecrypted(word[j]);
                    if (temp.equals(null)) {
                        throw new FileWriteException("Error while decrypting the file.");
                    }
                    else
                        ofile.writeToTarget(temp);
                    if (j != (word.length - 1))
                        ofile.writeToTarget(" ");
                }
                ofile.writeToTarget("\n");
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
