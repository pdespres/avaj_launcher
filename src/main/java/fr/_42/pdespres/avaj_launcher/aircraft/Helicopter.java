package fr._42.pdespres.avaj_launcher.aircraft;

import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println(this + " \n");
                break;
            } case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println(this + " \n");
                break;
            } case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                System.out.println(this + " \n");
                break;
            } case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                System.out.println(this + " \n");
                break;
            }
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
