package Model;

import java.io.Serializable;

public class Username implements Serializable
{
   
   private String usernameBody;

   public Username( String username)
   {
    
      this.usernameBody = username;
      if (username == null)
      {
         this.usernameBody = "";
      }
   }
  

   public String getBody()
   {
      return usernameBody;
   }

   public String toString()
   {
      return " " + usernameBody + "\"";
   }

}
