package Storage.Files;
import java.io.*;

public class LogAdd {
    private static String filename;
    public static String getFilename() { return filename; }
    private static void setFilename(String value) { filename = value; }

    private static File file;

    public static File getFile() {
        if (file == null) {
            file = new File(getFilename());
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public LogAdd(String filename) {
        this.setFilename(filename);
    }
}
