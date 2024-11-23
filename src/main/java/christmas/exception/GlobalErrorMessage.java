package christmas.exception;

public enum GlobalErrorMessage implements ExceptionMessage {
    ;

    private final String message;

    GlobalErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
