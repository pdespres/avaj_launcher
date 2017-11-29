package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Flyable;
import fr._42.pdespres.avaj_launcher.exceptions.FileWriteException;
import fr._42.pdespres.avaj_launcher.readandwrite.Write;

import java.util.ArrayList;

/*
**  observer pattern
*/

public abstract class Tower {

    private ArrayList<Flyable> observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    public void register(Flyable flyable) throws  FileWriteException {
        observers.add(flyable);
        Write.writeToTarget("Tower says: " + flyable + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) throws FileWriteException {
        observers.remove(flyable);
        Write.writeToTarget("Tower says: " + flyable + " unregistered from weather tower.");
    }

    protected void conditionsChanged() throws FileWriteException {
        for (int i = 0; i < observers.size(); i++) {
        //for(Flyable flyable : observers) {
            System.out.println("launch update ok for " + observers.get(i));
            observers.get(i).updateConditions();
        }
    }
}
