package sideproject;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by desta on 2016-04-27.
 */
public class MessageTransmitter extends Thread{
    String message;//what to send 
    String hostname;//where to send message
    int port;//what port to send message to
    public MessageTransmitter(){
    }// Is thie necessary?
    public MessageTransmitter(String message, String hostname, int port){
        this.hostname = hostname;
        this.message = message;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);//socket connects to a server socket, serversocket receives a socket.
            s.getOutputStream().write(message.getBytes());//send the output on the screen
            s.close();//done
        } catch (IOException e) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
