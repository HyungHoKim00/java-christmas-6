package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {
    private Discount discount;

    @BeforeEach
    void createDiscount() {
        Date date = new Date(3);
        Orders orders = new Orders(List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));
        discount = new Discount(date, orders);
    }

    @DisplayName("총혜택 금액 계산")
    @Test
    void calculateTotalBenefitPrice() {
        int result = discount.calculateTotalBenefit();
        int expected = 31_246;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("총할인 금액 계산")
    @Test
    void calculateTotalDiscountPrice() {
        int result = discount.calculateTotalDiscount();
        int expected = 6_246;

        assertThat(result).isEqualTo(expected);
    }
}
