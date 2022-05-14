package Breads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ABread implements Cloneable {
    public ABread(int id, String name, int price) {
        this.id = id;
        this.setName(name);
        this.setPrice(price);
    }

    private int id;
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private int price;
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public abstract ABread clone();
}
