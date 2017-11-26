package fr._42.avaj_launcher.weather;

import fr._42.avaj_launcher.aircraft.Flyable;
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

    }

    public void unregister() {

    }

    protected void conditionsChanged() {

    }
}
