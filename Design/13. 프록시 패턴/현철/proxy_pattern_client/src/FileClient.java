import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Arrays;
import javax.naming.NamingException;

public class FileClient {
    public static byte[] fileToBytes(File file) throws IOException {

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            return fileBytes;
        }
    }
    public static void main(String[] args) throws NamingException, IOException, NotBoundException {

        FileServer fileClient = (FileServer) Naming.lookup("rmi://127.0.0.1/fileUpload");

        File file = new File("/Users/phc/development/080258/ch04/exercises/image-gallery/Dockerfile");
        byte[] fileBytes = fileToBytes(file);
        fileClient.uploadFile(fileBytes, file.getName());

        file = new File("/Users/phc/development/080258/ch08/exercises/numbers/docker-compose.yml");
        fileBytes = fileToBytes(file);
        fileClient.uploadFile(fileBytes, file.getName());

        fileClient.sendMessage("hash", "done");

        System.out.println(fileClient.fileList());
    }
}
