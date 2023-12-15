package christmas.utils.validator;

import christmas.utils.ErrMsg;
import java.util.List;

public class InputValidator {
    private static final String POSITIVE_INTEGER_PATTERN = "^[0-9]*$";

    public static void validateNumeric(String input) {
        if (notNumeric(input)) {
            throw new IllegalArgumentException(ErrMsg.INVALID_DATE);
        }
    }

    public static void validateOrderFormat(String input) {
        List<String> orders = List.of(input.split(","));
        orders.forEach(order -> {
            if (invalidOrderFormat(order)) {
                throw new IllegalArgumentException(ErrMsg.INVALID_ORDER);
            }
        });
    }

    private static boolean invalidOrderFormat(String order) {
        String[] menuAndAmount = order.split("-");
        return menuAndAmount.length != 2 || notNumeric(menuAndAmount[1]);
    }

    private static boolean notNumeric(String input) {
        return !input.matches(POSITIVE_INTEGER_PATTERN);
    }
}
