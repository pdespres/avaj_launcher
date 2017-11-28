package fr._42.pdespres.avaj_launcher;

import fr._42.pdespres.avaj_launcher.aircraft.Flyable;
import fr._42.pdespres.avaj_launcher.exceptions.*;
import fr._42.pdespres.avaj_launcher.readandwrite.Read;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;
import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

public class Main {

    public static int       nbRun = 0;

    public static void main(String[] args) {

        /*
        **  init de l'input file (package r&w class read)
         */
//        List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(args[1]), StandardCharsets.UTF_8);
        try {
            Read            ifile = new Read(args[0]);
        } catch (FileReadException e) {
            System.err.print(e);
            System.exit(42);
        }

        /*
        ** MD5? getalgorithm class message digest 128 bits 32 octet
        */

        /*
        **  init de l'output file (package r&w class write)
        */
        try {
            Write           ofile = new Write("?/simulation.txt");
        } catch (FileCreateException e) {
            System.err.print(e);
            System.exit(42);
        }

        /*
        **  parser de l'input
        */

        /*
        ** Lancement de la simulation
        */
        WeatherTower weatherTower = new WeatherTower();

//  weathertower change en public?
        for (int i = 0; i < Main.nbRun; i++) {
            weatherTower.changeWeather();
        }
    }
}
