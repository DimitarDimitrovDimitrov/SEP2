package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class client extends UnicastRemoteObject implements ClientInterface
{
private String name;
//private ChatUI ui;
public client(String n) throws RemoteException{
	name=n;
}
@Override
public void tell(String st) throws RemoteException {
	System.out.println(st);
	//ui.TypeMessage(st);
	
}
@Override
public String getName() throws RemoteException {
	return name;
	
}

/* 
 * 	public void setGUI(ChatUI t){
 * ui=t;
 * }
 */
	
	
}
