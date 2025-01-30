package book.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(final String addressIp, final String addressPort, final String nameDatabase,final String user, String password) throws SQLException {
		
		return DriverManager.getConnection("jdbc:postgresql://"+ addressIp + ":" + addressPort + "/" + nameDatabase,user,password);
		
	}

}
