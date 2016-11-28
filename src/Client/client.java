package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class client extends UnicastRemoteObject implements ClientInterface
{
private String name;
private ChatUI ui;
public client(String n) throws RemoteException{
	name=n;
}
	
	
	
}
