package Nunc.Core.Libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DbHelper {
	
	public static Connection DbConnection() throws SQLException
	{		
		 String connectionUrl =
	                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
	                + "database=AdventureWorks;"
	                + "user=yourusername@yourserver;"
	                + "password=yourpassword;"
	                + "encrypt=true;"
	                + "trustServerCertificate=false;"
	                + "loginTimeout=30;";
		Connection connection = DriverManager.getConnection(connectionUrl);		
		return connection;
		
	}
	
	
	public static ResultSet ExecuteQuery(Connection connection,String selectSql ) throws SQLException
	{
		Statement statement;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return resultSet;
       
	}
	

}

