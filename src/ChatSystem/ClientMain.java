package ChatSystem;
import java.io.IOException;
import java.net.UnknownHostException;







import Controller.ClientController;
import Model.Messages;
import Model.Model;
import View.ChatView;
import View.View;

public class ClientMain
{
   public static void main(String args[]) throws IOException, 
                      UnknownHostException, ClassNotFoundException
   {
      View view = new ChatView();
      Model m=new Messages();
         ClientController c=new ClientController(m, view);

      view.start(c); 
      
    //eeeee
   }
}
