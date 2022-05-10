package Storage.Classes;
import Storage.Interfaces.IObserver;

import java.io.*;

public class Logger {
    private static String filename;
    public static String getFilename() { return filename; }
    private static void setFilename(String value) { filename = value; }

    private static IObserver action;
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

    public static void log() throws IOException {
        action.logTo(getFile());
        System.out.println("Successfully logged to add.");
    }

    public Logger(String filename, IObserver logType)
    {
        this.setFilename(filename);
        action = logType;
    }
}
