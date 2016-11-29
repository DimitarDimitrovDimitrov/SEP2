package ServerClasses;

import java.net.Socket;

/**
 * Client class contains information about a client, connected to the server.
 */
class Client
{
   public Socket mSocket = null;
   public ClientListener mClientListener = null;
   public ClientSender mClientSender = null;
}
