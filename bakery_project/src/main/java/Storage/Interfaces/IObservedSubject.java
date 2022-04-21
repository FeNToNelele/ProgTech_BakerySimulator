package Storage.Interfaces;

public interface IObservedSubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}
