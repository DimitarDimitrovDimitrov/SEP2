package Facade;

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

   public void createConnection() throws SQLException
   {
      conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
   }

   public void createStatement() throws SQLException
   {
      stmt = conn.createStatement();
   }

   

   public void writeData() throws SQLException
   {
      for(int i=0;i<List.size();i++)
      {
      String sql = "INSERT INTO `Sep2` (Message) values ('" +""+List.getMessage(i)+""+ "')";
      stmt.executeUpdate(sql);
      }
   }

   public String readData() throws SQLException
   {
      String data = null;
      String sql = "SELECT * FROM `Sep2` WHERE ID = 1";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next())
      {
         data = rs.getString("Message");
      }
      return data;
   }
}