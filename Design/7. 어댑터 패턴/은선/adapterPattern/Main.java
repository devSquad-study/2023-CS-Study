package adapterPattern;

import adapterPattern.adapter.*;
import adapterPattern.device.*;

public class Main {
    public static void main(String[] args) {
        LaptopSystem laptop = new LaptopSystem();

        VideoPlayer vcrAdapter = new VcrAdapter(new Vcr("리모컨"));
        VideoPlayer cdPlayerAdapter = new CdPlayerAdapter(new CdPlayer("버튼"));
//        VideoPlayer cdPlayerAdapter2 = new CdPlayerAdapter(new CdPlayer("마이크"));
        VideoPlayer vhsPlayerAdapter = new VhsPlayerAdapter(new VhsPlayer("리모컨"));

        laptop.connect(vcrAdapter);
        laptop.playVideo();

        laptop.connect(cdPlayerAdapter);
        laptop.playVideo();

//        laptop.connect(cdPlayerAdapter2);
//        laptop.playVideo();

        laptop.connect(vhsPlayerAdapter);
        laptop.playVideo();

        laptop.connect(vhsPlayerAdapter);
        laptop.playVideo();
    }
}
