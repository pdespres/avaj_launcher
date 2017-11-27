package fr._42.pdespres.avaj_launcher.aircraft;

/*
*   factory pattern linke a l'interface directement?
*/

public abstract class AircraftFactory {

    public static Flyable newAirCraft(String type, String name, int longitude, int latitude, int height) {
        switch (type) {
            case "Baloon"       : return (new Baloon(name, Coordinates(longitude, latitude, height)));
            case "JetPlane"     : return (new JetPlane(name, Coordinates(longitude, latitude, height)));
            case "Helicopter"   : return (new Helicopter(name, Coordinates(longitude, latitude, height)));
        }
    }
}
