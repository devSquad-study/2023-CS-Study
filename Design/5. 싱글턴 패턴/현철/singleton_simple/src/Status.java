import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {
    REQUEST(1), WAIT(2), CANCEL(3);

    private final int statusValue;

    Status(int statusValue) {
        this.statusValue = statusValue;
    }

    public int statusValue() {
        return statusValue;
    }

    private static final Map<Integer, Status> BY_INTEGER = Stream.of(values())
            .collect(Collectors.toMap(Status::statusValue, e -> e));

    public static Status valueOfStatus (int statusValue) {
        return BY_INTEGER.get(statusValue);
    }
}
