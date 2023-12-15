package christmas.utils.validator;

import static christmas.utils.ErrMsg.INVALID_DATE;

public class DateValidator {
    private static final int MAX = 31;
    private static final int MIN = 1;

    public static void validate(int date) {
        if (outOfRange(date)) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    private static boolean outOfRange(int date) {
        return date > MAX || date < MIN;
    }
}
