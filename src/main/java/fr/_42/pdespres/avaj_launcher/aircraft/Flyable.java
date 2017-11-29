package fr._42.pdespres.avaj_launcher.aircraft;

import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;
import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

public interface Flyable {

    void updateConditions() throws FileWriteException;

    void registerTower(WeatherTower weatherTower) throws FileWriteException;
}
