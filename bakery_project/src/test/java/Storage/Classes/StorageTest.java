package Storage.Classes;

import Breads.Classes.FruitBread;
import Storage.Exceptions.BreadAlreadyExistsException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

class StorageTest {
    Storage target = new Storage();

    @Test
    public void addBread_addSameElementsTest() throws BreadAlreadyExistsException, IOException {
        FruitBread sampleBread = new FruitBread(1);

        target.addBread(sampleBread);

        BreadAlreadyExistsException thrown = assertThrows(
                BreadAlreadyExistsException.class,
                () -> target.addBread(sampleBread),
                "Bread already exists."
        );

        assertTrue(thrown.getMessage().contains("exists"));
    }
}