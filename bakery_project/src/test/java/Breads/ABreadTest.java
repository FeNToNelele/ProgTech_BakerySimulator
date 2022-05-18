package Breads;

import Breads.Classes.FruitBread;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ABreadTest {
    ABread target;


    @Test
    void prototypeIdInrementsAutomaticallyTest() {
        target = new FruitBread();
        int actual = 0;
        actual = target.getId();
        actual = target.getId();

        int expected = 2;

        assertEquals(expected, actual);
    }
}