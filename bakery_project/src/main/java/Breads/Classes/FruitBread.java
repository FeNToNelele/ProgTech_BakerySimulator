package Breads.Classes;

import Breads.ABread;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBread extends ABread {

    public FruitBread(int id) {
        super(id);
    }

    public List<String> getFruits() {
        return new ArrayList<>(Arrays.asList(
                "prunes", "dried peaches", "raisins"
        ));
    }

    @Override
    public String getName() {
        return "Fruit bread";
    }

    @Override
    public int getPrice() {
        return 300;
    }

    @Override
    public List<String> getIngredients() {
        List<String> temp = new ArrayList<>();
        temp.addAll(super.getIngredients());
        temp.addAll(getFruits());
        return temp;
    }

    @Override
    public ABread clone() {
        return new FruitBread(this.getId());
    }
}
