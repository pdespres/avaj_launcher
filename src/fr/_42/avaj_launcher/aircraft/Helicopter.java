package fr._42.avaj_launcher.aircraft;

import fr._42.avaj_launcher.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public  void registerTower(WeatherTower weatherTower) {

    }
}
