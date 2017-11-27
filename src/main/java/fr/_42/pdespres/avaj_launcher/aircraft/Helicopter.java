package fr._42.pdespres.avaj_launcher.aircraft;

import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }
}
