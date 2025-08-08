package vo;

import java.util.ArrayList;
import java.util.Collections;
import util.LottoValidator;

public class Lotto {

    private final ArrayList<LottoNumber> numbers;

    public Lotto(ArrayList<LottoNumber> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void sortNumbers() {
        Collections.sort(this.numbers, (a, b) -> Integer.compare(a.getNumber(), b.getNumber()));
    }

    public int countMatchingNumbers(Lotto other) {
        int matchCount = 0;
        for (LottoNumber number : this.numbers) {
            if (other.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public ArrayList<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
