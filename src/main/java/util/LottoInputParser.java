package util;

import java.util.ArrayList;
import vo.Lotto;
import vo.LottoNumber;

public class LottoInputParser {

    public static int parseMoney(String input) {
        LottoValidator.validateMoney(input);
        return Integer.parseInt(input);
    }

    public static Lotto parseWinningNumbers(String input) {
        LottoValidator.validateWinningNumbersInput(input);

        String[] numberStrings = input.split(",");
        ArrayList<LottoNumber> winningNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            winningNumbers.add(new LottoNumber(number));
        }

        return new Lotto(winningNumbers);
    }

    public static LottoNumber parseBonusBall(String input) {
        LottoValidator.validateBonusNumber(input);
        int number = Integer.parseInt(input.trim());
        return new LottoNumber(number);
    }

    public static int parseManualLottoCount(String input) {
        LottoValidator.validateManualLottoCount(input);
        return Integer.parseInt(input);
    }

    public static ArrayList<Lotto> parseManualLottos(ArrayList<String> input) {
        ArrayList<Lotto> manualLottos = new ArrayList<>();
        for (String manualLottoInput : input) {
            manualLottos.add(parseManualLotto(manualLottoInput));
        }
        return manualLottos;
    }

    public static Lotto parseManualLotto(String input) {
        LottoValidator.validateManualLottoInput(input);

        String[] numberStrings = input.split(",");
        ArrayList<LottoNumber> manualLottos = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            manualLottos.add(new LottoNumber(number));
        }

        return new Lotto(manualLottos);
    }
}
