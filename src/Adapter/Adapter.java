package Adapter;


import java.sql.SQLException;

import java.util.ArrayList;

import Model.Messages;

public class Adapter implements AdapterInterface
{
	
	/**
	 * @author Oleg,Dimitar,Todor;
	 * 
	 */
	/**
	 * this is the Adapter  class.this class accesses the methods from the My database it is used in the Adapter pattern
	 */
	
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
   
   
   /**
    
    * 
    */
   /**
    * this is the Write  Method. It is a method which uses  the a my database  an update method from my database class
    * the class is necessary for the implementation of the adapter as it writes messages to the database. 
    */
   
   
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
   
   
   
   /**
  
    */
   /**
    * this is the Read  Method. It is  method which uses  the a my database query  from my database class
    * the class is necessary for the implementation of the adapter as it reads messages the database. 
    */
   
   

   @Override
   public void Read()
   {
      try
      {
         
        String sql = "SELECT * FROM \"Sep2\".list;";
       
         ArrayList<Object[]> query = db.query(sql, null);
         for (int i=0;i<query.size();i++)
         {
            data=(String)query.get(i)[0];
            System.out.println(data );
         }
         
        
         
         
      }
      catch (SQLException e)
      {
      
        e.printStackTrace();
      }
     

   }
}
