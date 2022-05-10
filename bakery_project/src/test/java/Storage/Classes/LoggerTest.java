package Storage.Classes;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

class LoggerTest {
    Logger logger = new Logger();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /*@Test
    public void hasToThrowIOExceptionTest() {
        logger.log(1, "add", 3);
        expectedException.expect(IOException.class);
    }*/

}