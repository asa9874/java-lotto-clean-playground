import java.util.ArrayList;

public class Lotto {

    private final int LOTTO_PRICE = 1000;

    private final LottoNumberGenerator lottoNumberGenerator;
    private ArrayList<ArrayList<Integer>> buyLottos = new ArrayList<>();

    public Lotto() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    public void buyLotto(int price) {
        int numberOfLotto = price / LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            ArrayList<Integer> lottoNumbers = lottoNumberGenerator.generateLottoNumbers(numberOfLotto);
            buyLottos.add(lottoNumbers);
        }
    }

    public ArrayList<ArrayList<Integer>> getBuyLottos() {
        return buyLottos;
    }

}