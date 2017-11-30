package fr._42.pdespres.avaj_launcher.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypt {

    private static MessageDigest digester;

    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String Crypt(String str) {
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
//        final MessageDigest md = MessageDigest.getInstance("MD5");
//        final byte[] messageDigest = md.digest(input.getBytes());
//        final BigInteger number = new BigInteger(1, messageDigest);
//        return String.format("%032x", number);
//        //md5 = new BigInteger(1, digest()).toString(16);
//    }
}