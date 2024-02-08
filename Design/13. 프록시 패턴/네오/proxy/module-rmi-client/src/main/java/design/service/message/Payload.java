package design.service.message;

import java.io.Serial;
import java.io.Serializable;

public class Payload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String clientHost;
    private final String content;

    public Payload(String content) {
        this.clientHost = null;
        this.content = content;
    }

    public Payload(String clientHost, String content) {
        this.clientHost = clientHost;
        this.content = content;
    }

    public String getClientHost() {
        return clientHost;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "clientHost='" + clientHost + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
