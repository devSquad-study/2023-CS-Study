import Machine.command.Command;
import Machine.machine.Machine;
import Machine.machine.NoMachine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoteController {
    Machine[] machines;
    Stack<Command> undo = new Stack<>();

    public RemoteController() {
        machines = new Machine[4];

        Machine noMachine = new NoMachine();
        for (int i = 0; i < 4; i++) {
            machines[i] = noMachine;
        }

    }

    public void setCommand(int slot, Machine machine) {
        machines[slot] = machine;
    }

    public void buttonWasPushed(int num) throws IOException {
        boolean exit = true;
        Machine machine = machines[num];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (exit) {
            System.out.println("추가 옵션을 선택해주세요. 취소 할려면 q를 눌러주세요.");
            System.out.println(machine.toString());

            try {
                String answer = bufferedReader.readLine();
                if (answer.equals("q")) {
                    exit = false;
                } else {
                    machine.pushButton(Integer.parseInt(answer));
                }
            } catch (Exception e) {
                System.out.println("[ERROR] 존재하지 않는 옵션입니다.");
            }
        }
    }

    public void undoButtonWasPushed() {
        if (undo.isEmpty()) {
            System.out.println("[ERROR] 취소 가능한 명령이 없습니다.");
            return;
        }

        undo.pop().undo();
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n -----리모컨----- \n");

        for (int i = 0; i < machines.length; i++) {
            sb.append("[slot ").append(i).append("] ").append(machines[i].getClass().getName()).append("\n");
        }

        return sb.toString();
    }
}
