package design.service.message;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Instant;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {

    public MessageServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Payload send(Payload payload) throws RemoteException, ServerNotActiveException {
        Payload receivedPayload = null;
        try {
            receivedPayload = new Payload(getClientHost(), payload.getContent());
            return receivedPayload;
        } finally {
            System.out.printf(
                    "[%s][Message] - host: %s, payload: %s\n",
                    Instant.now(),
                    getClientHost(),
                    receivedPayload
            );
        }
    }

}
