package device;

import java.util.Random;

public class Computer {

    public void checkPower() {
        getCheckMethod("전원 공급 장치").run();
    }

    public void checkMemory() {
        getCheckMethod("메모리").run();
    }

    public void checkCpu() {
        getCheckMethod("CPU").run();
    }

    public void checkGpu() {
        getCheckMethod("GPU").run();
    }

    public void checkIO() {
        getCheckMethod("I/O").run();
    }

    private long getRandomDuration() {
        return new Random().nextInt(100, 4_000);
    }

    private Runnable getCheckMethod(String targetName) {
        long duration = getRandomDuration();
        return () -> {
            try {
                boolean run = true;
                while (run) {
                    System.out.printf("%s 검사를 실행합니다.\n", targetName);
                    Thread.sleep(duration);
                    if (new Random().nextInt(0, 4) == 0) {
                        System.err.printf(
                                "[FATAL ERROR] %s 검사에 실패했습니다. 소요시간: %sms\n",
                                targetName,
                                duration
                        );
                        continue;
                    }
                    System.out.printf("%s 검사가 끝났습니다. 소요시간: %sms\n", targetName, duration);
                    run = false;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
