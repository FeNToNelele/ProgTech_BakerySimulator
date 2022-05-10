package Storage.Strategies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogAdd extends ALog {

    public LogAdd(int userId, int productId) {
        super(userId, productId);
    }

    public void logTo(File destination) throws IOException {
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();
        myWriter = new FileWriter(destination, true);
        myWriter.write(String.format("%s added %s at %s", this.getUserId(), this.getProductId(), now));
        myWriter.close();
    }
}
