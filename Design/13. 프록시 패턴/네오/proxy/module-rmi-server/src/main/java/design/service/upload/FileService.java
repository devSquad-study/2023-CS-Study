package design.service.upload;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FileService extends Remote {

    String upload(byte[] fileData, String fileName, String fileExtension) throws RemoteException;
    List<String> getList() throws RemoteException;

}
