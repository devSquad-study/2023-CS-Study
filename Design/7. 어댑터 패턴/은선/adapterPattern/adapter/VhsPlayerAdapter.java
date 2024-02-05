package adapterPattern.adapter;

import adapterPattern.device.VhsPlayer;

public class VhsPlayerAdapter implements VideoPlayer {
    private VhsPlayer vhsPlayer;

    public VhsPlayerAdapter(VhsPlayer vhsPlayer) {
        this.vhsPlayer = vhsPlayer;
    }

    public void playVideo() {
        vhsPlayer.play();
    }
}
