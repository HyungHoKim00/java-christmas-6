package christmas.model;

import static christmas.enums.MenuType.DESSERT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdersTest {
    private Orders orders;

    @BeforeEach
    void createOrders() {
        orders = new Orders(List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));
    }

    @DisplayName("총주문 금액 계산")
    @Test
    void calculateTotalPrice() {
        int result = orders.calculateTotalPrice();
        int expected = 142_000;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("메뉴 종류에 따른 갯수 가져오기")
    @Test
    void getAmountOfMenuType() {
        int result = orders.getAmountByMenuType(DESSERT);
        int expected = 2;

        assertThat(result).isEqualTo(expected);
    }
}
