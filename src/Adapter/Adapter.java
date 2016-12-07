package Adapter;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
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

   String data = null;

   public Adapter(String Driver, String Url, String User, String Password)
   {
      try
      {
         this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public void Write(Messages list)
   {
      try
      {

         for (int i = 0; i < list.size(); i++)
         {
            String sql = "INSERT INTO \"Sep2\".list (message) values (\'" + list.getMessage(i).toString() + "\');";
            db.update(sql);
         }
      }
      catch (SQLException ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public void Read()
   {
      try
      {
         Connection c = null;
         String data = null;
         Statement stmt = null;
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "pass");
            c.setAutoCommit(false);
        String sql = "SELECT * FROM \"Sep2\".list;";
        stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next())
         {
            data=rs.getString(1);
            System.out.println(data );
         }
         
         
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
        e.printStackTrace();
      }
     

   }
}
