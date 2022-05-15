package Bakeries;


import Breads.ABread;
import Storage.Classes.Storage;

import java.io.IOException;
import java.util.List;

public abstract class ABakery {
    protected int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Storage storage = new Storage();

    public void setPrototype(ABread prototype) {
        this.prototype = prototype;
    }

    protected ABread prototype;
    public abstract List<ABread> bake(int amount) throws IOException;

    public ABakery(ABread prototype, int userId) {
        this.setPrototype(prototype);
        this.setUserId(userId);
    }
}
