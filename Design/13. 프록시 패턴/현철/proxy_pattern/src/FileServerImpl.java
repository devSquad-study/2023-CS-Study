import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class FileServerImpl extends UnicastRemoteObject implements FileServer {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(FileServer.class.getName());

    public FileServerImpl() throws RemoteException {
    }

    @Override
    public void uploadFile(byte[] file, String fileName) throws RemoteException, IOException {
        File f = new File("./upload/" + fileName);
        FileOutputStream out = new FileOutputStream(f);
        System.out.println("start file upload");

        out.write(file);

        out.close();
        logger.info("Uploaded file: " + f.getName());
    }

    @Override
    public void sendMessage(String userName, String message) throws RemoteException, IOException {
        logger.info("user name: " + userName + "\n" + "message: " + message);
    }

    @Override
    public String fileList() throws RemoteException {
        File folder = new File("./upload");
        StringBuilder sb = new StringBuilder();

        int index = 1;

        for (String s : folder.list()) {
            sb.append(index++).append(". ").append(s).append("\n");
        }

        return sb.toString();
    }
}
