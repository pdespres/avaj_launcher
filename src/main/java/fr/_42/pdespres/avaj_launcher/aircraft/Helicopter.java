package fr._42.pdespres.avaj_launcher.aircraft;

import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;
import fr._42.pdespres.avaj_launcher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws FileWriteException {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                Write.writeToTarget(this + "Few drops here.");
                break;
            } case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                Write.writeToTarget(this + "Some fog here.");
                break;
            } case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                Write.writeToTarget(this + "Nice weather here.");
                break;
            } case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                Write.writeToTarget(this + "Rotor freezing...going down fast. Any place to land here?");
                break;
            }
            default: {
                throw new FileWriteException("Error weather undefined for " + this + ".");
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
