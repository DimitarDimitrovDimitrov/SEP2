package ChatSystem;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{
   public static void main(String args[]) throws IOException,
         ClassNotFoundException
   {
      boolean isConnected = true;
      final int PORT = 6789;
      
      System.out.println("Starting Server...");

      // create welcoming socket at port 6789
      ServerSocket welcomeSocket = new ServerSocket(PORT);
      Socket ConnectionSocket = welcomeSocket.accept();
      
      MessageBroadcast mb=new MessageBroadcast();
      while (isConnected)
      {
         
         System.out.println("Waiting for a client...");

         // Wait, on welcoming socket for contact by client
          ConnectionSocket = welcomeSocket.accept();
         
         ServerConnection c = new ServerConnection(ConnectionSocket,mb);
         new Thread(c,"Communication").start();
        
         
            
            mb.addConnection(c);
        
         // loop back and wait for another client connection.
      }
    
      
      
      
      welcomeSocket.close();
   }
}

