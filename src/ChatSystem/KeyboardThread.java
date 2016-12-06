package ChatSystem;

import java.util.Scanner;

public class KeyboardThread implements Runnable
{
   Scanner keyboard = new Scanner(System.in);

   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            if (keyboard.nextLine().equals("Retrieve"))
            {
               System.out.println("Messages");
            }
         }
         catch (Exception ex)
         {

         }
      }

   }
}
