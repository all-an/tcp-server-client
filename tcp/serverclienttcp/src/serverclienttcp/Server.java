package serverclienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public ConnectionHandler(Socket client){
            this.client = client;
        }

        @Override
        public void run(){

        }

    }
}
