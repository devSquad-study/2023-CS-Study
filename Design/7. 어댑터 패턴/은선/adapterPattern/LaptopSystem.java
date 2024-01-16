package adapterPattern;

import adapterPattern.adapter.VideoPlayer;
import java.util.Scanner;

import static java.lang.System.exit;

public class LaptopSystem {
    private VideoPlayer videoPlayer;
    private static Integer count = 0;
    Scanner scanner = new Scanner(System.in);

    public void connect(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    public void playVideo() {
        checkEnergyUsage();
        if (videoPlayer == null) {
            System.out.println("연결된 영상 저장 장치가 없습니다. 연결 상태를 확인해주세요.");
        } else if (count <= 2) {
            videoPlayer.playVideo();
            count++;
        }
    }

    // 에너지 관리 문제
    public void checkEnergyUsage() {
        if (count >= 3){    // 영상 3개 이상 봤을 경우
            System.out.println("저전력 모드에 들어갑니다. 저전력 모드를 해제할까요?(숫자 0 입력)");
            int option = scanner.nextInt();
            if (option == 0) {
                System.out.println("해제되었습니다.");
                count = 0;
            }
        }
    }
}
