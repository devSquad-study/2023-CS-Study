package design.service.pong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

public interface PongService extends Remote {

    String pong() throws RemoteException, ServerNotActiveException;

}
