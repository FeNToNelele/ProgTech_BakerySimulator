package Storage.Interfaces;

import java.io.IOException;

public interface IObserver {
    void updateFields(int userid, int productid) throws IOException;
}
