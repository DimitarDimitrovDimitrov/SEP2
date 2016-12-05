package ChatSystem;

import java.util.Observable;



import Model.Messages;
import Model.Message;

public class ClientModelManager extends Observable implements Model
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
      super.setChanged();
      super.notifyObservers(message);
   }

   @Override
   public void update(Observable o, Object arg)
   {
      // TODO Auto-generated method stub
      
   }



 
}
