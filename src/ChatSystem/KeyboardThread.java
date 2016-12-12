package ChatSystem;

import java.util.Scanner;

import Adapter.Adapter;
import Adapter.AdapterInterface;

import Model.Messages;
/**
 * @author Oleg,Dimitar,Todor
 * 
 */

public class KeyboardThread implements Runnable
{
   Scanner keyboard = new Scanner(System.in);
   
   AdapterInterface ai = new Adapter("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres","postgres","pass");
   
   
     Messages list=new Messages();
   @Override
   
   
   
   /**
    * checks if the input from the user is equal to Retrieve.                          (1)
    * <p>
    *  if the user input is equal to Retrieve then it calls the Adapter which connects to the Database and retrieves all messages
    *  new Client that connected.
    * <p>
    * 
    * 
    * 
    */

   public void run()
   {
      while (true)
      {
         try
         {
            if (keyboard.nextLine().equals("Retrieve"))
            {
               ai.Read();
                
            }
         }
         catch (Exception ex)
         {

         }
      }// coooment

   }
}
