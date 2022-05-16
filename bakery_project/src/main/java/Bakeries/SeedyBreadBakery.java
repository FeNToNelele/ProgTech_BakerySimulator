package Bakeries;

import Breads.ABread;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Strategies.LogAdd;

import java.io.IOException;

public class SeedyBreadBakery extends ABakery {
    public SeedyBreadBakery(ABread prototype, int userId) {
        super(prototype, userId, "seedy bread");
    }

    @Override
    public void bake(int amount) throws IOException, BreadAlreadyExistsException {
        for (int i = 0; i < amount; i++) {
            this.storage.addBread(prototype.clone());
            storage.notifyObservers(
                    storage.getObservers().stream()
                            .filter(x -> x instanceof LogAdd).toList(), userId, this.getBreadType()
            );
        }
    }
}
