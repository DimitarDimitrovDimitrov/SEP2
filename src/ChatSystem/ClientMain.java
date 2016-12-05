package ChatSystem;
import java.io.IOException;

import java.net.UnknownHostException;


import View.ChatView;

public class ClientMain
{
   public static void main(String args[]) throws IOException, 
                      UnknownHostException, ClassNotFoundException
   {
      ChatView view = new ChatView();

      view.start(); 
      
    
   }
}
