package domain;

public enum WinningRank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private final int matchCount;
    private final int prize;

    WinningRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningRank valueOf(int matchCount) {
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return MISS;
    }

    
    public int getPrize() {
        return prize;
    }
}
