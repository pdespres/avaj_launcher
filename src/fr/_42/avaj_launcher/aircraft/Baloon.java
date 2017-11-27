package fr._42.avaj_launcher.aircraft;

import fr._42.avaj_launcher.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    Ballon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
