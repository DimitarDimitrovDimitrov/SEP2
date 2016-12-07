package Adapter;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Messages;

public class Adapter implements AdapterInterface
{
   private MyDatabase db;
   private static final String DB_NAME = "Sep2";
   private static final String DRIVER = "org.postgresql.Driver";
   private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
   private static final String USER = "postgres";
   private static final String PASSWORD = "pass";
   private Messages List;

   public Adapter() throws ClassNotFoundException
   {
      this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
   }

   @Override
   public void Write()
   {
      try
      {
         
        

         for(int i=0;i<List.size();i++)
         {
        String  sql = "INSERT INTO `Sep2.Messages` (Messages) values ('" +""+List.getMessage(i)+""+ "')";
         try
         {
            db.updateAll(sql);
         }
         catch (FileNotFoundException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         }
      }
      catch(SQLException ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public String Read()
   {
      String sql = "SELECT Sep2.list";
       String data = null;
         sql = "SELECT * FROM `Sep2`";

        for (int i =0;i<List.size();i++)
         {
            data+=List.getMessage(i);
         }
         return data;
      }
}


