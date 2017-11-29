package fr._42.pdespres.avaj_launcher.aircraft;

/*
**  factory pattern linke a l'interface directement?
**  use sub aircraft classes to create flyable
*/

public class AircraftFactory {

    public static Flyable newAirCraft(String type, String name, int longitude, int latitude, int height) {
        switch (type) {
            case "Baloon"       : return (new Baloon(name, new Coordinates(longitude, latitude, height)));
            case "JetPlane"     : return (new JetPlane(name, new Coordinates(longitude, latitude, height)));
            case "Helicopter"   : return (new Helicopter(name, new Coordinates(longitude, latitude, height)));
            default             : return (null);
        }
    }
}
