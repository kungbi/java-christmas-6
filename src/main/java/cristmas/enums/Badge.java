package cristmas.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Badge {
    STAR(5_000),
    TREE(10_000),
    SANTA(20_000);

    private final int discountAmount;

    Badge(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    static Optional<Badge> getBadgeByPaymentAmount(int discountAmount) {
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
