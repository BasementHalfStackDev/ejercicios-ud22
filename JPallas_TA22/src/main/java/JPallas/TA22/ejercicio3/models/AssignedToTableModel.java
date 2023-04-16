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
public class AssignedToTableModel extends AbstractTableModel {

	// Table attributes
	private List<Assigned_To> assignations;
	private String[] columnNames = { "Scientist", "Project" };
	private String DB = "ud22_3";
	private Connection connection;
	private String table = "assigned_to";

	public AssignedToTableModel() {
		updateTable();
	}

	// Functions
	public int getRowCount() {
		return assignations.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Assigned_To assigned_to = assignations.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return assigned_to.getScientist_id();
		case 1:
			return assigned_to.getProject_id();
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

	public List<Assigned_To> getAssignations() {
		return assignations;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setAssignations(List<Assigned_To> assignations) {
		this.assignations = assignations;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	// Function to display table data from SQL table
	public void updateTable() {
		this.assignations = new ArrayList<Assigned_To>();
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + ";");
			while (rs.next()) {
				String scientist = rs.getString("scientist");
				String project = rs.getString("project");
				Assigned_To assigned_to = new Assigned_To(scientist, project);
				assignations.add(assigned_to);
			}
			statement.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to add given Assignation to DB
	public void addProjectToDB(Assigned_To assigned_to) {
		// Make connection, use DB and create query
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "INSERT INTO " + table + " (scientist, project) " + "VALUES (?,?);";

		try {
			// Make statement with Assignation fields
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, assigned_to.getScientist_id());
			pStatement.setString(2, assigned_to.getProject_id());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Assignation added successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to delete Assignation from DB by row index
	public void deleteProject(int index) {
		// Get Assignation from index
		Assigned_To assigned_to = assignations.get(index);

		// Get ID
		String scientist_id = assigned_to.getScientist_id();
		String project_id = assigned_to.getProject_id();

		// Remove from SQL
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "DELETE FROM " + table + " WHERE scientist = " + scientist_id + " AND project = " + project_id
				+ ";";

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Assignation deleted successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);

			statement.close();
			connection.close();
			// Remove from table
			assignations.remove(index);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to update Project
	public void updateProject(Project project) {
		// Make connection, use DB and create query
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "UPDATE " + table + " SET id=?, name=?, hours=? WHERE id=?;";
		try {
			// Make statement to update project with fields
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, project.getId());
			pStatement.setString(2, project.getName());
			pStatement.setInt(3, project.getHours());
			pStatement.setString(4, project.getId());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Project modified successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
