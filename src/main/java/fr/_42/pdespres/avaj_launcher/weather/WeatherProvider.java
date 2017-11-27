package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Coordinates;

/*
**  singleton pattern
*/

public class WeatherProvider {

    private static WeatherProvider ourInstance = new WeatherProvider();
    private static String[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return ourInstance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        if (coordinates.getHeight() > 50) {

        }
        }
    }
}
