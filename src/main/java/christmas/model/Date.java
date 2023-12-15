package christmas.model;

import christmas.enums.Days;
import christmas.utils.validator.DateValidator;

public class Date {
    int date;

    public Date(int date) {
        DateValidator.validate(date);
        this.date = date;
    }

    public boolean beforeChristmas() {
        return Days.isBeforeChristmas(date);
    }

    public boolean isWeekday() {
        return Days.isWeekday(date);
    }

    public boolean isWeekend() {
        return Days.isWeekend(date);
    }

    public boolean isSpecialDay() {
        return Days.isSpecialDay(date);
    }

    public int getDDayEventMultiplicand() {
        return date + 9;
    }
}
