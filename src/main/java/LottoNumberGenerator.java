import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LottoNumberGenerator {

    private final int LOTTO_LOWER_BOUND = 1;
    private final int LOTTO_UPPER_BOUND = 45;
    private final int LOTTO_LENGTH = 6;

    private final ArrayList<Integer> allNumbers = new ArrayList<>();

    public LottoNumberGenerator() {
        for (int i = LOTTO_LOWER_BOUND; i <= LOTTO_UPPER_BOUND; i++) {
            allNumbers.add(i);
        }
    }

    public ArrayList<Integer> generateLottoNumbers(int numberOfLotto) {
        shuffleAllNumbers();
        ArrayList<Integer> selectedNumbers = selectNumbers();
        sortNumbers(selectedNumbers);
        return selectedNumbers;
    }

    private void shuffleAllNumbers() {
        Collections.shuffle(allNumbers);
    }

    private ArrayList<Integer> selectNumbers() {
        ArrayList<Integer> selectedNumbers = new ArrayList<>();
        for (int index = 0; index < LOTTO_LENGTH; index++) {
            selectedNumbers.add(allNumbers.get(index));
        }
        return selectedNumbers;
    }

    private void sortNumbers(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
    }

    public boolean containsNumber(Collection<Integer> lottoNumbers, int targetNumber) {
        return lottoNumbers.contains(targetNumber);
    }

}
