package Storage.Interfaces;

import Storage.Classes.Storage;

import java.io.File;
import java.io.IOException;

public interface IObserver {
    void logTo(File destination) throws IOException;
}
