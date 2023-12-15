package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputValidator;

public class InputView {
    public int readDate() {
        String date = Console.readLine();
        InputValidator.validateNumeric(date);
        return Integer.parseInt(date);
    }
}
