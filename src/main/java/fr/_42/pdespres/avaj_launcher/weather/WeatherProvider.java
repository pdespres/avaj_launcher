package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Coordinates;
import java.util.Random;

/*
**  singleton pattern
*/

public class WeatherProvider {

    private static          WeatherProvider weatherProvider = new WeatherProvider();
    private static          String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        private Random      rnd;

        if(coordinates.getHeight() > 50)
        String weather = "SUN";
        return (weather);
    }
}
