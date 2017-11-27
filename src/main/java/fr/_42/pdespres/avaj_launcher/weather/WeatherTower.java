package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider(coordinates));
    }

    void changeWeather() {
        for (int i = 1 ; i <= observers.size() ; i++) {
            observers[i].
        }

    }
}
