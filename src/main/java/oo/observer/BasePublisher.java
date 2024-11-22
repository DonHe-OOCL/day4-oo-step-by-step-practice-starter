package oo.observer;

public abstract class BasePublisher implements Publisher {

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyListeners(Event event) {
        listeners.forEach(listener -> listener.update(event));
    }
}
