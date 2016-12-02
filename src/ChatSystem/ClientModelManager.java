package ChatSystem;

import java.util.Observable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import chat.domain.model.Message;
import chat.domain.model.MessageList;


public class ClientModelManager extends Observable implements Model
{
   private MessageList list;
 
   public ClientModelManager()
   {
      list = new MessageList();
   }

   @Override
   public void addMessage(Message message)
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

 
}
