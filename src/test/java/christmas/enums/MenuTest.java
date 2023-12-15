package christmas.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("존재하지 않는 메뉴를 입력하면 참 반환")
    @Test
    void checkInvalidMenu() {
        String menuName = "참치김치찌개";

        boolean result = Menu.invalidMenu(menuName);
        boolean expected = true;

        assertThat(result).isEqualTo(expected);
    }
}
