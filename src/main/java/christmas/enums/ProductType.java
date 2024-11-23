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

    public static ProductType findByKorean(String korean) {
        for (ProductType type : ProductType.values()) {
            if (type.getKorean().equals(korean)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown product type: " + korean);
    }
}
