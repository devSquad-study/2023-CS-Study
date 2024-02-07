package design;

import design.service.message.MessageService;
import design.service.message.MessageServiceImpl;
import design.service.pong.PongService;
import design.service.pong.PongServiceImpl;
import design.service.upload.FileService;
import design.service.upload.FileServiceImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerApp {

    public static void main(String[] args) {
        try {
            System.out.println("RMI Registry Starting...");

            Registry registry = LocateRegistry.createRegistry(1099);

            PongService pongService = new PongServiceImpl();
            registry.bind(PongService.class.getSimpleName(), pongService);
            System.out.printf("%s registered.\n", pongService.getClass().getSimpleName());

            MessageService messageService = new MessageServiceImpl();
            registry.bind(MessageService.class.getSimpleName(), messageService);
            System.out.printf("%s registered.\n", messageService.getClass().getSimpleName());

            FileService fileService = new FileServiceImpl();
            registry.bind(FileService.class.getSimpleName(), fileService);
            System.out.printf("%s registered.\n", fileService.getClass().getSimpleName());

            System.out.println("Hello world!");
            System.out.println("RMI server running on port 1099...");
        } catch (RemoteException | AlreadyBoundException e) {
            System.err.println("RMI got error: " + e.getMessage());
            System.out.println("RMI Shutting Down...");
        }
    }

}
