package Storage.Classes;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.setFilename(filename);
    }

    public FileCreator(String filename) {
        this.setFilename(filename);
        createFile();
    }

    public void createFile() {
        try {
            File myObj = new File(this.getFilename());
            if (myObj.createNewFile()) {
                System.out.println("File created: " + this.getFilename());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
