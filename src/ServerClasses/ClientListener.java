package ServerClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/** 
 * ClientListener class listens for client messages and 
 * forwards them to ServerDispatcher. 
 */ 
class ClientListener extends Thread { 
    private ServerDispatcher mServerDispatcher; 
    private Client mClient; 
    private BufferedReader mSocketReader; 
 
    public ClientListener(Client aClient, ServerDispatcher 
            aSrvDispatcher) throws IOException { 
        mClient = aClient; 
        mServerDispatcher = aSrvDispatcher; 
        Socket socket = aClient.mSocket; 
        mSocketReader = new BufferedReader( 
            new InputStreamReader(socket.getInputStream()) ); 
    } 
 
    /** 
     * Until interrupted, reads messages from the client 
     * socket, forwards them to the server dispatcher's 
     * queue and notifies the server dispatcher. 
     */ 
    public void run() { 
        try { 
            while (!isInterrupted()) { 
                String message = mSocketReader.readLine(); 
                if (message == null) 
                    break; 
                mServerDispatcher.dispatchMessage( 
                    mClient, message); 
            } 
        } catch (IOException ioex) { 
            // Problem reading from socket (broken connection) 
        } 
 
        // Communication is broken. Interrupt both listener and 
        // sender threads 
        mClient.mClientSender.interrupt(); 
        mServerDispatcher.deleteClient(mClient); 
    } 
} 
 