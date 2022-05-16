package Bakeries;

import Breads.ABread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;
import Storage.Strategies.LogAdd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeedyBreadBakery extends ABakery {
    public SeedyBreadBakery(ABread prototype, int userId) {
        super(prototype, userId, "seedy bread");
    }

    @Override
    public List<ABread> bake(int amount) throws IOException {
        List<ABread> breads = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            breads.add(new SeedyBread());
            storage.notifyObservers(
                    storage.getObservers().stream()
                            .filter(x -> x instanceof LogAdd).toList(), userId, this.getBreadType()
            );
        }
        return breads;
    }
}
