package Bakeries;

import Breads.ABread;
import Breads.Classes.WhiteBread;
import Storage.Strategies.LogAdd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WhiteBreadBakery extends ABakery {
    public WhiteBreadBakery(ABread prototype, int userId) {
        super(prototype, userId);
    }

    @Override
    public List<ABread> bake(int amount) throws IOException {
        List<ABread> breads = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            breads.add(new WhiteBread());
            storage.notifyObservers(
                    storage.getObservers().stream()
                            .filter(x -> x instanceof LogAdd).toList(), userId, prototype.getId()
            );
        }
        return breads;
    }
}
