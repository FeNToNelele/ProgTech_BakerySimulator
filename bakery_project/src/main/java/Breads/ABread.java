package Breads;

import java.util.List;

public abstract class ABread {
    private int id;
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    private String name;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    private int price;
    public int getPrice() { return this.price; }
    public void setPrice(int price) { this.price = price; }

    List<String> ingredients;
    public abstract List<String>getIngredients();

}
