package ClientClasses;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatClient
{
   public static final String SERVER_HOSTNAME = "10.52.237.191";
   public static final int SERVER_PORT = 2002;

   private static BufferedReader mSocketReader;
   private static PrintWriter mSocketWriter;
   {
  
      // Connect to the chat server
      try
      {
         Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
         mSocketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         mSocketWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
         System.out.println("Connected to server " + SERVER_HOSTNAME + ":"+ SERVER_PORT);
      }
      catch (IOException ioe)
      {
         System.err.println("Can not connect to " + SERVER_HOSTNAME + ":"+ SERVER_PORT);
         ioe.printStackTrace();
         System.exit(-1);
      }
      // Start socket --> console transmitter thread
      PrintWriter consoleWriter = new PrintWriter(System.out);
      TextDataTransmitter socketToConsoleTransmitter = new TextDataTransmitter(mSocketReader, consoleWriter);
      socketToConsoleTransmitter.setDaemon(false);
      socketToConsoleTransmitter.start();
      // Start console --> socket transmitter thread
      BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
      TextDataTransmitter consoleToSocketTransmitter = new TextDataTransmitter(consoleReader, mSocketWriter);
      consoleToSocketTransmitter.setDaemon(false);
      consoleToSocketTransmitter.start();
   
 
   
}
}



