package oo.observer;

import java.util.ArrayList;
import java.util.List;

public interface Publisher {
    List<Listener> listeners = new ArrayList<>();

    void addListener(Listener listener);

    void removeListener(Listener listener);

    void notifyListeners(Event event);
}
