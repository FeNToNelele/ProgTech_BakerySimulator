package Storage.Strategies;

import Storage.Classes.FileCreator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogAdd extends ALog {
    @Override
    public void log() {
        FileCreator fileCreator = new FileCreator("logAdd.txt");
        try {
            FileWriter myWriter = new FileWriter(fileCreator.getFilename(), true);
            myWriter.write(String.format("User %s added %s at %s\n", this.getUserid(), this.getProductid(), now = LocalDateTime.now()));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public LogAdd() {
        super("logAdd");
    }
}
