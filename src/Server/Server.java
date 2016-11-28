package Server;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



import Client.ClientInterface;
import Client.client;

public class Server extends UnicastRemoteObject implements ServerInterface
{
   private ArrayList list;

   public Server() throws RemoteException
   {
      list = new ArrayList<>();
   }

   public boolean login(client a) throws RemoteException
   {
      System.out.println(a.getName() + "connected ");
      a.tell("you have connected succesfully");
      publish(a.getName() + "has just connected ");
      list.add(a);
      return true;
   }

   public void publish(String s) throws RemoteException
   {
      System.out.println(s);
      for (int i = 0; i > list.size(); i++)
      {
         try
         {
            ClientInterface temp = (ClientInterface) list.get(i);
            temp.tell(s);

         }
         catch (Exception e)
         {

         }
      }
   }
   public ArrayList getConnected()throws RemoteException
   {
      return list;
   }

}
