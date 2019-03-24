package gl;

public class CustomException extends RuntimeException {
    CustomException() {
        super();
    }

    CustomException(String message) {
        super(message);
    }
}
