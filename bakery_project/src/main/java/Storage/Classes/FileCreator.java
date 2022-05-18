package Storage.Classes;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileCreator(String filename) {
        this.setFilename(filename);
        createFile();
    }

    public void createFile() {
        File logFile = new File(this.getFilename());
        try {
            logFile.createNewFile();
        }
        catch (IOException e) {
            System.out.println("File could not be created due to IOException.");
        }
    }
}
