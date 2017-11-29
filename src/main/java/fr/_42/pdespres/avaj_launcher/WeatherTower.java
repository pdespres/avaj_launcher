package fr._42.pdespres.avaj_launcher;

import fr._42.pdespres.avaj_launcher.aircraft.Coordinates;
import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;
import fr._42.pdespres.avaj_launcher.weather.Tower;
import fr._42.pdespres.avaj_launcher.weather.WeatherProvider;

/*
**  Weathertower place ici plutot qu'en package weather pour respecter le package visibility de changeweather
*/

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather() throws FileWriteException {
        conditionsChanged();
    }
}