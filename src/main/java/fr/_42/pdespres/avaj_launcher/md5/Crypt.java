package fr._42.pdespres.avaj_launcher.md5;

import fr._42.pdespres.avaj_launcher.exceptions.FileCreateException;
import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Crypt {

    private static MessageDigest    digester;

    public Crypt(String method) {
        try {
            digester = MessageDigest.getInstance(method);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encrypt cannot be null or zero length");
        }

        digester.update(str.getBytes());
        byte[] hash = digester.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }

//    private static String md5(final String input) throws NoSuchAlgorithmException {
//        final MessageDigest md = MessageDigest.getInstance("md5");
//        final byte[] messageDigest = md.digest(input.getBytes());
//        final BigInteger number = new BigInteger(1, messageDigest);
//        return String.format("%032x", number);
//        //md5 = new BigInteger(1, digest()).toString(16);
//    }

    public void encryptFile(ArrayList<String> lines) throws FileCreateException, FileWriteException {
        Write       ofile = new Write("./sim_testmd5.txt");
        try {
            for (int i = 0; i < lines.size(); i++) {
                String[] word = lines.get(i).split(" ");
                for (int j = 0; j < word.length; j++) {
                    ofile.writeToTarget(Crypt.encrypt(word[j]));
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
}