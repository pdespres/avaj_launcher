package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Coordinates;

/*
**  singleton pattern
*/

public class WeatherProvider {

    private static WeatherProvider ourInstance = new WeatherProvider();
    private static String[];

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return ourInstance;
    }

    public String getCurrentWeather(Coordinates coordinates) {

    }
}
