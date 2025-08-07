package view;

import java.util.ArrayList;

public class LottoOutputView {

    public void printLottoNumbers(ArrayList<ArrayList<Integer>> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구입했습니다.");
        for (ArrayList<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

}
