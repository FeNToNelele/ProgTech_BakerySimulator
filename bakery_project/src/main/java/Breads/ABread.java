package Breads;

import Breads.Interfaces.IIngredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ABread implements Cloneable, IIngredients {
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

    List<String> ingredients;

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(Arrays.asList(
                "flour", "egg", "water", "yeast", "butter"
        ));
    }

    @Override
    public abstract ABread clone();
}
