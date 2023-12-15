package christmas.utils.validator;

import static christmas.enums.MenuType.DRINK;

import christmas.enums.Menu;
import christmas.utils.ErrMsg;
import java.util.ArrayList;
import java.util.List;

public class OrdersValidator {
    private static final int MAX = 20;
    private static final int MIN = 1;

    public static void validate(List<String> orders) {
        orders.forEach(order -> {
            if (invalidOrder(order)) {
                throw new IllegalArgumentException(ErrMsg.INVALID_ORDER);
            }
        });
        if (invalidOrders(orders)) {
            throw new IllegalArgumentException(ErrMsg.INVALID_ORDER);
        }
    }


    private static boolean invalidOrder(String order) {
        String[] menuAndAmount = order.split("-");
        return menuNotExist(menuAndAmount[0])
                || amountOutOfRange(Integer.parseInt(menuAndAmount[1]));
    }

    private static boolean invalidOrders(List<String> orders) {
        return ordersAllDrink(orders)
                || ordersDuplicated(orders)
                || totalAmountOutOfRange(orders);
    }


    private static boolean menuNotExist(String menuName) {
        return Menu.invalidMenu(menuName);
    }

    private static boolean amountOutOfRange(int amount) {
        return amount < MIN;
    }

    private static boolean ordersAllDrink(List<String> orders) {
        return orders.stream().allMatch(order -> Menu.getMenuTypeByName(order.split("-")[0]) == DRINK);
    }

    private static boolean ordersDuplicated(List<String> orders) {
        List<String> menus = new ArrayList<>();
        orders.forEach(order -> menus.add(order.split("-")[0]));
        return menus.size() != menus.stream().distinct().toList().size();
    }

    private static boolean totalAmountOutOfRange(List<String> orders) {
        int totalAmount = 0;
        for (String order : orders) {
            totalAmount += Integer.parseInt(order.split("-")[1]);
            if (totalAmount > MAX) {
                return true;
            }
        }
        return false;
    }
}
