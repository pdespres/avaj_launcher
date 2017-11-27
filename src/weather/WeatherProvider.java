package weather;

import aircraft.Coordinates;

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
