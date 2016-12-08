package ChatSystem;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Adapter.Adapter;
import Adapter.AdapterInterface;
import Model.Message;
import Model.Messages;

public class ServerConnection implements Runnable
{
   
   
   AdapterInterface  db2=new Adapter("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
   Messages list=new Messages();
   private Socket ClientSocket;
   private MessageBroadcast mb;
   
   
   ObjectOutputStream outToClient;
   ObjectInputStream inFromClient;
   
   public ServerConnection( Socket connectionSocket, MessageBroadcast mb)
   {
      ClientSocket=connectionSocket;
    this. mb=mb;
      try{
      outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());

      // create input stream attached to the socket
      inFromClient = new ObjectInputStream(
            (connectionSocket.getInputStream()));
      }
      catch(Exception ex)
      {
         
      }

      
   }
   public ObjectOutputStream  returnMessage()
   {
      return outToClient;
   }


   @Override
   public void run()
   {
      while(true)
      {
      // TODO Auto-generated method stub
      
      // create output stream attached to the socket
     
      // read message from client.
         try{
      Message message = (Message) inFromClient.readObject();
      System.out.println("Message from Client: " + message);

      // Send reply to client.
      Message replyMessage = new Message(message.getId(), 
                               message.getBody().toUpperCase());
      
       for(int i=0;i<mb.numberofclients();i++)
       {
        mb.getConnection(i).returnMessage().writeObject(message);
        
          
       }
       list.add(message);
       db2.Write(list);
    
      }
         catch(Exception ex)
         {
            
         }
      }
     

   }
  

}
