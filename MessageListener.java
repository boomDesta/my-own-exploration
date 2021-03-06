package sideproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by desta on 2016-04-27.
 */
public class MessageListener extends Thread {
    ServerSocket server;
    int port = 8000;
    WritableGUI g;
    public MessageListener(WritableGUI g,int port){
        this.port = port;
        this.g = g;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
    public MessageListener(){
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    @Override
    public void run(){
        Socket clientSocket;//innitialize a socket, a connection to the port.
        try {
            while ((clientSocket = server.accept())!=null){
                //client socket gets the connection. 
                //If the connection is null, while loop doesn't run
                InputStream is = clientSocket.getInputStream(); //take data from connection
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String s = br.readLine();
                if(s != null)
                    g.write(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
