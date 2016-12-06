package Facade;



import java.sql.SQLException;
 
public class DatabaseFacade {
    private Database db;
     
    public DatabaseFacade() throws ClassNotFoundException {
        db = new Database();
    }
     
    public void init() throws SQLException {
        db.createConnection();
        db.createStatement();
        
    }
     
    public String readData() throws SQLException {
        return db.readData();
    }
     
    public void writeData() throws SQLException {
        db.writeData();
    }
}