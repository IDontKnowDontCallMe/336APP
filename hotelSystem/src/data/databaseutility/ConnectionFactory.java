package data.databaseutility;

import java.sql.Connection;

public class ConnectionFactory {
	
	private static DatabaseConnection databaseConnection;
	
	public static Connection getDatabaseConnectionInstance(){
		if(databaseConnection==null){
			databaseConnection = new MySQLConnection();
		}
		return databaseConnection.getConnection();
	}

}
