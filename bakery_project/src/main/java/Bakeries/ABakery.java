package Bakeries;


import Breads.ABread;
import Storage.Classes.Storage;
import Storage.Exceptions.BreadAlreadyExistsException;

import java.io.IOException;

public abstract class ABakery {
    public Storage storage = new Storage();
    protected int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    protected String breadType;

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setPrototype(ABread prototype) {
        this.prototype = prototype;
    }

    protected ABread prototype;
    public abstract void bake(int amount) throws IOException, BreadAlreadyExistsException;

    public ABakery(ABread prototype, int userId, String breadType) {
        this.setPrototype(prototype);
        this.setUserId(userId);
        this.setBreadType(breadType);
    }
}
