package weather;

import aircraft.Flyable;
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
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {

    }
}