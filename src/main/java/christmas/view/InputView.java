package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.validator.InputValidator;
import java.util.List;

public class InputView {
    public int readDate() {
        String input = Console.readLine();
        InputValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    public List<String> readOrders() {
        String input = Console.readLine();
        InputValidator.validateOrderFormat(input);
        return List.of(input.split(","));
    }
}
