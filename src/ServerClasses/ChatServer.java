package ServerClasses;

import java.net.*;
import java.io.*;
import java.util.Vector;

public class ChatServer
{
   public static final int LISTENING_PORT = 2002;
   private static ServerSocket mServerSocket;

   private static ServerDispatcher mServerDispatcher;

   public static void main(String[] args)
   {
      // Start listening on the server socket
      bindServerSocket();

      // Start the ServerDispatcher thread
      mServerDispatcher = new ServerDispatcher();
      mServerDispatcher.start();

      // Infinitely accept and handle client connections
      handleClientConnections();
   }

   private static void bindServerSocket()
   {
      try
      {
         mServerSocket = new ServerSocket(LISTENING_PORT);
         System.out
               .println("ChatServer started on " + "port " + LISTENING_PORT);
      }
      catch (IOException ioe)
      {
         System.err.println("Can not start listening on " + "port "
               + LISTENING_PORT);
         ioe.printStackTrace();
         System.exit(-1);
      }
   }

   private static void handleClientConnections()
   {
      while (true)
      {
         try
         {
            Socket socket = mServerSocket.accept();
            Client client = new Client();
            client.mSocket = socket;
            ClientListener clientListener = new ClientListener(client,
                  mServerDispatcher);
            ClientSender clientSender = new ClientSender(client,
                  mServerDispatcher);
            client.mClientListener = clientListener;
            clientListener.start();
            client.mClientSender = clientSender;
            clientSender.start();
            mServerDispatcher.addClient(client);
         }
         catch (IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
   }
}
