package christmas.model;

import static christmas.enums.Events.D_DAY_EVENT;
import static christmas.enums.Events.WEEKDAY_EVENT;
import static christmas.enums.MenuTypes.DESSERT;

import christmas.enums.Events;
import java.util.EnumMap;
import java.util.Map;

public class Discount {
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
}
