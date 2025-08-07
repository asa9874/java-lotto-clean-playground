import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.buyLotto(5000);

        ArrayList<ArrayList<Integer>> lottoNumbers = lotto.getBuyLottos();
        for (ArrayList<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }
}
