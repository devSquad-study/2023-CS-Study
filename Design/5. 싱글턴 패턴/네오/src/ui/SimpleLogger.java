package ui;

import java.util.Map;

public class SimpleLogger implements Logger {

    private final Map<Type, String> formats;

    public SimpleLogger() {
        this.formats = Map.of(
                Type.REQUEST, "[REQUEST] %s - %6s %s %2s pages.%n",
                Type.ENQUEUE, "[ENQUEUE] %s - %6s %s%n",
                Type.PRINT, "[PRINT  ] %s - %6s %5s %2s / %-2s pages.%n"
        );
    }

    @Override
    public void log(Type type, Object... args) {
        System.out.printf(formats.get(type), args);
    }

}
