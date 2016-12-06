package Facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
   private Connection conn;
   private Statement stmt;

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

   

   public void writeData(int id, String data) throws SQLException
   {
      String sql = "INSERT INTO `Sep2` (ID, DATA) values ('" + id + "', '"
            + data + "')";
      stmt.executeUpdate(sql);
   }

   public String readData() throws SQLException
   {
      String data = null;
      String sql = "SELECT * FROM `Sep2` WHERE ID = 1";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next())
      {
         data = rs.getString("DATA");
      }
      return data;
   }
}