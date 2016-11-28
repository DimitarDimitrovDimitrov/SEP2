package Server;

import java.rmi.Naming;

public class ServerMain 
{
 public static void main(String []args)
 {
    try{
       java.rmi.registry.LocateRegistry.createRegistry(1099);
       ServerInterface b =new Server();
       Naming.rebind("rmi://192.168.1.102/myabc", b);
       System.out.println("[System]chat Server is ready");
       
    }
    catch(Exception e)
    {
       System.out.println("server failed");
    }
 }
}
