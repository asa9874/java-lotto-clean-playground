package vo;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final ArrayList<LottoNumber> numbers;

    public Lotto(ArrayList<LottoNumber> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void validateLottoNumbers(ArrayList<LottoNumber> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateLottoNumberCount(ArrayList<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(ArrayList<LottoNumber> numbers) {
        ArrayList<LottoNumber> uniqueNumbers = new ArrayList<>();
        for (LottoNumber number : numbers) {
            if (containsInList(uniqueNumbers, number)) {
                throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
            }
            uniqueNumbers.add(number);
        }
    }

    private boolean containsInList(ArrayList<LottoNumber> list, LottoNumber target) {
        for (LottoNumber number : list) {
            if (number.equals(target)) {
                return true;
            }
        }
        return false;
    }

    private void sortNumbers() {
        Collections.sort(this.numbers, (a, b) -> Integer.compare(a.getNumber(), b.getNumber()));
    }

    public int countMatchingNumbers(Lotto other) {
        int matchCount = 0;
        for (LottoNumber number : this.numbers) {
            if (other.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean contains(LottoNumber targetNumber) {
        for (LottoNumber number : numbers) {
            if (number.equals(targetNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
