package Model;


import java.util.Observer;

public interface Model // we made it implement  observable 
{
   public void add(Message message);
   public void notifyAboutMessage(Message message);
}
