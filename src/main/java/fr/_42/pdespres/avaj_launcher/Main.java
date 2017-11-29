package fr._42.pdespres.avaj_launcher;

import fr._42.pdespres.avaj_launcher.aircraft.Flyable;
import fr._42.pdespres.avaj_launcher.exceptions.*;
import fr._42.pdespres.avaj_launcher.readandwrite.Read;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;
import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static int       nbRun = 0;
    public static Read      ifile;
    public static Write     ofile;

    public static void main(String[] args) {

        /*
        **  init de l'input file (package r&w class read)
        */
        if(args.length != 1) {
            System.out.println("usage: java avaj_launcher scenario_file");
            System.exit(42);
        }

        /*
        **  MD5? getalgorithm class message digest 128 bits 32 octet
        **  chargement conplet en une string / traitement / rendu en newfile
        */

        try {
            ifile = new Read(new File(args[0]).getAbsolutePath());
        } catch (FileReadException e) {
            System.err.print(e);
            System.exit(42);
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
            if (ifile.sourceLst.size() < 1) {
                throw new FileParserException("test" + ifile.sourceLst.size());
            }
            try {
                if (Integer.parseInt(ifile.sourceLst.get(0)) < 0) {
                    throw new FileParserException("Scenario first line should be a positive number.");
                }
            } catch (NumberFormatException e) {
                throw new FileParserException("Scenario first line should be a positive number.");
            }
            for (int i = 1; i < ifile.sourceLst.size(); i++) {
                String[] word = ifile.sourceLst.get(i).toUpperCase().split(" ");
                if (word.length < 5)
                    throw new FileParserException("Scenario line " + (i + 1) + " has too few info.");
                if (word.length > 5)
                    throw new FileParserException("Scenario line " + (i + 1) + " has too much info.");
                if (!word[0].equals("BALOON") && !word[0].equals("JETPLANE") && !word[0].equals("HELICOPTER"))
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

        System.exit(42);
        /*
        ** Lancement de la simulation
        */
        WeatherTower weatherTower = new WeatherTower();
        // register tower
//  traiter le null du aircraft factory
//  weathertower change en public?
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
