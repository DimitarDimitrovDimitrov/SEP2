package Model;

import java.util.Observable;



//coooment

public class ClientModelManager  implements Model
{
   private Messages list;
 
   public ClientModelManager()
   {
      list = new Messages();
   }

   @Override
   public void add(Message message)
   {
      list.add(message);
      notifyAboutMessage(message);
   }

   @Override
   public void notifyAboutMessage(Message message)
   {
      // TODO Auto-generated method stub
      
   }

   



 
}
