package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.utils.validator.OrdersValidator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrdersValidatorTest {
    @DisplayName("잘못된 주문에 대한 오류를 던진다")
    @ParameterizedTest(name = "{1}")
    @MethodSource("invalidOrders")
    void invalidOrderThrowsException(List<String> input, String reason) {
        assertThatThrownBy(() -> OrdersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidOrders() {
        return Stream.of(
                Arguments.of(List.of("초코스파게티-1"), "존재하지 않는 메뉴"),
                Arguments.of(List.of("바비큐립-0"), "수량 범위 초과"),
                Arguments.of(List.of("제로콜라-1"), "음료만 주문"),
                Arguments.of(List.of("바비큐립-1,바비큐립-2"), "중복된 주문"),
                Arguments.of(List.of("바비큐립-10,티본스테이크-2"), "총수량 범위 초과")
        );
    }
}
