package Storage.Interfaces;

import Storage.Classes.Storage;

public interface IObserver {
    void log(int userId, String action, int productId);
}
