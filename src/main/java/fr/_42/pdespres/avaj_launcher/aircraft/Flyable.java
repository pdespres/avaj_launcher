package fr._42.pdespres.avaj_launcher.aircraft;

import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

public interface Flyable {

    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}
