package adapterPattern.adapter;

import adapterPattern.device.Vcr;

public class VcrAdapter implements VideoPlayer {
    private Vcr vcr;

    public VcrAdapter(Vcr vcr) {
        this.vcr = vcr;
    }

    public void playVideo() {
        vcr.play();
    }
}

