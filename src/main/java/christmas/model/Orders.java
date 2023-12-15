package christmas.model;

import christmas.enums.MenuTypes;
import christmas.enums.Menus;
import christmas.utils.validator.OrdersValidator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Orders {
    private final Map<Menus, Integer> orders;

    public Orders(List<String> orders) {
        OrdersValidator.validate(orders);
        this.orders = new EnumMap<>(Menus.class);
        orders.forEach(order -> {
            String[] menuAndAmount = order.split("-");
            this.orders.put(Menus.getByName(menuAndAmount[0]), Integer.parseInt(menuAndAmount[1]));
        });
    }

    public int calculateTotalPrice() {
        AtomicInteger totalPrice = new AtomicInteger();
        orders.forEach((menu, amount) -> totalPrice.addAndGet(menu.getPrice() * amount));
        return totalPrice.get();
    }

    public int getAmountOf(MenuTypes menuTypes) {
        AtomicInteger totalAmount = new AtomicInteger(0);
        orders.keySet().stream()
                .filter(menu -> menu.getMenuType() == menuTypes)
                .forEach(menu -> totalAmount.addAndGet(orders.get(menu)));
        return totalAmount.get();
    }
}
