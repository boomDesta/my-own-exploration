package gui;

import sideproject.MessageListener;
import sideproject.MessageTransmitter;
import sideproject.WritableGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by desta on 2016-04-27.
 */
public class Screen extends javax.swing.JFrame implements WritableGUI {

    private JButton listenButton;
    private JTextField ipaddress;
    private JTextArea chat;
    private JButton sendButton;
    private JTextField message;
    private JTextField receiveport;
    private JTextField targetport;

    MessageListener listener;
    private void listenButtonActionPerformed(java.awt.event.ActionEvent evt){
        listener = new MessageListener (this, Integer.parseInt(receiveport.getText()));
        listener.start();
    }
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
       MessageTransmitter transmitter = new MessageTransmitter(message.getText(), ipaddress.getText(), Integer.parseInt(targetport.getText()));
       transmitter.start();
       }//


    @Override
    public void write(String s) {
        chat.append(s + System.lineSeparator());
    }
}
