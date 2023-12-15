package christmas.model;

import christmas.enums.Day;
import christmas.utils.validator.DateValidator;

public class Date {
    int date;

    public Date(int date) {
        DateValidator.validate(date);
        this.date = date;
    }

    public boolean beforeChristmas() {
        return Day.isBeforeChristmas(date);
    }

    public boolean isWeekday() {
        return Day.isWeekday(date);
    }

    public boolean isWeekend() {
        return Day.isWeekend(date);
    }

    public boolean isSpecialDay() {
        return Day.isSpecialDay(date);
    }

    public int getDDayEventMultiplicand() {
        return date + 9;
    }

    public String createDetails() {
        return "12월 " + date + "일";
    }
}
