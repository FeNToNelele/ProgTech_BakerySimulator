package Storage.Strategies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogError extends ALog {
    public LogError(int userId, int productId, String method) {
        super(userId, productId, method);
    }

    @Override
    public void logTo(File destination) throws IOException {
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();
        myWriter = new FileWriter(destination, true);
        myWriter.write(String.format("%s has an error in method %s at %s", this.getUserId(), this.getMethod(), now));
        myWriter.close();
    }
}
