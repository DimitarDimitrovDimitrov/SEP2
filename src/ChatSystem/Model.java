package ChatSystem;


import java.util.Observer;

import Model.Message;

public interface Model extends Observer // we made it implement  observable 
{
   public void add(Message message);
   public void notifyAboutMessage(Message message);
}
