package fr._42.pdespres.avaj_launcher;

import fr._42.pdespres.avaj_launcher.MD5.Crypt;
import fr._42.pdespres.avaj_launcher.aircraft.AircraftFactory;
import fr._42.pdespres.avaj_launcher.aircraft.Flyable;
import fr._42.pdespres.avaj_launcher.exceptions.*;
import fr._42.pdespres.avaj_launcher.readandwrite.Read;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;
import java.io.File;

public class Main {

    public static int       nbRun = 0;
    public static Read      ifile;
    public static Write     ofile;
    protected static Crypto md5file;

    public static void main(String... args) {

        if(args.length != 1) {
            System.out.println("usage: java avaj_launcher scenario_file");
            System.exit(42);
        }

        /*
        **  init de l'input file (package r&w class read)
        */
        try {
            ifile = new Read(new File(args[0]).getAbsolutePath());
        } catch (FileReadException e) {
            System.err.print(e);
            System.exit(42);
        }

//        // Bout de code pour generer un fichier MD5 de test
//        Crypt crypt = new Crypt("MD5");
//        try {
//            crypt.encryptFile(ifile.sourceLst);
//        } catch (FileWriteException | FileCreateException e) {
//            System.err.print(e);
//            System.exit(42);
//        }
//        System.exit(42);

        /*
        **  Check MD5. (Seul moyen pas terrible check length = 32)
        */
        if (ifile.sourceLst.get(0).length() == 32) {
            try {
                md5file = new Crypto(ifile.sourceLst);
                ifile = new Read(new File(md5file.getNewFile()).getAbsolutePath());
            } catch (FileReadException | FileWriteException | FileCreateException e) {
                System.err.print(e);
                System.exit(42);
            }
        }

        /*
        **  init de l'output file (package r&w class write)
        */
        try {
            ofile = new Write("./simulation.txt");
        } catch (FileCreateException e) {
            System.err.print(e);
            System.exit(42);
        }

        /*
        **  parser de l'input
        */
        try {
            try {
                if (Integer.parseInt(ifile.sourceLst.get(0)) < 0) {
                    throw new FileParserException("Scenario first line should be a positive number.");
                }
            } catch (NumberFormatException e) {
                throw new FileParserException("Scenario first line should be a positive number.");
            }
            if (ifile.sourceLst.size() < 2) {
                throw new FileParserException("Scenario don't have aircraft data.");
            }
            for (int i = 1; i < ifile.sourceLst.size(); i++) {
                String[] word = ifile.sourceLst.get(i).split(" ");
                if (word.length < 5)
                    throw new FileParserException("Scenario line " + (i + 1) + " has too few info.");
                if (word.length > 5)
                    throw new FileParserException("Scenario line " + (i + 1) + " has too much info.");
                if (!word[0].toUpperCase().equals("BALOON") && !word[0].toUpperCase().equals("JETPLANE") && !word[0].toUpperCase().equals("HELICOPTER"))
                    throw new FileParserException("Scenario first item of a line should be Baloon or JetPlane or Helicopter.");
                for (int j = 2; j < 5; j++) {
                    try {
                        if (Integer.parseInt(word[j]) < 0) {
                            throw new FileParserException("Scenario line " + (i + 1) + " field " + (j + 1) + " should be a positive number.");
                        }
                    } catch (NumberFormatException e) {
                        throw new FileParserException("Scenario line " + (i + 1) + " last three fields should hold numbers.");
                    }
                }
            }
        } catch (FileParserException e) {
            System.err.print(e);
            System.exit(42);
        }

        /*
        ** Lancement de la simulation
        */
        WeatherTower weatherTower = new WeatherTower();
        try {
            Main.nbRun = Integer.parseInt(ifile.sourceLst.get(0));
            for (int i = 1; i < ifile.sourceLst.size(); i++) {
                String[] word = ifile.sourceLst.get(i).split(" ");
                Flyable flyable = AircraftFactory.newAirCraft(word[0], word[1], Integer.parseInt(word[2]), Integer.parseInt(word[3]), Integer.parseInt(word[4]));
                if (flyable.equals(null))
                    throw new FileWriteException("Aircraft creation failed on line " + i + ".");
                flyable.registerTower(weatherTower);
            }
        } catch (FileWriteException e) {
            System.err.print(e);
            System.exit(42);
        }

        for (int i = 0; i < Main.nbRun; i++) {
            try {
                weatherTower.changeWeather();
            } catch (FileWriteException e) {
                System.err.print(e);
                System.exit(42);
            }
        }
    }
}