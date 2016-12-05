package View;

import java.util.Observer;

import Controller.Controller;
import Controller.ClientController;

public interface View extends Observer
{
   public void start(ClientController controller);
 
public void UpdateMessages(String string);

public String getTextFieldInput();

public String getUserNameField();

public void setTextFieldInput();
}
