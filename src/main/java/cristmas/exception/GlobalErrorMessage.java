package cristmas.exception;

public enum GlobalErrorMessage {
    ;

    private final String message;

    GlobalErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
