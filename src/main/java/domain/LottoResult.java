package domain;

import java.util.ArrayList;
import java.util.HashMap;
import vo.Lotto;

public class LottoResult {

    private HashMap<WinningRank, Integer> winningStatistics = new HashMap<>();
    private int totalInvestment;

    public LottoResult() {
        initializeWinningStatistics();
    }

    private void initializeWinningStatistics() {
        for (WinningRank rank : WinningRank.values()) {
            winningStatistics.put(rank, 0);
        }
    }

    public void calculateResult(ArrayList<Lotto> buyLottos, Lotto winningLotto, int investment) {
        this.totalInvestment = investment;
        for (Lotto lotto : buyLottos) {
            addWinningResult(lotto, winningLotto);
        }
    }

    private void addWinningResult(Lotto lotto, Lotto winningLotto) {
        int matchCount = winningLotto.countMatchingNumbers(lotto);
        WinningRank rank = WinningRank.valueOf(matchCount);
        winningStatistics.put(rank, winningStatistics.get(rank) + 1);
    }

    public HashMap<WinningRank, Integer> getWinningStatistics() {
        return new HashMap<>(winningStatistics);
    }

    public double calculateProfitRate() {
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / totalInvestment;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (WinningRank rank : winningStatistics.keySet()) {
            totalPrize += rank.getPrize() * winningStatistics.get(rank);
        }
        return totalPrize;
    }
}
