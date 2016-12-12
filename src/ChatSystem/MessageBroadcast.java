package ChatSystem;

import java.awt.List;
import java.util.ArrayList;

/**
 * @author Oleg,Dimitar,Todor.
 * <p>
 *  This is the MessageBroadcast class it provides a list used to store or retrieve connections and show the number of connected clients.
 * <p>
 * 
 *  
 * 
 */
public class MessageBroadcast
{
   private ArrayList <ServerConnection>conns=new ArrayList<>();
   public MessageBroadcast()
   {
      
   }
   /**
    * Adds a connection to the connections list                         (1)
    * <p>
    *  Adds a connection to the connectionlist conns 
    * <p>
    * 
    * @param  ServerConnection conn. 
    * 
    */
   
   public void addConnection(ServerConnection conn)
   {
      conns.add(conn);
   }
   /**
    * returns the number of clients that in the conns  .                   (1)
    * 
    *  
    * 
    * 
    * @return conns.size();
    * 
    */
   public int numberofclients()
   {
      return conns.size();
   }
   /**
    *   
    * 
    *  returns the number of clients stored in   conns .
    * <p>
    * @param int i.
    * @return conns.get(i);
    * 
    */
   public ServerConnection getConnection(int i)
   {
      return conns.get(i);
      
   }
   
}
