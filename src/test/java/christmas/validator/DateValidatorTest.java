package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.utils.validator.DateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateValidatorTest {
    @DisplayName("잘못된 날짜에 대해 오류를 던진다")
    @Test
    void invalidDateThrowsException() {
        assertThatThrownBy(() -> DateValidator.validate(32))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
