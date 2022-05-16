package Storage.Strategies;

import Storage.Interfaces.IObserver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ALog implements IObserver {
    private int userid;

    private String breadType;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    @Override
    public void updateFields(int userid, String breadType) throws IOException {
        this.setUserid(userid);
        this.setBreadType(breadType);
        log();
    }



    public abstract void log();
}
