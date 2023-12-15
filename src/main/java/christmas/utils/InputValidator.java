package christmas.utils;

import java.util.List;

public class InputValidator {
    private static final String POSITIVE_INTEGER_PATTERN = "^[0-9]*$";

    public static void validateNumeric(String input) {
        if (notNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE);
        }
    }

    public static void validateOrderFormat(String input) {
        List<String> orders = List.of(input.split(","));
        orders.forEach(order -> {
            if (notNumeric(order.split("-")[1])) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER);
            }
            ;
        });
    }


    private static boolean notNumeric(String input) {
        return !input.matches(POSITIVE_INTEGER_PATTERN);
    }
}
