package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain 
{
 public static void main(String []args)
 {
    try{
       Registry reg = LocateRegistry.createRegistry(1099);
       ServerInterface b =new Server();
       Naming.rebind("rmi://169.254.84.232/myabc",b);
       System.out.println("[System]chat Server is ready");
       
    }
    catch(Exception e)
    {
       System.out.println("server failed");
    }
 }
}
