package christmas.view;

import static christmas.utils.Format.MONEY_FORMAT;

import christmas.enums.Badge;

public class OutputView {
    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public void printDateRequestMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void printOrdersRequestMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printDate(String details) {
        System.out.println(details + "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printOrderDetails(String details) {
        System.out.println();
        printTitle("주문 메뉴");
        System.out.print(details);
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println();
        printTitle("할인 전 총주문 금액");
        System.out.println(MONEY_FORMAT.format(totalPrice) + "원");
    }

    public void printGiftEvent(String wonGiftEvent) {
        System.out.println();
        printTitle("증정 메뉴");
        System.out.println(wonGiftEvent);
    }

    public void printBenefitDetails(String details) {
        System.out.println();
        printTitle("혜택 내역");
        System.out.println(details);
    }

    public void printBenefitPrice(int benefitPrice) {
        System.out.println();
        printTitle("총혜택 금액");
        if (benefitPrice != 0) {
            System.out.print("-");
        }
        System.out.println(MONEY_FORMAT.format(benefitPrice) + "원");
    }

    public void printEstimatedPrice(int estimatedPrice) {
        System.out.println();
        printTitle("할인 후 예상 결제 금액");
        System.out.println(MONEY_FORMAT.format(estimatedPrice) + "원");
    }

    public void printEventBadge(Badge badge) {
        System.out.println();
        printTitle("12월 이벤트 배지");
        System.out.println(badge.name());
    }


    private void printTitle(String title) {
        System.out.println("<" + title + ">");
    }
}
