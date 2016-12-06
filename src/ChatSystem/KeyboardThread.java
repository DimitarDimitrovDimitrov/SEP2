package ChatSystem;

import java.util.Scanner;

import Adapter.Database;

public class KeyboardThread implements Runnable
{
   Scanner keyboard = new Scanner(System.in);
     Database db;
   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            if (keyboard.nextLine().equals("Retrieve"))
            {
               db.readData();
            }
         }
         catch (Exception ex)
         {

         }
      }

   }
}
