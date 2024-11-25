package christmas.enums;

public enum DayOfWeek {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    public static final DayOfWeek START_OF_WEEK = FRIDAY;
    private final int order;


    DayOfWeek(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    private static DayOfWeek getDayOfWeekByOrder(int order) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.order == order) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid day of week: " + order);
    }

    public static DayOfWeek getDayOfWeekAsDate(int day) {
        int order = (START_OF_WEEK.getOrder() + day - 1) / 7;
        return getDayOfWeekByOrder(order);
    }
}
