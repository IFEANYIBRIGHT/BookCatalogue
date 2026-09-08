package africa.bookCatalog.exception;

public class SearchDoesNotMatchAnyBookException extends RuntimeException {
    public SearchDoesNotMatchAnyBookException(String message) {
        super(message);
    }
}
