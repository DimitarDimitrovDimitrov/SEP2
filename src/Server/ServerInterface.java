package Server;

import java.rmi.*;
import java.util.*;

public interface ServerInterface extends Remote
{
   public void publish (String s) throws RemoteException; 
   

}
