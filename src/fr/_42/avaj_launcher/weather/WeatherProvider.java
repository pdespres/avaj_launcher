package fr._42.avaj_launcher.weather;

/*
**  singleton pattern
*/

public class WeatherProvider {
    private static WeatherProvider ourInstance = new WeatherProvider();

    public static WeatherProvider getProvider() {
        return ourInstance;
    }

    private WeatherProvider() {
    }
}
