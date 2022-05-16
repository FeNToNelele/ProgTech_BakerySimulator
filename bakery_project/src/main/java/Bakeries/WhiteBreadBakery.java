package Bakeries;

import Breads.ABread;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Strategies.LogAdd;

import java.io.IOException;

public class WhiteBreadBakery extends ABakery {
    public WhiteBreadBakery(ABread prototype, int userId) {
        super(prototype, userId, "white bread");
    }

    @Override
    public void bake(int amount) throws IOException, BreadAlreadyExistsException {
        for (int i = 0; i < amount; i++) {
            storage.addBread(prototype.clone());
            storage.notifyObservers(
                    storage.getObservers().stream()
                            .filter(x -> x instanceof LogAdd).toList(), userId, this.getBreadType()
            );
        }
    }
}
