package serverclienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean done;

    @Override
    public void run() {
        try {
            Socket client = new Socket("127.0.0.1", 9999);
            out = new PrintWriter(client.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            //TODO handle
        }

    }

    public void shutdown(){
        done = true;
        try {
            in.close();
            out.close();
        }
    }

    class InputHandler implements Runnable{
        @Override
        public void run() {
            try{
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
                while(!done){
                    String message = inputReader.readLine();
                    if(message.equals("/quit")){
                        inputReader.close();
                        shutdown();
                    }
                }
            }catch(Exception e){
                //TODO handle
            }
        }
    }
}
