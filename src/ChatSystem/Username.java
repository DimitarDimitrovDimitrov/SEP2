package ChatSystem;



import java.io.Serializable;

public class Username implements Serializable
{
  // private int id;
	
   private String usernamebody;

   public Username( String username)
   {
     // this.id = id;
      this.usernamebody = username;
      if (username == null)
      {
         this.usernamebody = "";
      }
   }
 
   
   
   
   
   
   public String getBody()
   {
      return usernamebody;
   }

   public String toString()
   {
      return  /*id +*/ ", \"" + usernamebody + "\"";
   }

}
