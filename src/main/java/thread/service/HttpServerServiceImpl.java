package thread.service;

import thread.utils.HttpHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerServiceImpl implements HttpServerService {

    @Override
    public void start(int port) {

        try (ServerSocket serverSocket = new ServerSocket(port)) { // Removed the extra closing parenthesis here
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection established" + port);

                // Start a new thread to handle the connection
                Thread thread = new Thread(new HttpHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
