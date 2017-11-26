package fr._42.avaj_launcher.aircraft;

public abstract class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = Aircraft.nextId();
    }

    private static long nextId(){
        return (Aircraft.idCounter += 1);
    }
}
