package ChatSystem;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain
{
   public static void main(String args[]) throws IOException,
         ClassNotFoundException
   {
      boolean isConnected = true;
      final int PORT = 6789;
      String command;
      Scanner keyboard=new Scanner(System.in);
     
      System.out.println("Starting Server...");

      // create welcoming socket at port 6789
      ServerSocket welcomeSocket = new ServerSocket(PORT);
      Socket ConnectionSocket ;
      
      MessageBroadcast mb=new MessageBroadcast();
      while (isConnected)
      {
         
         System.out.println("Waiting for a client...");
         
         // Wait, on welcoming socket for contact by client
          ConnectionSocket = welcomeSocket.accept();
         System.out.println("client connected");
         ServerConnection c = new ServerConnection(ConnectionSocket,mb);
         new Thread(c,"Communication").start();
        
        
         
            
            mb.addConnection(c);
           
            
            
            
System.out.println("Write now");
         
            if( keyboard.nextLine().equals("Retrieve"))
            {
               System.out.println("Messages");
            }
           
         // loop back and wait for another client connection.
      }
    
      
      
      
      welcomeSocket.close();
      System.out.println("Write");
      
      
      
     
      
      
      
   }
   
  
   
   
}

