package Storage.Strategies;

import Storage.Interfaces.IObserver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ALog implements IObserver {
    private int userid;
    private int productid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    @Override
    public void updateFields(int userid, int productid) throws IOException {
        this.setUserid(userid);
        this.setProductid(productid);
        log();
    }



    public abstract void log();
}
