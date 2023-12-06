import Machine.command.gasstove.GasStoveCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Remote {
    public static void main(String[] args) throws IOException {
        //TODO : 차에 탑승할 경우 실외로 변경, 차 시동을 어디서 걸었는지 확인, 사람이 실내인지 실외인지 확인
        RemoteController remoteController = new RemoteController();
        GasStoveCommand gasStoveCommand = new GasStoveCommand();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        remoteController.setCommand(0, gasStoveCommand);

        while (loop) {
            System.out.println("사용할 기기를 선택해주세요. 프로그램을 종료하려면 q를 눌러주세요.");
            String answer = bufferedReader.readLine();

            try {
                if (answer.equals("q")) {
                    loop = false;
                } else {
                    remoteController.buttonWasPushed(Integer.parseInt(answer));

                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("잘못된 값 입니다.");
            }
        }

    }
}
