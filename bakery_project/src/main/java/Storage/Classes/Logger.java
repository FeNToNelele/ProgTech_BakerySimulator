package Storage.Classes;

import Storage.Interfaces.IObserver;

import java.io.*;

public class Logger implements IObserver {
    public OutputStream outputStream;

    @Override
    public void log(int userId, String action, int productId) {
        createFile();
        try {
            FileWriter fw = new FileWriter("log.txt", true);
            fw.write(String.format("%s;%s;%s", userId, action, productId));
            fw.close();
            System.out.printf("logged: %s;%s;%s%n", userId, action, productId);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void createFile() {
        try {
            File log = new File("log.txt");
            if (log.createNewFile()) {
                System.out.println("File created: " + log.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("IOException occoured.");
            e.printStackTrace();
        }
    }
}
