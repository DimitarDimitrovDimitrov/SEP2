package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

	public void tell (String name)throws RemoteException;
	public String getName()throws RemoteException;
	
}