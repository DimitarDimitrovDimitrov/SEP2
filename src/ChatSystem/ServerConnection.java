package ChatSystem;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Adapter.Adapter;
import Adapter.AdapterInterface;
import Model.Message;
import Model.Messages;

/**
 * @author Oleg,Dimitar,Todor This class recieves messages from the clients It
 *         also sends them to the clients.
 */
public class ServerConnection implements Runnable
{

   AdapterInterface db2 = new Adapter("org.postgresql.Driver",
         "jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
   Messages list = new Messages();
   private Socket ClientSocket;
   private MessageBroadcast mb;

   ObjectOutputStream outToClient;
   ObjectInputStream inFromClient;

   public ServerConnection(Socket connectionSocket, MessageBroadcast mb)
   {
      ClientSocket = connectionSocket;
      this.mb = mb;
      try
      {
         outToClient = new ObjectOutputStream(
               connectionSocket.getOutputStream());

         // create input stream attached to the socket
         inFromClient = new ObjectInputStream(
               (connectionSocket.getInputStream()));
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }

   }

   /**
    * returns a message to the client.
    * <p>
    * calls the outToClient variable when the method is called .
    * <p>
    * 
    * @return conns.size();
    */
   public ObjectOutputStream returnMessage()
   {
      return outToClient;
   }

   
   /**
    *This prints the messages sent from the client     
    * <p>
    *  This prints the messages sent from the client.
    *  and then sends a reply to all the clients containing that message 
    *  
    * 
    * 
    * 
    */
   @Override
   public void run()
   {
      while (true)
      {

         // create output stream attached to the socket

         // read message from client.
         try
         {
            Message message = (Message) inFromClient.readObject();
            System.out.println("Message from Client: " + message);

            // Send reply to client.
            Message replyMessage = new Message(message.getId(), message.getBody().toUpperCase());

            for (int i = 0; i < mb.numberofclients(); i++)
            {
               mb.getConnection(i).returnMessage().writeObject(message);

            }
            list.add(message);
            db2.Write(list);

         }
         catch (Exception ex)
         {
            
         }
      }

   }

}
