package christmas.model;

import christmas.enums.Menu;
import christmas.enums.MenuType;
import christmas.utils.validator.OrdersValidator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Orders {
    private final Map<Menu, Integer> orders;

    public Orders(List<String> orders) {
        OrdersValidator.validate(orders);
        this.orders = new EnumMap<>(Menu.class);
        orders.forEach(order -> {
            String[] menuAndAmount = order.split("-");
            this.orders.put(Menu.getByName(menuAndAmount[0]), Integer.parseInt(menuAndAmount[1]));
        });
    }

    public int calculateTotalPrice() {
        AtomicInteger totalPrice = new AtomicInteger();
        orders.forEach((menu, amount) -> totalPrice.addAndGet(menu.getPrice() * amount));
        return totalPrice.get();
    }

    public int getAmountByMenuType(MenuType menuType) {
        AtomicInteger totalAmount = new AtomicInteger(0);
        orders.keySet().stream()
                .filter(menu -> menu.getMenuType() == menuType)
                .forEach(menu -> totalAmount.addAndGet(orders.get(menu)));
        return totalAmount.get();
    }

    public String createDetails() {
        StringBuilder details = new StringBuilder();
        orders.forEach((menu, amount) -> details.append(menu.name()).append(" ").append(amount).append("개\n"));
        return details.toString();
    }
}
