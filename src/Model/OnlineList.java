package Model;

import java.util.ArrayList;
//coooment
public class OnlineList
{
   private ArrayList<String> online;
   private String onlineuser;

   public OnlineList()
   {
      online = new ArrayList<String>();
   }

   public void add(String string)
   {
      online.add(string);
   }
   public String getUsers(int index)
   {
      return  online.get(index);
   }
   public int size()
   {
      return online.size();
   }

}
