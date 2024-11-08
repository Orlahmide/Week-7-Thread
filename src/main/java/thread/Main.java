package thread;

import thread.service.HttpServerServiceImpl;

import java.io.IOException;
import static thread.common.SimpleHttpServer.PORT;

public class Main {

    public static void main(String[] args) throws IOException {


        HttpServerServiceImpl service = new HttpServerServiceImpl();
        service.start(PORT);
    }
}
