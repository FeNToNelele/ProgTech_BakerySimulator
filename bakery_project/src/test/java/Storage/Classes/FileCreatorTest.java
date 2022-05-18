package Storage.Classes;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

class FileCreatorTest {
    FileCreator target = new FileCreator("unitTest.txt");

    @Test
    void createFileIsSuccessfulTest() {
        Exception actual = null;
        try {
            target.createFile();
        }
        catch (Exception e) {
            actual = e;
        }

        assertEquals(null, actual);
    }
}