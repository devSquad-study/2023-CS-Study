import java.rmi.Naming;

public class Main {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            FileServer service = new FileServerImpl();
            Naming.rebind("rmi://127.0.0.1/fileUpload", service);
            System.out.println("File server is running...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
