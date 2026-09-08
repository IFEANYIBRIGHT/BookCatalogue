package africa.bookCatalog.exception;

public class FieldCannotBeEmpty extends RuntimeException {
    public FieldCannotBeEmpty(String message) {
        super(message);
    }
}
