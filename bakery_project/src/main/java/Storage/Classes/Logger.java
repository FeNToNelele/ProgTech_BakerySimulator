package Storage.Classes;

import Storage.Files.LogAdd;
import Storage.Interfaces.IObserver;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;

public class Logger implements IObserver {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private OutputStream outputStream;

    public void logAdd(int userId, int productId) {
        LogAdd logAdd = new LogAdd("logAdd.txt");
        LocalDateTime now = LocalDateTime.now();
        try {
            FileWriter fw = new FileWriter(logAdd.getFile(), true);
            fw.write(String.format("Added new product at %s \tby user: %s\tProduct id: %s", dtf.format(now), userId, productId));
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
