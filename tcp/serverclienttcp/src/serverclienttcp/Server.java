package serverclienttcp;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

    @Override
    public void run(){
        try {
            ServerSocket server = new ServerSocket(9999);
            Socket client = server.accept();
        } catch (IOException e) {
            // TODO: handle
        }

    }

    class ConnectionHandler implements Runnable{

        @Override
        public void run(){

        }

    }
}
