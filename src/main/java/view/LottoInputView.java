
package view;

import java.util.ArrayList;
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

    public String inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public ArrayList<String> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        ArrayList<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoNumbers.add(scanner.nextLine());
        }
        return manualLottoNumbers;
    }
}
