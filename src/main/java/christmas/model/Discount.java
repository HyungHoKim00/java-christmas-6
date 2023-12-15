package christmas.model;

import static christmas.enums.Events.D_DAY_EVENT;
import static christmas.enums.Events.GIFT_EVENT;
import static christmas.enums.Events.SPECIAL_EVENT;
import static christmas.enums.Events.WEEKDAY_EVENT;
import static christmas.enums.Events.WEEKEND_EVENT;
import static christmas.enums.MenuTypes.DESSERT;
import static christmas.enums.MenuTypes.MAIN;

import christmas.enums.Events;
import java.util.EnumMap;
import java.util.Map;

public class Discount {
    private static final int WIN = 1;
    private static final int GIFT_EVENT_CONDITION = 120_000;
    private final Map<Events, Integer> discount;

    public Discount(Date date, Orders orders) {
        this.discount = new EnumMap<>(Events.class);
        int totalPrice = orders.calculateTotalPrice();
        putDDayDiscount(date);
        putWeekdayDiscount(date, orders);
        putWeekendDiscount(date, orders);
        putSpecialDayDiscount(date);
        putGiftEventDiscount(totalPrice);
    }

    private void putDDayDiscount(Date date) {
        if (date.beforeChristmas()) {
            discount.put(D_DAY_EVENT, date.getDDayEventMultiplicand());
        }
    }

    private void putWeekdayDiscount(Date date, Orders orders) {
        if (date.isWeekday()) {
            discount.put(WEEKDAY_EVENT, orders.getAmountOf(DESSERT));
        }
    }

    private void putWeekendDiscount(Date date, Orders orders) {
        if (date.isWeekend()) {
            discount.put(WEEKEND_EVENT, orders.getAmountOf(MAIN));
        }
    }

    private void putSpecialDayDiscount(Date date) {
        if (date.isSpecialDay()) {
            discount.put(SPECIAL_EVENT, WIN);
        }
    }

    private void putGiftEventDiscount(int totalPrice) {
        if (totalPrice > GIFT_EVENT_CONDITION) {
            discount.put(GIFT_EVENT, WIN);
        }
    }
}
