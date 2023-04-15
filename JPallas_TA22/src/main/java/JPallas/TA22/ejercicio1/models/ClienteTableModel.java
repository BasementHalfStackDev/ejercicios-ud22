package JPallas.TA22.ejercicio1.models;

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

public class ClienteTableModel extends AbstractTableModel {

	// Table attributes
	private List<Cliente> clientes;
	private String[] columnNames = { "ID", "Nombre", "Apellido", "Direccion", "DNI", "Fecha" };
	private String DB = "ud22_1";
	private Connection connection;
	private String table = "cliente";

	// Generate table based on SQL data
	public ClienteTableModel() {
		updateTable();
	}

	// Functions
	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clientes.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return cliente.getId();
		case 1:
			return cliente.getNombre();
		case 2:
			return cliente.getApellido();
		case 3:
			return cliente.getDireccion();
		case 4:
			return cliente.getDNI();
		case 5:
			return cliente.getDate();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		// Make the first row non-editable
		return row > 0;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	// Function to display table data from SQL table
	public void updateTable() {
		this.clientes = new ArrayList<Cliente>();
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + ";");
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String direccion = rs.getString("direccion");
				int dni = rs.getInt("dni");
				String fecha = rs.getString("fecha");
				Cliente cliente = new Cliente(id, nombre, apellido, direccion, dni, fecha);
				clientes.add(cliente);
			}
			statement.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to add given Cliente to DB
	public void addClienteToDB(Cliente cliente) {
		// Make connection, use DB and create query
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "INSERT INTO " + table + " (nombre, apellido, direccion, dni, fecha) " + "VALUES (?,?,?,?,?);";

		try {
			// Make statement with cliente fields
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, cliente.getNombre());
			pStatement.setString(2, cliente.getApellido());
			pStatement.setString(3, cliente.getDireccion());
			pStatement.setInt(4, cliente.getDNI());
			pStatement.setString(5, cliente.getDate());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "User added successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Function to delete cliente from DB by row index
	public void deleteCliente(int index) {
		// Get cliente from index
		Cliente cliente = clientes.get(index);

		// Get ID
		int clienteID = cliente.getId();

		// Remove from SQL
		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "DELETE FROM " + table + " WHERE id = " + clienteID + ";";

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "User deleted successfully", "Success!",
					JOptionPane.INFORMATION_MESSAGE);

			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Remove from table
		clientes.remove(index);
	}

	public void updateCliente() {

	}

}
