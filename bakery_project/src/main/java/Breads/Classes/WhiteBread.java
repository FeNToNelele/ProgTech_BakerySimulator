package Breads.Classes;

import Breads.ABread;

import java.util.ArrayList;
import java.util.List;

public class WhiteBread extends ABread {
    public WhiteBread(int id) {
        super(id);
    }

    @Override
    public List<String> getIngredients() {
        List<String> temp = new ArrayList<>();
        temp.addAll(super.getIngredients());
        temp.add(getExtraFlour());
        return temp;
    }

    public String getExtraFlour() {
        return "extra white flour mix";
    }

    @Override
    public String getName() {
        return "White bread";
    }

    @Override
    public int getPrice() {
        return 280;
    }

    @Override
    public ABread clone() {
        return new WhiteBread(this.getId());
    }
}
