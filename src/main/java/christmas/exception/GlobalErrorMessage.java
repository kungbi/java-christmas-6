package christmas.exception;

public enum GlobalErrorMessage implements ExceptionMessage {
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DAY("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    GlobalErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
