package view;

import java.util.ArrayList;
import vo.Lotto;

public class LottoOutputView {

    public void printLottoNumbers(ArrayList<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구입했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
