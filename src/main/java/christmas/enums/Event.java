package christmas.enums;

import static christmas.enums.Gift.GIFT_EVENT_GIFT;

public enum Event {
    D_DAY_EVENT(100, "크리스마스 디데이 할인"),
    WEEKDAY_EVENT(2_023, "평일 할인"),
    WEEKEND_EVENT(2_023, "주말 할인"),
    SPECIAL_EVENT(1_000, "특별 할인"),
    GIFT_EVENT(GIFT_EVENT_GIFT.getMenu().getPrice(), "증정 이벤트");

    private final int benefitPrice;
    private final String name;

    Event(int benefitPrice, String name) {
        this.benefitPrice = benefitPrice;
        this.name = name;
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }

    public String getName() {
        return name;
    }
}
