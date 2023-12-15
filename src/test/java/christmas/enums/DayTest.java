package christmas.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayTest {
    @DisplayName("크리스마스 전인지 여부 반환")
    @Test
    void checkIfBeforeChristmas() {
        int date = 24;

        boolean result = Day.isBeforeChristmas(date);
        boolean expected = true;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("주중인지 여부 반환")
    @Test
    void checkIfWeekday() {
        int date = 24;

        boolean result = Day.isWeekday(date);
        boolean expected = true;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("주말인지 여부 반환")
    @Test
    void checkIfWeekend() {
        int date = 24;

        boolean result = Day.isWeekend(date);
        boolean expected = false;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("특별한 날인지 여부 반환")
    @Test
    void checkIfSpecialDay() {
        int date = 24;

        boolean result = Day.isSpecialDay(date);
        boolean expected = true;

        assertThat(result).isEqualTo(expected);
    }
}
