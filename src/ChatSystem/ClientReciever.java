package ChatSystem;

import java.io.ObjectInputStream;

import Model.Message;
import View.ChatView;

public class ClientReciever implements Runnable
{
   private ObjectInputStream inFromServer;
   private ChatView view;
  
   
   public ClientReciever(ObjectInputStream inFromServer,ChatView _view)
   {
      System.out.println("Created Client Reciever");
      this.inFromServer=inFromServer;
      view=_view;
   }
   public void run()
   {
      while(true)
      {
         try
         {
         Message message=(Message) inFromServer.readObject();
         System.out.println("Reciever: "+message);
         view.UpdateMessages(message.getBody());
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
