package fr._42.pdespres.avaj_launcher.aircraft;

public abstract class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = Aircraft.nextId();
    }

    private static long nextId(){
        return (Aircraft.idCounter += 1);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
    }
}