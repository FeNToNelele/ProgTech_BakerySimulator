package Breads;

import java.util.ArrayList;
import java.util.List;

public class FruitBread extends ABread {

    List<String>fruits;
    public List<String> getFruits() {
        List<String> temp = new ArrayList<>();
        temp.add("prunes");
        temp.add("driend peaches");
        temp.add("raisins");
        return temp;
    }

    @Override
    public List<String> getIngredients() {
        List<String>temp = new ArrayList<>();
        temp.add("flour");
        temp.add("egg");
        temp.add("water");
        temp.add("yeast");
        temp.add("butter");
        return temp;
    }
}
