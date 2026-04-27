package interfaces;

import java.util.List;
import java.util.ArrayList;

public interface Observable {
    List<Observer> observers = new ArrayList<>();

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String news);
}
