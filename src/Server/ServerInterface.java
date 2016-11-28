package Server;

import java.rmi.*;
import java.util.*;

import Client.ClientInterface;

public interface ServerInterface extends Remote
{
   public boolean login (ClientInterface a) throws RemoteException;
   public void publish (String s) throws RemoteException; 
   ArrayList<String> getConnected = new ArrayList<String>();
}
