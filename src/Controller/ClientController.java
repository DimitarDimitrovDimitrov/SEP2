package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import ChatSystem.ClientReciever;

import Model.Message;
import Model.Messages;
import Model.Model;

import View.ChatView;
import View.View;
/**
 * @author Oleg,Dimitar,Todor;
 * 
 */
/**
 * this is the client controller class it calls the methods from the view class
 * the class is necessary for the implementation of the MVC pattern as this is  the controller 
 */
public class ClientController
{
   private Model model;
   private View view;
   ObjectOutputStream outToServer;
   ObjectInputStream inFromServer;
   Socket clientSocket;
  



   public ClientController(Model model, View view)
   {
      this.model = model;
      this.view = view;
    
      try
      {

         final int PORT = 6789;
         final String HOST = "localhost";
         System.out.println("stuff");
         clientSocket = new Socket(HOST, PORT);
         // create input stream attached to the socket.
         System.out.println("inputstream");
         inFromServer = new ObjectInputStream(clientSocket.getInputStream());
         System.out.println("stuff1.5");
         // create output stream attached to the socket.
         outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
         System.out.println("stuff2");
         view.UpdateMessages("\n" + "Client> connected to server");
         ClientReciever r = new ClientReciever(inFromServer, this);
         new Thread(r, "Reciever").start();

      }
      catch (IOException ex)
      {
         System.out.println("ERROR");
         ex.printStackTrace();

      }

   }
   /**
    * updates the online users.                           (1)
    * <p>
    *  calls the view object to update the onlineusersArea by adding a String with the 
    *  new Client that connected.
    * <p>
    * 
    * @param  String users. 
    * 
    */
   public void updateOnlineUsers(String users)
   {
      view.updateOnlineUsers(users);
   }
   /**
    * updates the messages sent by the clients.                 
    * <p>
    * calls the view object to update the TextOutputArea by adding a String with the message.
    *  
    *  
    *  
    *
    * @param  String body.           
    * 
    */
   public void UpdateMessages(String body)
   {
      view.UpdateMessages(body);

   }
   /**
    * sends messages                          
    * <p>
    * when the enter button is pressed calls the outToServerObject to send a String message with a timestamp and username to the server
    * and then resets the text area.
    *  
    *  
    *
    * @param  String message.          
    *  
    */
   
   public void sendMessageEnter(String message)
   {

      try
      {

         // create client socket, connect to server.
         String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());

         message = "[" + timeStamp + "] " + view.getUserNameField() + ": "+ view.getTextFieldInput();
         Message m = new Message(message, true);

         outToServer.writeObject(m);

         view.setTextFieldInput();

      }
      catch (Exception ex)
      {

      }
   }
   /**
    * performs the functions of the other buttons                  
    * <p>
    * If the button is send it sends a message containing the username set by the client and sends it to the server.
    * If the button is quit it closes the program.
    *  
    *  
    * 
    * @param  ActionEvent e.           
    * 
    */
   public void actionPerformed(ActionEvent e)
   {
      
      if(e.getActionCommand().equals("Send"))
      {
         String message;
         String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());

         message = "[" + timeStamp + "] " + view.getUserNameField() + ": "+ view.getTextFieldInput();
         Message m = new Message(message, true);

         try
         {
            outToServer.writeObject(m);
         }
         catch (IOException e1)
         {
            
            e1.printStackTrace();
         }

         view.setTextFieldInput();
         
         
      }
      
      
      if (e.getActionCommand().equals("Set"))
      {

         try
         {
            System.out.println("send to server " + view.getUserNameField());
            outToServer.writeObject(new Message(view.getUserNameField(), false));
         }
         catch (IOException e1)
         {
          
            e1.printStackTrace();
         }

        

      }
      if (e.getActionCommand().equals("Quit"))
      {
         System.exit(0);
         System.out.println("code");
      }

   }

  
 
  

}