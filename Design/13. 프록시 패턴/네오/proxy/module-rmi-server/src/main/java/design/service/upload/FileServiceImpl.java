package design.service.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FileServiceImpl extends UnicastRemoteObject implements FileService {

    private static final String resourceDir = "./module-rmi-server/src/main/resources/files/";

    public FileServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String upload(byte[] fileData, String fileName, String fileExtension) throws RemoteException {
        try {
            fileName = resourceDir + fileName + "." + UUID.randomUUID() + fileExtension;
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(fileData);
            fos.close();
            System.out.printf("file uploaded. %s\n", fileName);
            return fileName;
        } catch (IOException e) {
            System.err.println("file upload failed.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getList() throws RemoteException {
        return Arrays.asList(new File(resourceDir).list());
    }

}
