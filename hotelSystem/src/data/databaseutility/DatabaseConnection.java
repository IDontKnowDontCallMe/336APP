package data.databaseutility;
import java.sql.*;

public interface DatabaseConnection {
	
	public Connection getConnection();
	
	//public void close();

}
