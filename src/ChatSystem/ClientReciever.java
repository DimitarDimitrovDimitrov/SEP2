package ChatSystem;

import java.io.ObjectInputStream;

import Controller.ClientController;
import Model.Message;
import View.ChatView;
/**
 *@author Oleg,Dimitar,Todor
 *this is the class that   recieves the messages sent from the server and distributes them into messages or user names
 *depending if the has  is  true or false when it is sent to the server 
 *
 * 
 */
public class ClientReciever implements Runnable
{
   private ObjectInputStream inFromServer;

   // coooment
   private ClientController controller;

   public ClientReciever(ObjectInputStream inFromServer,
         ClientController clientController)
   {
      System.out.println("Created Client Reciever");
      this.inFromServer = inFromServer;
      this.controller = clientController;
   }

   /**
    * sends the message to client or makes the username visible  
    * <p>
    * if the message is a message by the get is message method set in the client
    * controller then it calls the UpdateMessages in the client controller
    * which shows the message in the textOutputArea.
    * if the message is not a message by the getIsMessage method then it shows the username in the usernameArea.
    * 
    * 
    *  
    */
   public void run()
   {
      while (true)
      {
         try
         {
            Message message = (Message) inFromServer.readObject();
            if (message.getIsMessage() == true)
            {
               System.out.println("Reciever: " + message);
               controller.UpdateMessages(message.getBody());
            }
            if (message.getIsMessage() == false)
            {
               System.out.println("Reciever: " + message);
               controller.updateOnlineUsers(message.getBody());
               // is user name
            }

         }

         catch (Exception ex)
         {

         }
         if (inFromServer == null)
         {
            System.out.println("inFromServer was null");
            break;
         }
      }
      // TODO Auto-generated method stub

   }
}
