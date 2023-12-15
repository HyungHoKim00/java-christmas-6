package christmas.enums;

import static christmas.enums.Badge.별;
import static christmas.enums.Badge.산타;
import static christmas.enums.Badge.없음;
import static christmas.enums.Badge.트리;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BadgeTest {
    @DisplayName("혜택 금액에 따라 뱃지 반환")
    @ParameterizedTest(name = "뱃지: {2}")
    @MethodSource("benefitPriceInput")
    void selectBadgeByBenefitPrice(int benefitMoney, Badge expected, String name) {
        Badge result = Badge.getBadgeByBenefitPrice(benefitMoney);

        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> benefitPriceInput() {
        return Stream.of(
                Arguments.of(25_000, 산타, 산타.name()),
                Arguments.of(15_000, 트리, 트리.name()),
                Arguments.of(7_500, 별, 별.name()),
                Arguments.of(2_500, 없음, 없음.name())
        );
    }
}
