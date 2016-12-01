package ChatSystem;

import java.awt.List;
import java.util.ArrayList;

public class MessageBroadcast
{
   private ArrayList <ServerConnection>conns=new ArrayList<>();
   public MessageBroadcast()
   {
      
   }
   public void addConnection(ServerConnection conn)
   {
      conns.add(conn);
   }
   public int numberofclients()
   {
      return conns.size();
   }
   public ServerConnection getConnection(int i)
   {
      return conns.get(i);
      
   }
   
}
