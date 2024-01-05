public class Monitor {
    boolean power = false;

    public void setLight(int light) {
        if(250 <= light && light <= 400){
            this.light = light;
            System.out.println("빛이 "+light+"nit로 변경되었습니다.");
        }else{
            System.out.println("[ERROR]더이상 빛의 세기를 조정할 수 없습니다.");
        }

    }

    public void setBlueLight(boolean blueLight) {
        this.blueLight = blueLight;
    }

    public void setHDRi(boolean HDRi) {
        this.HDRi = HDRi;
    }

    public void setColorBlindness(boolean colorBlindness) {
        this.colorBlindness = colorBlindness;
    }

    int light = 300;
    boolean blueLight = false;
    boolean HDRi = true;
    boolean colorBlindness = false;

    public void start(){
        power = true;
        System.out.println("모니터의 전원이 켜졌습니다.");
    }

    public void quit(){
        power = false;
        System.out.println("모니터의 전원이 꺼졌습니다.");
    }
}
