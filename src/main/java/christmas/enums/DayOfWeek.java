package christmas.enums;

public enum DayOfWeek {
    MONDAY(0, "월"),
    TUESDAY(1, "화"),
    WEDNESDAY(2, "수"),
    THURSDAY(3, "목"),
    FRIDAY(4, "금"),
    SATURDAY(5, "토"),
    SUNDAY(6, "일");

    private final int order;
    private final String korean;

    DayOfWeek(int order, String korean) {
        this.order = order;
        this.korean = korean;
    }

    public int getOrder() {
        return order;
    }

    public String getKorean() {
        return korean;
    }

    public static DayOfWeek fromOrder(int order) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.getOrder() == order) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid order: " + order);
    }

    public static DayOfWeek fromDay(int day) {
        return fromOrder((day + 3) % 7);
    }
}
