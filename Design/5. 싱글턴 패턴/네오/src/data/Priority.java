package data;

public enum Priority {
    LAZY(1),
    LOW(2),
    NORMAL(3),
    HIGH(4),
    HOT(5),
    ;

    private final int level;

    Priority(int level) {
        this.level = level;
    }
}
