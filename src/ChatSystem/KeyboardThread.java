package ChatSystem;

import java.util.Scanner;

import Adapter.Adapter;
import Adapter.Database;

public class KeyboardThread implements Runnable
{
   Scanner keyboard = new Scanner(System.in);
     Adapter db;
   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            if (keyboard.nextLine().equals("Retrieve"))
            {
               db.Read();
            }
         }
         catch (Exception ex)
         {

         }
      }

   }
}
