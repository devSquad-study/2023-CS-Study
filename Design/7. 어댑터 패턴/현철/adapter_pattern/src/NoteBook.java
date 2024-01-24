import device.CD.CD;
import device.CD.CDAdapter;
import device.NotEnoughEnergy;
import device.Player;
import device.VCR.VCR;
import device.VCR.VCRAdapter;
import device.VHS.VHS;
import device.VHS.VHSAdapter;
import java.io.IOException;

public class NoteBook {
    public static void main(String[] args) throws IOException {
        CD cd = new CD();
        VCR vcr = new VCR();
        VHS vhs = new VHS();
        int onDevice = 0;
        Player[] players = new Player[3];

        players[0] = new CDAdapter(cd);
        players[1] = new VCRAdapter(vcr);
        players[2] = new VHSAdapter(vhs);

        try {
            onDevice = players[0].remoteController(onDevice);
            players[0].output();
            players[1].output();
            onDevice = players[1].remoteController(onDevice);
            players[1].output();
            onDevice = players[2].remoteController(onDevice);


        } catch (NotEnoughEnergy notEnoughEnergy) {
            System.out.println("너무 많은 화면이 동작 중입니다.");
        }
    }
}
