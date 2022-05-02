package Bakeries;

import Breads.ABread;
import Breads.Classes.FruitBread;

import java.util.ArrayList;
import java.util.List;

public class FruitBreadBakery extends ABakery {
    @Override
    public List<ABread> bake(int amount) {
        List<ABread> fruitBreads = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            fruitBreads.add(new FruitBread(storage.getID()));
        }
        return fruitBreads;
    }
}
