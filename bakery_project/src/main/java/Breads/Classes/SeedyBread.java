package Breads.Classes;

import Breads.ABread;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeedyBread extends ABread {

    protected SeedyBread(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return "Seedy bread";
    }

    @Override
    public int getPrice() {
        return 320;
    }

    @Override
    public List<String> getIngredients() {
        List<String> temp = new ArrayList<>();
        temp.addAll(super.getIngredients());
        temp.addAll(getSeeds());
        return temp;
    }

    public List<String> getSeeds() {
        return new ArrayList<>(Arrays.asList(
                "cereals", "oats", "sunflower seeds"
        ));
    }

    @Override
    public ABread clone() {
        return new SeedyBread(this.getId());
    }
}
