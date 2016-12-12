package Model;


import java.util.Observer;

/**
 * @author Oleg,Dimitar,Todor;
 * 
 */
/**
 * this is the Model  class. It is an interface  from which the class Message call  methods
 * the class is necessary for the implementation of the MVC pattern as this is  the Model 
 */


public interface Model // we made it implement  observable 
{
   public void add(Message message);
 
}
