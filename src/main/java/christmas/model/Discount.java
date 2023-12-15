package christmas.model;

import static christmas.enums.Events.D_DAY_EVENT;

import christmas.enums.Events;
import java.util.EnumMap;
import java.util.Map;

public class Discount {
    private final Map<Events, Integer> discount;

    public Discount(Date date, Orders orders) {
        this.discount = new EnumMap<>(Events.class);
        int totalPrice = orders.calculateTotalPrice();
        putDDayDiscount(date);
        putWeekdayDiscount(date);
        putWeekendDiscount(date);
        putSpecialDayDiscount(date);
        putGiftEventDiscount(date);
    }

    private void putDDayDiscount(Date date) {
        if (date.beforeChristmas()) {
            discount.put(D_DAY_EVENT, date.getDDayEventMultiplicand());
        }
    }
}
