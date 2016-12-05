package View;

import java.util.Observer;

import Controller.Controller;
import Controller.ClientController;

public interface View extends Observer
{
   public void start(Controller controller);
  public void displayMessage(String message);
}
