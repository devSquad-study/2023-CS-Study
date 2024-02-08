package design.service.message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

public interface MessageService extends Remote {

    Payload send(Payload payload) throws RemoteException, ServerNotActiveException;

}
