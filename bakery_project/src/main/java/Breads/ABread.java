package Breads;

import java.util.List;

public abstract class ABread implements Cloneable {
    private int id;
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    private String name;
    public abstract String getName();

    private int price;
    public int getPrice() { return this.price; }
    protected void setPrice(int price) throws Exception {
        if (price < 0) {
            throw new Exception("Price cannot be negative.");
        }
        this.price = price;
    }

    List<String> ingredients;
    public abstract List<String> getIngredients();

    @Override
    public abstract ABread clone();
}
