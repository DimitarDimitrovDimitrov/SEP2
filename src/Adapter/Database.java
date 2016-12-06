package Adapter;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Messages;

public class Database
{
   private Connection conn;
   private Statement stmt;
 private Messages List;

 
   public Database() throws ClassNotFoundException
   {
      Class.forName("org.sqlite.JDBC");
   }

   MyDatabase db = new MyDatabase("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");


  

   public void writeData() throws SQLException, FileNotFoundException
   {
      for(int i=0;i<List.size();i++)
      {
      String sql = "INSERT INTO `Sep2.list` (Messages) values ('" +""+List.getMessage(i)+""+ "')";
      db.updateAll(sql);
      }
     
   }

   public String readData() throws SQLException
   {
      String data = null;
      String sql = "SELECT * FROM `Sep2`";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next())
      {
         data = rs.getString("Message");
      }
      return data;
   }
}