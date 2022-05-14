package Storage.Interfaces;

import java.io.IOException;
import java.util.List;

public interface ISubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers(List<IObserver> observers, int userid, int productid) throws IOException;
}
