package Storage.Strategies;

import Storage.Classes.FileCreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LogAdd extends ALog {
    @Override
    public void log() {
        FileCreator fileCreator = new FileCreator("logAdd.txt");
        try {
            FileWriter myWriter = new FileWriter(fileCreator.getFilename(), true);
            myWriter.write(String.format("User %s baked a new %s at %s\n", this.getUserid(), this.getBreadType(), now = LocalDateTime.now()));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            try {
                fileCreator.setFilename("logError.txt");
                FileWriter myWriter = new FileWriter(fileCreator.getFilename(), true);
                myWriter.write(String.format("An error occoured while logging addition at %s\n", now = LocalDateTime.now()));
                myWriter.close();
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/bakery";
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            File logFile = new File("logAdd.txt");
            Scanner logReader = new Scanner(logFile);
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE from usagelog");
            while (logReader.hasNextLine()) {
                String[] data = logReader.nextLine().split(" ");
                st.executeUpdate("INSERT INTO usagelog " +
                        "VALUES ("+data[1]+", '"+data[5]+" "+data[6]+"', '"+data[8]+"')");
            }
            logReader.close();
        }
        catch (Exception ex){
            System.out.println("An error occoured while exporting data to database.");
            try {
                fileCreator.setFilename("logError.txt");
                FileWriter myWriter = new FileWriter(fileCreator.getFilename(), true);
                myWriter.write(String.format("An error occoured while exporting data to database at %s\n", now = LocalDateTime.now()));
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
