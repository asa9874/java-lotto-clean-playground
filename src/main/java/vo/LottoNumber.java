package vo;

import java.util.ArrayList;
import util.LottoValidator;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        LottoValidator.validateLottoNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoNumber))
            return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public static ArrayList<LottoNumber> convertFromIntegers(ArrayList<Integer> numbers) {
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
}
