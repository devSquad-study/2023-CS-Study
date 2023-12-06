package Machine.command.gasstove;

public class GasStoveUndo {
    static final int HIGH = 3;
    static final int MEDIUM = 2;
    static final int LOW = 1;
    static final int OFF = 0;

    public int undo(int prevTempStatus) {
        if (prevTempStatus == HIGH) {
            return HIGH;
        }

        if (prevTempStatus == MEDIUM) {
            return MEDIUM;
        }

        if (prevTempStatus == LOW) {
            return LOW;
        }

        return OFF;
    }
}
