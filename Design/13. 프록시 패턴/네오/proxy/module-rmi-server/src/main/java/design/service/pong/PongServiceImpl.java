package design.service.pong;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Instant;

public class PongServiceImpl extends UnicastRemoteObject implements PongService {

    public PongServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String pong() throws RemoteException, ServerNotActiveException {
        try {
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "pong";
        } finally {
            System.out.printf("[%s][Pong] - host: %s\n", Instant.now(), getClientHost());
        }
    }

}
