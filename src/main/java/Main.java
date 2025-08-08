
import java.util.ArrayList;

import domain.LottoResult;
import domain.LottoSimulator;
import util.LottoInputParser;
import view.LottoInputView;
import view.LottoOutputView;
import vo.Lotto;
import vo.LottoNumber;

public class Main {

    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();
        LottoSimulator lottoSimulator = new LottoSimulator();
        LottoResult lottoResult = new LottoResult();

        int money = LottoInputParser.parseMoney(inputView.inputMoney());

        processManualLottos(inputView, lottoSimulator);
        processAutomaticLottos(inputView, outputView, lottoSimulator, money);
        processWinningNumbers(inputView, outputView, lottoSimulator, lottoResult, money);
    }

    private static void processManualLottos(LottoInputView inputView, LottoSimulator lottoSimulator) {
        int manualLottoCount = Integer.parseInt(inputView.inputManualLottoCount());
        ArrayList<Lotto> manualBuyLotto = LottoInputParser
                .parseManualLottos(inputView.inputManualLottoNumbers(manualLottoCount));
        lottoSimulator.buyManualLotto(manualBuyLotto);
    }

    private static void processAutomaticLottos(LottoInputView inputView, LottoOutputView outputView, 
                                               LottoSimulator lottoSimulator, int money) {
        int manualLottoCount = lottoSimulator.getBuyLottos().size();
        lottoSimulator.buyAutomaticLotto(money - manualLottoCount * 1000);
        outputView.printLottoNumbers(lottoSimulator.getBuyLottos(), manualLottoCount);
    }

    private static void processWinningNumbers(LottoInputView inputView, LottoOutputView outputView,
                                              LottoSimulator lottoSimulator, LottoResult lottoResult, int money) {
        Lotto winningNumbers = LottoInputParser.parseWinningNumbers(inputView.inputWinningNumbers());
        LottoNumber bonusBall = LottoInputParser.parseBonusBall(inputView.inputBonusBall());

        lottoResult.calculateResult(lottoSimulator.getBuyLottos(), winningNumbers, bonusBall, money);
        outputView.printWinningStatistics(lottoResult.getWinningStatistics(), lottoResult.calculateProfitRate());
    }
}
