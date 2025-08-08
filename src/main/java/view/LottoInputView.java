
package view;

import java.util.Scanner;

public class LottoInputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String inputBonusBall() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}
