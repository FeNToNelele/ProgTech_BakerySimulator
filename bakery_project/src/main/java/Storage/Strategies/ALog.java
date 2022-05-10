package Storage.Strategies;

import Storage.Interfaces.IObserver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ALog implements IObserver {
    private int userId;

    public int getUserId() {
        return userId;
    }

    private void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    private void setProductId(int productId) {
        this.productId = productId;
    }

    public String getMethod() {
        return method;
    }

    private void setMethod(String method) {
        this.method = method;
    }

    private int productId;
    private String method;

    public ALog(int userId, int productId) {
        this.setUserId(userId);
        this.setProductId(productId);
    }

    public ALog(int userId, int productId, String method)
    {
        this.setUserId(userId);
        this.setProductId(productId);
        this.setMethod(method);
    }

    protected DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    protected LocalDateTime now;
    protected FileWriter myWriter;

    @Override
    public abstract void logTo(File destination) throws IOException;
}
