package adapterPattern.adapter;

import adapterPattern.device.CdPlayer;

public class CdPlayerAdapter implements VideoPlayer {
    private CdPlayer cdPlayer;

    public CdPlayerAdapter(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    public void playVideo() {
        cdPlayer.play();
    }

}
