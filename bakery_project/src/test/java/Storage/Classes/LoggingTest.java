package Storage.Classes;

import Storage.Strategies.ALog;
import Storage.Strategies.LogAdd;
import Storage.Strategies.LogError;
import Storage.Strategies.LogRemove;
import com.mysql.cj.log.Log;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

class LoggingTest {
    ALog target = new LogAdd();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void logAddCannotThrowExceptionTest() {
        Exception actual = null;
        target = new LogAdd();
        target.setUserid(1);
        target.setBreadType("Test bread");
        try {
            target.log();
        }
        catch (Exception ex) {
            actual = ex;
        }

        assertEquals(null, actual);
    }

    @Test
    public void logErrorCannotThrowExceptionTest() {
        Exception actual = null;
        target = new LogError();
        target.setUserid(1);
        target.setBreadType("Test bread");
        try {
            target.log();
        }
        catch (Exception ex) {
            actual = ex;
        }

        assertEquals(null, actual);
    }

    @Test
    public void logRemoveCannotThrowExceptionTest() {
        Exception actual = null;
        target = new LogRemove();
        target.setUserid(1);
        target.setBreadType("Test bread");
        try {
            target.log();
        }
        catch (Exception ex) {
            actual = ex;
        }

        assertEquals(null, actual);
    }
}