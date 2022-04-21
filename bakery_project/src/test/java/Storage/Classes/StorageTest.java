package Storage.Classes;

import Breads.FruitBread;
import Storage.Exceptions.BreadAlreadyExistsException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class StorageTest {
    Storage target = new Storage();

    @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addBread_addSameElementsTest() throws BreadAlreadyExistsException {
        FruitBread sampleBread = new FruitBread(1, 300,
                new A);

        target.addBread(sampleBread);
        target.addBread(sampleBread);

        expectedException.expect(BreadAlreadyExistsException.class);
    }
}