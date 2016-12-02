package ChatSystem;

import Model.Message;

public interface Model
{
   public void addMessage(Message message);
   public void notifyAboutMessage(Message message);
}
