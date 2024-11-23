package christmas.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String korean;
    private final int discountAmount;

    Badge(String korean, int amountPurchased) {
        this.korean = korean;
        this.discountAmount = amountPurchased;
    }

    public String getKorean() {
        return korean;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public static Optional<Badge> getBadgeByDiscountAmount(int amountPurchased) {
        List<Badge> badges = Arrays.stream(Badge.values()).sorted(((o1, o2) -> o2.discountAmount - o1.discountAmount))
                .toList();
        for (Badge badge : badges) {
            if (badge.discountAmount <= amountPurchased) {
                return Optional.of(badge);
            }
        }
        return Optional.empty();
    }
}
