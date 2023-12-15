package christmas.enums;

import static christmas.enums.Menus.샴페인;

public enum Events {
    D_DAY_EVENT(100),
    WEEKDAY_EVENT(2_023),
    WEEKEND_EVENT(2_023),
    SPECIAL_EVENT(1_000),
    GIFT_EVENT(샴페인.getPrice());

    private final int discountPrice;

    Events(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
