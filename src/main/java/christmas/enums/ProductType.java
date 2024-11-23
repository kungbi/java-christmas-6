package christmas.enums;

public enum ProductType {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESERT("디저트"),
    DRINK("음료");

    private final String korean;

    ProductType(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
