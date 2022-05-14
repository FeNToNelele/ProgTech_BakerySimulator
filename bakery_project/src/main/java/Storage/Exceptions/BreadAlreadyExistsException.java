package Storage.Exceptions;

public class BreadAlreadyExistsException extends Throwable {
    public BreadAlreadyExistsException() {
        super("Bread already exists.");
    }
}
