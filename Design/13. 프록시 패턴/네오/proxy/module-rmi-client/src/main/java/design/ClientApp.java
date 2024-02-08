package design;

import design.service.message.MessageService;
import design.service.message.Payload;
import design.service.pong.PongService;
import design.service.upload.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientApp {

    public static void main(String[] args) {
        try {
            System.out.println("Hello world!");

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            PongService pongService = (PongService) registry.lookup(PongService.class.getSimpleName());
            MessageService messageService = (MessageService) registry.lookup(MessageService.class.getSimpleName());
            FileService fileService = (FileService) registry.lookup(FileService.class.getSimpleName());

            System.out.printf("pongService response: %s\n", pongService.pong());
            System.out.printf("messageService response: %s\n", messageService.send(new Payload("테스트 메세지")));
            fileService.getList().forEach(System.out::println);

            String resourceDir = "./module-rmi-client/src/main/resources/";
            String simpleFileName = "testFile";
            String fileExtension = ".md";
            String targetFile = resourceDir + simpleFileName + fileExtension;

            System.out.printf(
                    "fileService upload response: %s\n",
                    fileService.upload(Files.readAllBytes(new File(targetFile).toPath()), simpleFileName, fileExtension)
            );
            System.out.printf(
                    "fileService upload response: %s\n",
                    fileService.upload(Files.readAllBytes(new File(targetFile).toPath()), simpleFileName, fileExtension)
            );
            System.out.printf(
                    "fileService upload response: %s\n",
                    fileService.upload(Files.readAllBytes(new File(targetFile).toPath()), simpleFileName, fileExtension)
            );

            fileService.getList().forEach(System.out::println);
        } catch (NotBoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
