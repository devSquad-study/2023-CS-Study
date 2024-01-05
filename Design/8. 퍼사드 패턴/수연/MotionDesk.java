public class MotionDesk {
    boolean power = false;
    int height = 80;

    public MotionDesk() {
    }

    public MotionDesk(int height) {
        this.height = height;
    }

    public void start() {
        power = true;
        System.out.println("모션 데스크의 전원이 켜졌습니다.");
    }

    public void quit() {
        power = false;
        System.out.println("모션 데스크의 전원이 꺼졌습니다.");
    }

    public void setHeight(int height) {
        if (60 <= height && height <= 100) {
            this.height = height;
            System.out.println(height + "로 설정되었습니다.");
        }else{
            System.out.println("[ERROR]더이상 높이를 조정할 수 없습니다.");
        }

    }
}
