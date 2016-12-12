package ChatSystem;

import java.util.Scanner;

import Adapter.Adapter;
import Adapter.AdapterInterface;

import Model.Messages;

public class KeyboardThread implements Runnable
{
   Scanner keyboard = new Scanner(System.in);
   
   AdapterInterface ai = new Adapter("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres","postgres","pass");
   
   
     Messages list=new Messages();
   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            if (keyboard.nextLine().equals("Retrieve"))
            {
               ai.Read();
               System.out.println(list.getAll()+"messages");
            }
         }
         catch (Exception ex)
         {

         }
      }// coooment

   }
}
