package domain;

public enum WinningRank {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean requireBonusBall;
    private final int prize;

    WinningRank(int matchCount, boolean requireBonusBall, int prize) {
        this.matchCount = matchCount;
        this.requireBonusBall = requireBonusBall;
        this.prize = prize;
    }

    public static WinningRank valueOf(int matchCount, boolean bonusBallMatch) {
        if (matchCount == 5) {
            if (bonusBallMatch) {
                return SECOND;
            } else {
                return THIRD;
            }
        }
        
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount && !rank.requireBonusBall) {
                return rank;
            }
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }
}
