package Storage.Interfaces;

public interface IObserver {
    void log(int userId, String action, int productId);
}
