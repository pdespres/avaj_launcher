package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Coordinates;
import java.util.Random;

/*
**  singleton pattern
*/

public class WeatherProvider {

    private static          WeatherProvider weatherProvider = new WeatherProvider();
    private static          String[] weather = {"FOG", "RAIN", "SNOW", "SUN"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

         Random             rnd = new Random();

        if(coordinates.getHeight() > 50) {
            if(rnd.nextInt(99) > 49)
                return ("SUN");
            else
                return (weather[rnd.nextInt(2)]);
        }
        else if(coordinates.getHeight() < 10) {
            if(rnd.nextInt(99) > 49)
                return ("FOG");
            else
                return (weather[rnd.nextInt(2) + 1]);
        }
        else
            return (weather[rnd.nextInt(3)]);
    }
}
