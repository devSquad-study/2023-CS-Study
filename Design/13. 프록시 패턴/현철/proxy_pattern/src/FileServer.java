import java.io.IOException;
import java.io.InputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileServer extends Remote {
    void uploadFile(byte[] file, String fileName) throws RemoteException, IOException;
    void sendMessage(String userName, String message) throws RemoteException, IOException;
    String fileList() throws RemoteException;
}
