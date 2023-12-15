package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputValidator;
import java.util.List;

public class InputView {
    public int readDate() {
        String input = Console.readLine();
        InputValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    public List<String> readMenus() {
        String input = Console.readLine();
        InputValidator.validateMenusFormat(input);
        return List.of(input.split(","));
    }
}
