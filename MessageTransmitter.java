package sideproject;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by desta on 2016-04-27.
 */
public class MessageTransmitter extends Thread{
    String message, hostname;
    int port;
    public MessageTransmitter(){

    }
    public MessageTransmitter(String message, String hostname, int port){
        this.hostname = hostname;
        this.message = message;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException e) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
