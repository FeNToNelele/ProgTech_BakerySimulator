package Breads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ABread implements Cloneable {
    public ABread(int id) {
        this.id = id;
    }

    private int id;
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    private String name;
    public abstract String getName();

    private int price;
    public abstract int getPrice();

    @Override
    public abstract ABread clone();
}
