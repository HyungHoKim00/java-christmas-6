package christmas.utils;

public class InputValidator {
    private static final String POSITIVE_INTEGER_PATTERN = "^[0-9]*$";
    private static final String NOT_NUMERIC = "입력이 숫자가 아닙니다.";

    public static void validateNumeric(String input) {
        if (!input.matches(POSITIVE_INTEGER_PATTERN)) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }
}
