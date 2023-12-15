package christmas.enums;

import java.util.List;

public enum Days {
    CHRISTMAS(List.of(25)),
    WEEKEND(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    SPECIAL(List.of(3, 10, 17, 24, 25, 31));

    private final List<Integer> days;

    Days(List<Integer> days) {
        this.days = days;
    }
}
