package JPallas.TA22.ejercicio2.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import JPallas.TA22.Java_SQL_Utils.Java_SQL;

public class VideosTableModel {

	// Table attributes
	private List<Videos> videos;
	private String[] columnNames = { "ID", "Title", "Director", "Cliente" };
	private String DB = "ud22_1";
	private Connection connection;
	private String table = "videos";

	// Generate table based on SQL data
	public VideosTableModel() {
		updateTable();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Videos video = videos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return video.getId();
		case 1:
			return video.getTitle();
		case 2:
			return video.getDirector();
		case 3:
			return video.getCli_id();
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

	public List<Videos> getVideos() {
		return videos;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setVideos(List<Videos> videos) {
		this.videos = videos;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	// Function to display table data from SQL table
	public void updateTable() {
		this.videos = new ArrayList<Videos>();
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + ";");
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String director = rs.getString("director");
				int cli_id = rs.getInt("cli_id");
				Videos video = new Videos(id, title, director, cli_id);
				videos.add(video);
			}
			statement.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to add given Video to DB
	public void addClienteToDB(Videos video) {
		// Make connection, use DB and create query
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "INSERT INTO " + table + " (title, director, cli_id) " + "VALUES (?,?,?);";

		try {
			// Make statement with Video fields
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, video.getTitle());
			pStatement.setString(2, video.getDirector());
			pStatement.setInt(3, video.getCli_id());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Video added successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to delete Video from DB by row index
	public void deleteCliente(int index) {
		// Get Video from index
		Videos video = videos.get(index);

		// Get ID
		int videoID = video.getId();

		// Remove from SQL
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "DELETE FROM " + table + " WHERE id = " + videoID + ";";

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "User deleted successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);

			statement.close();
			connection.close();
			// Remove from table
			videos.remove(index);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to update Cliente
	public void updateCliente(Cliente cliente) {
			// Make connection, use DB and create query
			connection = Java_SQL.conectarDB();
			Java_SQL.useDB(DB, connection);
			String query = "UPDATE " + table + " SET nombre=?, apellido=?, direccion=?, dni=?, fecha=? WHERE id=?;";
			try {
				// Make statement to update cliente with fields
				PreparedStatement pStatement = connection.prepareStatement(query);
				pStatement.setString(1, cliente.getNombre());
				pStatement.setString(2, cliente.getApellido());
				pStatement.setString(3, cliente.getDireccion());
				pStatement.setInt(4, cliente.getDNI());
				pStatement.setString(5, cliente.getDate());
				pStatement.setInt(6, cliente.getId());

				// Execute statement and close if success
				pStatement.executeUpdate();
				JOptionPane.showMessageDialog(null, "User modified successfully", "Success!",
						JOptionPane.INFORMATION_MESSAGE);
				pStatement.close();
				connection.close();
				updateTable();

			} catch (SQLException e) {
				e.printStackTrace();
			}

}
