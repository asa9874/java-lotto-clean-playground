package domain;
import java.util.ArrayList;

import util.LottoNumberGenerator;

public class Lotto {

    private final int LOTTO_PRICE = 1000;

    private final LottoNumberGenerator lottoNumberGenerator;
    private ArrayList<ArrayList<Integer>> buyLottos = new ArrayList<>();

    public Lotto() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    public void buyLotto(int price) {
        int numberOfLotto = calculateNumberOfLotto(price);
        this.buyLottos.addAll(generateLottos(numberOfLotto));

    }

    private int calculateNumberOfLotto(int price) {
        return price / LOTTO_PRICE;
    }

    private ArrayList<ArrayList<Integer>> generateLottos(int numberOfLotto) {
        ArrayList<ArrayList<Integer>> lottos = new ArrayList<>();
        for (int index = 0; index < numberOfLotto; index++) {
            ArrayList<Integer> lottoNumbers = lottoNumberGenerator.generateLottoNumbers(numberOfLotto);
            lottos.add(lottoNumbers);
        }
        return lottos;
    }

    public ArrayList<ArrayList<Integer>> getBuyLottos() {
        return buyLottos;
    }

}