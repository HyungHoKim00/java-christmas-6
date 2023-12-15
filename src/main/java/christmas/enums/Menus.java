package christmas.enums;

import static christmas.enums.MenuTypes.APPETIZER;
import static christmas.enums.MenuTypes.DESSERT;
import static christmas.enums.MenuTypes.DRINK;
import static christmas.enums.MenuTypes.MAIN;

public enum Menus {
    양송이수프(APPETIZER, 6_000),
    타파스(APPETIZER, 5_500),
    시저샐러드(APPETIZER, 8_000),
    티본스테이크(MAIN, 55_000),
    바비큐립(MAIN, 54_000),
    해산물파스타(MAIN, 35_000),
    크리스마스파스타(MAIN, 25_000),
    초코케이크(DESSERT, 15_000),
    아이스크림(DESSERT, 5_000),
    제로콜라(DRINK, 3_000),
    레드와인(DRINK, 60_000),
    샴페인(DRINK, 25_000);

    private final MenuTypes menuTypes;
    private final int price;

    Menus(MenuTypes menuTypes, int price) {
        this.menuTypes = menuTypes;
        this.price = price;
    }
}
