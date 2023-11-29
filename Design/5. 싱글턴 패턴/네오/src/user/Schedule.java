package user;

import util.RandomIntegerGenerator;

public record Schedule(
        int count,
        int[] gaps
) {

    private static final int MIN_GAP_SECOND = 1;
    private static final int MAX_GAP_SECOND = 5;

    public Schedule(int count) {
        this(
                count,
                RandomIntegerGenerator.asArray(count, MIN_GAP_SECOND, MAX_GAP_SECOND)
        );
    }

}
