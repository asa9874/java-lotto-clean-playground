package util;

public class LottoInputParser {

    public static int parseMoney(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("구입 금액을 입력해야 합니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("구입 금액은 숫자만 입력할 수 있습니다.");
        }

        int money = Integer.parseInt(input);

        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상의 1000원 단위로 입력해야 합니다.");
        }

        return money;
    }
}
