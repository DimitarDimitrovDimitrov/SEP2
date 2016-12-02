package Controller;

import java.util.Observable;

import ChatSystem.Model;
import Controller.Controller;
import Model.Message;
import View.View;


public class ClientController implements Controller
{
   private Model model;
   private View view; 

   public ClientController(Model model, View view)
   {
      this.model = model;
      this.view = view;   
      ((Observable) this.model).addObserver(view);
   }

   public void execute(String message)
   {
      if  (message.equals("Send"))
      {
         
            String input = view.getAndRemoveInput();
            if (input.length() > 0)
            {
               model.addMessage(new Message(input));
            }
            else if (message.equals("Quit"))
            {
            System.exit(0);
            }
      }
   }

}