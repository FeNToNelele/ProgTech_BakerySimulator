package Storage.Classes;

import Breads.FruitBread;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    Storage target = new Storage();

    @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addBread_addSameElementsTest() {
        FruitBread sampleBread = new FruitBread();

        target.addBread(sampleBread);
        target.addBread(sampleBread);

        expectedException.expect(BreadAlreadyExistsException.class);
    }
}