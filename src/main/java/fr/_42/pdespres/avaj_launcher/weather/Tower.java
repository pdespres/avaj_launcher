package fr._42.pdespres.avaj_launcher.weather;

import fr._42.pdespres.avaj_launcher.aircraft.Flyable;
import java.util.ArrayList;

/*
**  observer pattern
*/

public abstract class Tower {

    private ArrayList<Flyable> observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        System.out.println("Tower says: " + flyable + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for(Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
