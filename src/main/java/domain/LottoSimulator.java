package domain;

import java.util.ArrayList;

import util.LottoNumberGenerator;
import vo.Lotto;

public class LottoSimulator {

    private final int LOTTO_PRICE = 1000;

    private ArrayList<Lotto> buyLottos = new ArrayList<>();

    public void buyAutomaticLotto(int price) {
        int numberOfLotto = calculateNumberOfLotto(price);
        this.buyLottos.addAll(generateLottos(numberOfLotto));
    }

    public void buyManualLotto(ArrayList<Lotto> manualLottos) {
        this.buyLottos.addAll(manualLottos);
    }

    private int calculateNumberOfLotto(int price) {
        return price / LOTTO_PRICE;
    }

    private ArrayList<Lotto> generateLottos(int numberOfLotto) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < numberOfLotto; index++) {
            Lotto lotto = LottoNumberGenerator.generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public ArrayList<Lotto> getBuyLottos() {
        return buyLottos;
    }

}