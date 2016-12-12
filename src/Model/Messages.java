package Model;



import java.util.ArrayList;

/**
 * @author Oleg,Dimitar,Todor;
 * 
 */
/**
 * this is the Messages class. It is a class which stores messages from the Message class .
 * the class is necessary for the implementation of the system because it stores messages which are later transfered to the database. 
 */



public class Messages implements Model
{
   private ArrayList<Message> messages;

   public Messages()
   {
      this.messages = new ArrayList<>();
   }

   /**
    
   /**
    * this is the getMessage  Method. It is a  method which collects messages from the arraylist.
    
    */
   
   public synchronized Message getMessage(int index)
   {
      return messages.get(index);
   }

   /**
    
    */
   /**
    This is the count Method. It is used to return the size of the messages arraylist. 
    */
   public synchronized int count()
   {
      return messages.size();
   }

   
   /**
  
   /**
    * This is the add method.It is a method which is used to add methods to the arraylist.

    */
   public synchronized void add(Message message)
   {
      messages.add(message);
   }
   
   /**
    * This is the Message[] get all method.It is used to create an array of type Message and store messages inside so they can all be printed out.
    */
   public synchronized Message[] getAll()
   {
      Message[] m = new Message[messages.size()];
      for (int i=0; i<messages.size(); i++)
      {
         m[i] = messages.get(i);
      }
      return m;
   }
   
   /**

    * 
  This is the Message[] remove All method.It is used to create an array of type message and delete all messages stored inside the array. 
    */
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
   /**
    * This is the size method.It is used to return the size of the messages arraylist.s
    
    */
   
public int size()
{
 return messages.size();   
}
  
   
   

  
}
