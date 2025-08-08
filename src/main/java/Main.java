
import domain.LottoResult;
import domain.LottoSimulator;
import util.LottoInputParser;
import view.LottoInputView;
import view.LottoOutputView;
import vo.Lotto;

public class Main {

    public static void main(String[] args) {

        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();
        LottoSimulator lottoSimulator = new LottoSimulator();
        LottoResult lottoResult = new LottoResult();

        int money = LottoInputParser.parseMoney(inputView.inputMoney());
        lottoSimulator.buyLotto(money);
        outputView.printLottoNumbers(lottoSimulator.getBuyLottos());

        Lotto winningNumbers = LottoInputParser.parseWinningNumbers(inputView.inputWinningNumbers());

        lottoResult.calculateResult(lottoSimulator.getBuyLottos(), winningNumbers, money);
        outputView.printWinningStatistics(lottoResult.getWinningStatistics(), lottoResult.calculateProfitRate());
    }
}
