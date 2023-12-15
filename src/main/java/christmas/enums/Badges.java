package christmas.enums;

import java.util.Arrays;

public enum Badges {
    산타(20_000),
    트리(10_000),
    별(5_000),
    없음(0);

    private final int leastCondition;

    Badges(int leastCondition) {
        this.leastCondition = leastCondition;
    }

    public static Badges getBadgeByBenefitPrice(int benefitPrice) {
        return Arrays.stream(values())
                .filter(badge -> badge.leastCondition < benefitPrice)
                .findFirst()
                .orElse(없음);
    }
}
