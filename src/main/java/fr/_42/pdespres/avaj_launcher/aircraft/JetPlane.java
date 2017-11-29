package fr._42.pdespres.avaj_launcher.aircraft;

import com.sun.xml.internal.bind.v2.TODO;
import fr._42.pdespres.avaj_launcher.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() + 5, coordinates.getHeight());
                System.out.println(this + "A bit of rough weather. Buckles on.");
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                System.out.println(this + "Can't see much. Radar on.");
                break;
            }
            case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                System.out.println(this + "Sunglasses time. Auto-pilot on.");
                break;
            }
            case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                System.out.println(this + "Snowing! Going down for security. Moving on.");
                break;
            }
            default: {
                //TODO
            }
        }
        if (coordinates.getHeight() == 0) {
            System.out.println(this + " landing @longitude " + this.coordinates.getLongitude() + " latitude " + this.coordinates.getLatitude() + ".");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
