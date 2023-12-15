package christmas.enums;

import java.util.Arrays;

public enum Badge {
    산타(20_000),
    트리(10_000),
    별(5_000),
    없음(0);

    private final int leastCondition;

    Badge(int leastCondition) {
        this.leastCondition = leastCondition;
    }

    public static Badge getBadgeByBenefitPrice(int benefitPrice) {
        return Arrays.stream(values())
                .filter(badge -> badge.leastCondition < benefitPrice)
                .findFirst()
                .orElse(없음);
    }
}
