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
public class ProjectTableModel extends AbstractTableModel {

	// Table attributes
	private List<Project> projects;
	private String[] columnNames = { "ID", "Name", "Hours" };
	private String DB = "ud22_3";
	private Connection connection;
	private String table = "projects";

	public ProjectTableModel() {
		updateTable();
	}

	// Functions
	public int getRowCount() {
		return projects.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Project project = projects.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return project.getId();
		case 1:
			return project.getName();
		case 2:
			return project.getHours();
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

	public List<Project> getProjects() {
		return projects;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	// Function to display table data from SQL table
	public void updateTable() {
		this.projects = new ArrayList<Project>();
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + ";");
			while (rs.next()) {
				String Id = rs.getString("id");
				String name = rs.getString("name");
				int hours = rs.getInt("hours");
				Project project = new Project(Id, name, hours);
				projects.add(project);
			}
			statement.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to add given Project to DB
	public void addProjectToDB(Project project) {
		// Make connection, use DB and create query
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "INSERT INTO " + table + " (id, name, hours) " + "VALUES (?,?,?);";

		try {
			// Make statement with Project fields
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, project.getId());
			pStatement.setString(2, project.getName());
			pStatement.setInt(3, project.getHours());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Project added successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to delete Project from DB by row index
	public void deleteProject(int index) {
		// Get Project from index
		Project project = projects.get(index);

		// Get ID
		String projectID = project.getId();

		// Remove from SQL
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "DELETE FROM " + table + " WHERE id = " + projectID + ";";

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Project deleted successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);

			statement.close();
			connection.close();
			// Remove from table
			projects.remove(index);
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
