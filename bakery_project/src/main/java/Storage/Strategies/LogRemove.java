package Storage.Strategies;

import Storage.Classes.FileCreator;
import Storage.Interfaces.IObserver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogRemove extends ALog {

    @Override
    public void log() {
        FileCreator fileCreator = new FileCreator("logRemove.txt");
        try {
            FileWriter myWriter = new FileWriter(fileCreator.getFilename(), true);
            myWriter.write(String.format("%s removed %s from the list at %s", this.getUserid(), this.getProductid(), now = LocalDateTime.now()));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
