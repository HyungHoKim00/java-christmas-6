package christmas.model;

import christmas.utils.validator.DateValidator;

public class Date {
    int date;

    public Date(int date) {
        DateValidator.validate(date);
        this.date = date;
    }
}
