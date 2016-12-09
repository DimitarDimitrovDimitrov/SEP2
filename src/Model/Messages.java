package Model;



import java.util.ArrayList;




public class Messages implements Model
{
   private ArrayList<Message> messages;

   public Messages()
   {
      this.messages = new ArrayList<>();
   }

   public synchronized Message getMessage(int index)
   {
      return messages.get(index);
   }

   public synchronized int count()
   {
      return messages.size();
   }

   public synchronized void add(Message message)
   {
      messages.add(message);
   }
   
   public synchronized Message[] getAll()
   {
      Message[] m = new Message[messages.size()];
      for (int i=0; i<messages.size(); i++)
      {
         m[i] = messages.get(i);
      }
      return m;
   }

   public synchronized Message[] removeAll()
   {
      Message[] m = getAll();
      messages.clear();
      return m;
   }

   public String toString()
   {
      Message[] m = getAll();
      String all = "MessageList: {";
      for (int i = 0; i < m.length; i++)
      {
         all += m[i];
         if (i < m.length-1)
            all += "\n ";
      }
      all += "\n}";
      return all;
   }
public int size()
{
 return messages.size();   
}
  
   @Override
   public void notifyAboutMessage(Message message)
   {
      
      notifyAll();
   }

   

  
}
