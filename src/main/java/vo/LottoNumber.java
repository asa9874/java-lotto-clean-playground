package vo;

import java.util.ArrayList;
import util.LottoValidator;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        LottoValidator.validateLottoNumberRange(number);
        this.number = number;
    }

    // 로또 번호 값을 반환하는 메서드
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

    // 정수 리스트를 LottoNumber 리스트로 변환하는 메서드
    public static ArrayList<LottoNumber> convertFromIntegers(ArrayList<Integer> numbers) {
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
}
