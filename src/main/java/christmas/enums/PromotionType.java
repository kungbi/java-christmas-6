package christmas.enums;

public enum PromotionType {
    D_DAY("크리스마스 디데이 할인"),
    WEEKDAYS("평일 할인"),
    SPECIAL("특별 할인"),
    GIVE_WAY("증정 이벤트");

    private final String description;

    PromotionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
