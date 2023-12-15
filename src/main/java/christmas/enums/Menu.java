package christmas.enums;

import static christmas.enums.MenuType.APPETIZER;
import static christmas.enums.MenuType.DESSERT;
import static christmas.enums.MenuType.DRINK;
import static christmas.enums.MenuType.MAIN;

import java.util.Arrays;

public enum Menu {
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

    private final MenuType menuType;
    private final int price;

    Menu(MenuType menuType, int price) {
        this.menuType = menuType;
        this.price = price;
    }

    public static Menu getByName(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.name().equals(menuName))
                .findFirst()
                .orElseThrow();
    }

    public int getPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public static boolean invalidMenu(String menuName) {
        return Arrays.stream(values())
                .noneMatch(menu -> menu.name().equals(menuName));
    }

    public static MenuType getMenuTypeByName(String menuName) {
        return getByName(menuName).menuType;
    }
}
