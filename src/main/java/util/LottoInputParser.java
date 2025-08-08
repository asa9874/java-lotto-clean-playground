package util;

import java.util.ArrayList;
import vo.Lotto;
import vo.LottoNumber;

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

    public static Lotto parseWinningNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호를 입력해야 합니다.");
        }

        String[] numberStrings = input.split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
        }

        ArrayList<LottoNumber> winningNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            String trimmed = numberString.trim();
            if (!trimmed.matches("\\d+")) {
                throw new IllegalArgumentException("당첨 번호는 숫자만 입력할 수 있습니다.");
            }
            int number = Integer.parseInt(trimmed);
            winningNumbers.add(new LottoNumber(number));
        }

        return new Lotto(winningNumbers);
    }
}
