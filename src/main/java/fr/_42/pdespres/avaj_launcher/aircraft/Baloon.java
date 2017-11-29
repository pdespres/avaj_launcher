package fr._42.pdespres.avaj_launcher.aircraft;

import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;
import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws FileWriteException {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                Write.writeToTarget(this + ": Oh great, some rain!");
                break;
            } case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                Write.writeToTarget(this + ": Shit fog!");
                break;
            } case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                Write.writeToTarget(this + ": Everything ok.");
                break;
            } case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                Write.writeToTarget(this + ": Snow...Our father, who art in heaven...");
                break;
            }
        }
        if (coordinates.getHeight() == 0) {
            Write.writeToTarget(this + " landing @longitude " + this.coordinates.getLongitude() + " latitude " + this.coordinates.getLatitude() + ".");
            weatherTower.unregister(this);
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws FileWriteException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
