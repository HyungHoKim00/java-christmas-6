package christmas.model;

import static christmas.enums.Event.D_DAY_EVENT;
import static christmas.enums.Event.GIFT_EVENT;
import static christmas.enums.Event.SPECIAL_EVENT;
import static christmas.enums.Event.WEEKDAY_EVENT;
import static christmas.enums.Event.WEEKEND_EVENT;
import static christmas.enums.Gift.GIFT_EVENT_GIFT;
import static christmas.enums.MenuType.DESSERT;
import static christmas.enums.MenuType.MAIN;
import static christmas.utils.Format.MONEY_FORMAT;

import christmas.enums.Event;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Discount {
    private static final int WIN = 1;
    private static final int GIFT_EVENT_CONDITION = 120_000;
    private final Map<Event, Integer> discount;

    public Discount(Date date, Orders orders) {
        this.discount = new EnumMap<>(Event.class);
        int totalPrice = orders.calculateTotalPrice();
        putDDayDiscount(date);
        putWeekdayDiscount(date, orders);
        putWeekendDiscount(date, orders);
        putSpecialDayDiscount(date);
        putGiftEventDiscount(totalPrice);
        discount.entrySet().removeIf(entry -> entry.getValue() == 0);
    }

    public int calculateTotalBenefit() {
        AtomicInteger totalBenefit = new AtomicInteger();
        discount.forEach((event, multiplicand) -> totalBenefit.addAndGet(event.getBenefitPrice() * multiplicand));
        return totalBenefit.get();
    }

    public int calculateTotalDiscount() {
        AtomicInteger totalDiscount = new AtomicInteger();
        discount.keySet().stream()
                .filter(event -> event != GIFT_EVENT)
                .forEach(event -> totalDiscount.addAndGet(event.getBenefitPrice() * discount.get(event)));
        return totalDiscount.get();
    }

    public String wonGiftEvent() {
        if (discount.containsKey(GIFT_EVENT)) {
            return GIFT_EVENT_GIFT.getMenu().name() + " " + WIN + "개";
        }
        return "없음";
    }

    public String createDetails() {
        StringBuilder details = new StringBuilder();
        discount.forEach((event, amount) -> details.append(event.getName()).append(": -")
                .append(MONEY_FORMAT.format((long) amount * event.getBenefitPrice()))
                .append("원\n"));
        return details.toString();
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
