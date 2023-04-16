package JPallas.TA22.ejercicio3.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import JPallas.TA22.Java_SQL_Utils.Java_SQL;

@SuppressWarnings("serial")
public class ScientistTableModel extends AbstractTableModel {

	// Table attributes
	private List<Scientist> scientists;
	private String[] columnNames = { "DNI", "Name and Surname" };
	private String DB = "ud22_3";
	private Connection connection;
	private String table = "scientists";

	public ScientistTableModel() {
		updateTable();
	}

	// Functions
	public int getRowCount() {
		return scientists.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Scientist scientist = scientists.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return scientist.getDNI();
		case 1:
			return scientist.getNamSurnam();
		default:
			return null;
		}
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public boolean isCellEditable(int row, int col) {
		// Make all cells non editable for read-only table
		return false;
	}

	public List<Scientist> getScientists() {
		return scientists;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setScientists(List<Scientist> scientists) {
		this.scientists = scientists;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	// Function to display table data from SQL table
	public void updateTable() {
		this.scientists = new ArrayList<Scientist>();
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + ";");
			while (rs.next()) {
				String DNI = rs.getString("dni");
				String namSurnam = rs.getString("name_surname");
				Scientist scientist = new Scientist(DNI, namSurnam);
				scientists.add(scientist);
			}
			statement.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to add given Scientist to DB
	public void addScientistToDB(Scientist scientist) {
		// Make connection, use DB and create query
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "INSERT INTO " + table + " (DNI, name_surname) " + "VALUES (?,?);";

		try {
			// Make statement with Video fields
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, scientist.getDNI());
			pStatement.setString(2, scientist.getNamSurnam());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Scientist added successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to delete Scientist from DB by row index
	public void deleteScientist(int index) {
		// Get Scientist from index
		Scientist scientist = scientists.get(index);

		// Get ID
		String scientistID = scientist.getDNI();

		// Remove from SQL
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "DELETE FROM " + table + " WHERE dni = '" + scientistID + "';";

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Scientist deleted successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);

			statement.close();
			connection.close();
			// Remove from table
			scientists.remove(index);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to update Scientist
	public void updateScientist(Scientist scientist, String pastDNI) {
		// Make connection, use DB and create query
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "UPDATE " + table + " SET dni=?, name_surname=? WHERE dni=?;";
		try {
			// Make statement to update scientist with fields
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, scientist.getDNI());
			pStatement.setString(2, scientist.getNamSurnam());
			pStatement.setString(3, pastDNI);

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Scientist modified successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
