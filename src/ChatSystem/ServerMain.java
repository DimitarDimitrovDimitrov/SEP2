package ChatSystem;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Oleg,Dimitar,Todor. This is the main class for starting the server.
 *         the program accepts the cients who are connecting to the server and
 *         then establishes a connection between them .
 */
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
      Socket ConnectionSocket;

      MessageBroadcast mb = new MessageBroadcast();
      KeyboardThread keyboard = new KeyboardThread();
      new Thread(keyboard).start();
      while (isConnected)
      {

         System.out.println("Waiting for a client...");

         // Wait, on welcoming socket for contact by client
         ConnectionSocket = welcomeSocket.accept();
         System.out.println("client connected");
         ServerConnection c = new ServerConnection(ConnectionSocket, mb);
         new Thread(c, "Communication").start();

         mb.addConnection(c);

         // loop back and wait for another client connection.
      }

      welcomeSocket.close();

      System.out.println("Write now");

   }

}
