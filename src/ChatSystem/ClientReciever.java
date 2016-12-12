package ChatSystem;

import java.io.ObjectInputStream;

import Controller.ClientController;
import Model.Message;
import View.ChatView;

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
    * sends the message to client or makes the username visible                         (1)
    * <p>
    * if the message is a message by the get is message method set in the client controller 
    * <p>
    * And even more explanations to follow in consecutive
    * paragraphs separated by HTML paragraph breaks.
    *
    * @param  variable Description text text text.          (3)
    * @return Description text text text.
    */
   public void run()
   {
      while (true)
      {
         try
         {
            Message message = (Message) inFromServer.readObject();
            if (message.getIsMessage()==true)
            {
               System.out.println("Reciever: " + message);
               controller.UpdateMessages(message.getBody());
            }
           if (message.getIsMessage()==false )
            {
                  System.out.println("Reciever: " +message);
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
