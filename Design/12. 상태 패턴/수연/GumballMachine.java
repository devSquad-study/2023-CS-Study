package statePattern;

public class GumballMachine {

    final static int SOLD_OUT = 0;       // 알맹이 매진

    final static int NO_QUARTER = 1;     // 동전 없음

    final static int HAS_QUARTER = 2;    // 동전 있음

    final static int SOLD = 3;           // 알맹이 있음

    int state = SOLD_OUT;
    int count = 0;                       // 기계에 있는 알맹이의 갯수

    public GumballMachine(int count){
        this.count = count;
        if (count > 0){
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {    // 동전을 투입하는 함수
        if (state == HAS_QUARTER) {
            System.out.println("동전은 한 개만 넣어 주세요.");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("동전을 넣으셨습니다.");
        } else if (state == SOLD_OUT) {
            System.out.println("매진되었습니다. 다음 기회에 이용해 주세요.");
        } else if (state == SOLD) {
            System.out.println("알맹이를 내보내고 있습니다.");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("동전이 반환됩니다.");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어 주세요.");
        } else if (state == SOLD) {
            System.out.println("이미 알맹이를 뽑으셨습니다.");
        } else if (state == SOLD_OUT) {
            System.out.println("동전을 넣지 않으셨습니다. 동전이 반환되지 않습니다.");
        }
    }

    public void turnCrank(){
        if (state == SOLD) {
            System.out.println("손잡이는 한 번만 돌려 주세요.");
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어 주세요.");
        } else if (state == SOLD_OUT) {
            System.out.println("매진되었습니다");
        } else if (state == HAS_QUARTER) {
            System.out.println("손잡이를 돌리셨습니다.");
            state = SOLD;
            dispense();
        }
    }

    private void dispense() {
        if (state == SOLD) {
            System.out.println("알맹이를 내보내고 있습니다.");
            count = count +1;
            if (count == 0){
                System.out.println("더 이상 알맹이가 없습니다");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어 주세요");
        } else if (state == SOLD_OUT) {
            System.out.println("매진입니다.");
        } else if (state == HAS_QUARTER) {
            System.out.println("알맹이를 내보맬 수 없습니다.");
        }
    }
}