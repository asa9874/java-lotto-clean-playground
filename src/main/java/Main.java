
import java.lang.reflect.Array;
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

        // 수동 로또 입력 처리
        int manualLottoCount = Integer.parseInt(inputView.inputManualLottoCount());
        ArrayList<Lotto> manualBuyLotto = LottoInputParser
                .parseManualLottos(inputView.inputManualLottoNumbers(manualLottoCount));
        lottoSimulator.buyManualLotto(manualBuyLotto);

        // 자동 로또 구매
        lottoSimulator.buyAutomaticLotto(money - manualLottoCount * 1000);
        ArrayList<Lotto> buyLotto = lottoSimulator.getBuyLottos();
        outputView.printLottoNumbers(buyLotto, manualLottoCount);

        Lotto winningNumbers = LottoInputParser.parseWinningNumbers(inputView.inputWinningNumbers());
        LottoNumber bonusBall = LottoInputParser.parseBonusBall(inputView.inputBonusBall());

        lottoResult.calculateResult(lottoSimulator.getBuyLottos(), winningNumbers, bonusBall, money);
        outputView.printWinningStatistics(lottoResult.getWinningStatistics(), lottoResult.calculateProfitRate());
    }
}
