package ChatSystem;

import java.io.ObjectInputStream;

import Controller.ClientController;
import Model.Message;
import View.ChatView;

public class ClientReciever implements Runnable
{
   private ObjectInputStream inFromServer;
   private ChatView view;
  
   private ClientController controller;
   public ClientReciever(ObjectInputStream inFromServer,ClientController clientController)
   {
      System.out.println("Created Client Reciever");
      this.inFromServer=inFromServer;
     this.controller=clientController;
   }
   public void run()
   {
      while(true)
      {
         try
         {
         Message message=(Message) inFromServer.readObject();
         System.out.println("Reciever: "+message);
         controller.UpdateMessages(message.getBody());
         if(inFromServer==null)
         {
            System.out.println("inFromServer was null");
            break;
         }
         }
         catch(Exception ex)
         {
            
         }
      }
      // TODO Auto-generated method stub
      
   }
 
}
