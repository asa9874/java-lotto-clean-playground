
import domain.Lotto;
import util.LottoInputParser;
import view.LottoInputView;
import view.LottoOutputView;

public class Main {

    public static void main(String[] args) {

        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();
        Lotto lotto = new Lotto();

        Integer moneyInput = LottoInputParser.parseMoney(inputView.inputMoney());
        lotto.buyLotto(moneyInput);

        outputView.printLottoNumbers(lotto.getBuyLottos());
    }
}
