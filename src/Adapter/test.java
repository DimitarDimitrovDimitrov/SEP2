package Adapter;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.junit.Test;

import Model.Message;
import Model.Messages;

public class test
{

   @Test
   public void test() throws ClassNotFoundException, FileNotFoundException, SQLException
   {
     // MyDatabase db = new MyDatabase("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
      String sql = "INSERT INTO \"Sep2\".list (message) values ('"+"message3"+ "')";
      //db.update(sql);
      AdapterInterface db2 = new Adapter("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
      Messages list = new Messages();
      Message m =new Message("MessgeList");
      
      
      list.add(m);
      db2.Write(list);
   }

}
