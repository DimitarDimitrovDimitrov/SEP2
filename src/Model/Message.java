package Model;
import java.io.Serializable;

public class Message implements Serializable
{/**
	 * @author Oleg,Dimitar,Todor;
	 * 
	 */
	/**
	 * this is the Message  class. It is a class  from which the user's messages are called  and later transfered
	 * the class is necessary for the implementation of the whole system as it creates a message. 
	 */
	
   private int id;
   private String messageBody;
   private boolean isMessage;
  

   public Message(int id, String message)
   {
      this.id = id;
      this.messageBody = message;
      if (message == null)
      {
         this.messageBody = "";
      }
   }

   public Message(String message, boolean isMessage)
   {
      this(0, message);
      this.isMessage = isMessage;

      setId((int) (messageBody.hashCode() * Math.random()));
   }

   /**

    */
   /**
    * this is the get ID  Method. It is  method which prints out an id unique for every message.
     
    */
   
   
   public int getId()
   {
      return id;
   }

   
   
   public void setId(int id)
   {
      this.id = id;
   }

   public String getBody()
   {
      return messageBody;
   }

   public String toString()
   {
      return "id=" + id + ", \"" + messageBody + "\"";
   }

   /**
    
    * this is the getIsMessage method. It is  method which is used to identify messages from user names so they can be send accordingly.
    * the method is necessary for the implementation of the system because it s used to distinguish user names from messages. 
    */
   public boolean getIsMessage()
   {
      return isMessage;
   }

}
