package Bakeries;

import Breads.ABread;
import Breads.Classes.FruitBread;
import Breads.Classes.WhiteBread;
import Storage.Strategies.LogAdd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitBreadBakery extends ABakery {
    public FruitBreadBakery(ABread prototype, int userId) {
        super(prototype, userId, "fruit bread");
    }

    @Override
    public List<ABread> bake(int amount) throws IOException {
        List<ABread> breads = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            breads.add(prototype);
            storage.notifyObservers(
                    storage.getObservers().stream()
                            .filter(x -> x instanceof LogAdd).toList(), userId, this.getBreadType()
            );
        }
        return breads;
    }
}
