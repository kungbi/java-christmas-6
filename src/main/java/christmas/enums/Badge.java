package christmas.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Badge {
    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타");

    private final int discountAmount;
    private final String name;

    Badge(int discountAmount, String name) {
        this.discountAmount = discountAmount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<Badge> getBadgeByPaymentAmount(int discountAmount) {
        List<Badge> badges = Arrays.stream(Badge.values()).sorted().toList();

        Badge selectedBadge = null;
        for (Badge badge : badges) {
            if (badge.discountAmount <= discountAmount) {
                selectedBadge = badge;
            }
        }
        return Optional.ofNullable(selectedBadge);
    }
}
