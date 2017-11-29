package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Coordinates;
import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather() throws FileWriteException {
        conditionsChanged();
    }
}