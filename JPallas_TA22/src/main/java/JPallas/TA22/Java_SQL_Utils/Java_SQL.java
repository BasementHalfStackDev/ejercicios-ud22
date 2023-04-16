/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */

package JPallas.TA22.Java_SQL_Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Java_SQL {

	// Function to establish connection with MySQL Database
	public static Connection conectarDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.177:3306", "java", "Java_R00t");
			return conexion;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection couldn't be established");
			System.out.println(e);
		}
		return null;
	}

	// Function to close connection
	public static void closeConnection(Connection conexion) {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Connection couldn't be closed");
			System.out.println(e);
		}
	}

	// Function to use Database
	public static void useDB(String DB, Connection connection) {
		try {
			String QueryDB = "USE " + DB + ";"; // DB to use
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(QueryDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
