package design.service.pong;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PongService extends Remote {

    String pong() throws RemoteException;

}
