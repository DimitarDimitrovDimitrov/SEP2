package View;

import java.util.Observer;

import Controller.Controller;
import Controller.ClientController;
/**
 *@author Oleg,Dimitar,Todor.
 *this is the view interface.
 *it is implemented by the view class.
 * 
 */
public interface View 
{
   public void start(ClientController controller);
 
public void UpdateMessages(String string);

public String getTextFieldInput();

public String getUserNameField();

public void setTextFieldInput();


public void updateOnlineUsers(String string);
}
