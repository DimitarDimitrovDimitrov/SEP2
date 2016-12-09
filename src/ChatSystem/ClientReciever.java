package ChatSystem;

import java.io.ObjectInputStream;

import Controller.ClientController;
import Model.Message;
import View.ChatView;

public class ClientReciever implements Runnable
{
   private ObjectInputStream inFromServer;
   

   private ClientController controller;

   public ClientReciever(ObjectInputStream inFromServer,
         ClientController clientController)
   {
      System.out.println("Created Client Reciever");
      this.inFromServer = inFromServer;
      this.controller = clientController;
   }

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
            else
            {
               Message user = (Message) inFromServer.readObject();
               if (user.getIsMessage()==false)
               {
                  System.out.println("Reciever: " + user);
                  controller.UpdateOnlineUsers(user.getBody());
                  // is user name
               }
            }
               if (inFromServer == null)
               {
                  System.out.println("inFromServer was null");
                  break;
               }
            
         }
         catch (Exception ex)
         {

         }
      }
      // TODO Auto-generated method stub

   }
}
