package christmas.model;

import christmas.enums.Menus;
import christmas.utils.validator.OrdersValidator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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
}
