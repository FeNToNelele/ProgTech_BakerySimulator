package Bakeries;

import Breads.ABread;
import Breads.Classes.SeedyBread;

import java.util.ArrayList;
import java.util.List;

public class SeedyBreadBakery extends ABakery {
    @Override
    public List<ABread> bake(int amount) {
        List<ABread> seedyBreads = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            seedyBreads.add(new SeedyBread(storage.getID()));
        }
        return  seedyBreads;
    }
}
