package Model;





import java.util.ArrayList;




public class Usernames 
{
   private ArrayList<Username> usernames;

   public Usernames()
   {
      this.usernames = new ArrayList<>();
   }

   public synchronized Username getMessage(int index)
   {
      return usernames.get(index);
   }

   public synchronized int count()
   {
      return usernames.size();
   }

   public synchronized void add(Username username)
   {
      usernames.add(username);
   }
   
   public synchronized Username[] getAll()
   {
      Username[] m = new Username[usernames.size()];
      for (int i=0; i<usernames.size(); i++)
      {
         m[i] = usernames.get(i);
      }
      return m;
   }

   public synchronized Username[] removeAll()
   {
      Username[] m = getAll();
  usernames.clear();
      return m;
   }

   public String toString()
   {
      Username[] m = getAll();
      String all = "UsernameList: {";
      for (int i = 0; i < m.length; i++)
      {
         all += m[i];
         if (i < m.length-1)
            all += "\n ";
      }
      all += "\n}";
      return all;
   }
public int size()
{
 return usernames.size();   
}
  
 
 

   

  
}