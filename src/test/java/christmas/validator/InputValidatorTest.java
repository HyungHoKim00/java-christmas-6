package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.utils.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @DisplayName("숫자가 아니면 예외를 던진다")
    @Test
    void notNumericThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateNumeric("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 형식이 맞지 않으면 예외를 던진다")
    @Test
    void InvalidOrderFormatThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateOrderFormat("a-1-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
