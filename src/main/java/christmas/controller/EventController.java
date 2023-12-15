package christmas.controller;

import christmas.enums.Badge;
import christmas.model.Date;
import christmas.model.Discount;
import christmas.model.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;

    public EventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Date date = createValidatedDate();
        Orders orders = createValidatedOrder();
        Discount discount = new Discount(date, orders);
        printOutput(date, orders, discount);
    }

    private void printOutput(Date date, Orders orders, Discount discount) {
        outputView.printDate(date.createDetails());
        outputView.printOrderDetails(orders.createDetails());
        outputView.printTotalPrice(orders.calculateTotalPrice());
        outputView.printGiftEvent(discount.wonGiftEvent());
        outputView.printBenefitDetails(discount.createDetails());
        outputView.printBenefitPrice(discount.calculateTotalBenefit());
        outputView.printEstimatedPrice(orders.calculateTotalPrice() - discount.calculateTotalDiscount());
        outputView.printEventBadge(Badge.getBadgeByBenefitPrice(discount.calculateTotalBenefit()));
    }


    private Date createValidatedDate() {
        outputView.printDateRequestMessage();
        int date;
        while (true) {
            try {
                date = inputView.readDate();
                return new Date(date);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Orders createValidatedOrder() {
        outputView.printOrdersRequestMessage();
        List<String> orders;
        while (true) {
            try {
                orders = inputView.readOrders();
                return new Orders(orders);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
