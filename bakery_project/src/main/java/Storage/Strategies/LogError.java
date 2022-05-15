package Storage.Strategies;

import Storage.Classes.FileCreator;
import Storage.Interfaces.IObserver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogError extends ALog {
    @Override
    public void log() {
        FileCreator fileCreator = new FileCreator("logError.txt");
        try {
            FileWriter myWriter = new FileWriter(fileCreator.getFilename(), true);
            myWriter.write(String.format("User %s got into an error at %s", this.getUserid(), now = LocalDateTime.now()));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
    }

    public LogError() {
        super("logError");
    }
}
