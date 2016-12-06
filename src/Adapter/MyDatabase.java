package Adapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyDatabase
{
   private String url;
   private String user;
   private String pw;
   private Connection connection;
   
   private static final String DRIVER = "com.mysql.jdbc.Driver";
   private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
   private static final String USER = "postgres";
   private static final String PASSWORD = "pass";

}
