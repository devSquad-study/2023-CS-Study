package design.service.message;

import java.rmi.Remote;

public interface MessageService extends Remote {

    Payload send(Payload payload);

}
