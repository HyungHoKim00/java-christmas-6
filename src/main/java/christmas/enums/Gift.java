package christmas.enums;

import static christmas.enums.Menu.샴페인;

public enum Gift {
    GIFT_EVENT_GIFT(샴페인);

    private Menu menu;

    Gift(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
}
