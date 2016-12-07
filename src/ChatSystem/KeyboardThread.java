package ChatSystem;

import java.util.Scanner;

import Adapter.Adapter;
import Adapter.Database;
import Model.Messages;

public class KeyboardThread implements Runnable
{
   Scanner keyboard = new Scanner(System.in);
     Adapter db;
     Messages list;
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
               System.out.println(list.getAll()+"messages");
            }
         }
         catch (Exception ex)
         {

         }
      }

   }
}
