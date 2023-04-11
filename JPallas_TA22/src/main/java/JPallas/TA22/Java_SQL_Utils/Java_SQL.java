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

	// Function to create Databases
	public static void createDB(String name, Connection conexion) {
		try {
			String query = "CREATE DATABASE " + name + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			System.out.println("DB " + name + " created succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to create tables with fields
	public static void createTable(Connection conexion, String DB, String tablename, String tablefields) {
		try {
			String QueryDB = "USE " + DB + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);

			Statement st = conexion.createStatement();
			String finalQuery = "CREATE TABLE " + tablename + " " + tablefields + ";";
			st.executeUpdate(finalQuery);
			System.out.println("Table created succesfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error creating table");
		}
	}

	// Function to insert values to DB Tables
	public static void insertData(Connection conexion, String DB, String tablename, String values) {
		try {
			String QueryDB = "USE " + DB + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);

			String finalQuery = "INSERT INTO " + tablename + " " + values + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(finalQuery);
			System.out.println("Values inserted succesfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error when inserting values to table " + tablename);
		}
	}

}
