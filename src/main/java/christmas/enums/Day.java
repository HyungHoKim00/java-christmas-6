package christmas.enums;

import java.util.List;

public enum Day {
    CHRISTMAS(List.of(25)),
    WEEKEND(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    SPECIAL(List.of(3, 10, 17, 24, 25, 31));

    private final List<Integer> days;

    Day(List<Integer> days) {
        this.days = days;
    }

    public static boolean isBeforeChristmas(int date) {
        return date <= CHRISTMAS.days.get(0);
    }

    public static boolean isWeekday(int date) {
        return !WEEKEND.days.contains(date);
    }

    public static boolean isWeekend(int date) {
        return WEEKEND.days.contains(date);
    }

    public static boolean isSpecialDay(int date) {
        return SPECIAL.days.contains(date);
    }
}
