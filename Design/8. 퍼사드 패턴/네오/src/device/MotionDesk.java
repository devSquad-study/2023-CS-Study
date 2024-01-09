package device;

public class MotionDesk {

    private int height;

    public MotionDesk() {
        this.height = 80;
    }

    public void changeHeight(int step) {
        if (height + step > 100) {
            System.out.printf("[ERROR] 모션데스크의 최대 높이는 100입니다. 현재 높이: %s\n", height);
            return;
        }
        if (height + step < 60) {
            System.out.printf("[ERROR] 모션데스크의 최소 높이는 60입니다. 현재 높이 %s\n", height);
            return;
        }
        height += step;
        System.out.printf("모션데스크 높이를 조절합니다. 현재 높이: %s\n", this.height);
    }

}
