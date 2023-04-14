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
	private List<Cliente> clientes;
	private String[] columnNames = { "ID", "Nombre", "Apellido", "Direccion", "DNI", "Fecha" };
	private String DB = "ud22_1";
	private Connection connection;
	private String table = "cliente";

	public ClienteTableModel() {
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
				Cliente cliente = new Cliente(nombre, apellido, direccion, dni, fecha);
				clientes.add(cliente);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

	public void updateTable() {

	}

	public void addClienteToDB(Cliente cliente) {
		clientes.add(cliente);

		connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		String query = "INSERT INTO " + table + " (id, nombre, apellido, direccion, dni, fecha) "
				+ "VALUES (?,?,?,?,?,?);";

		try {
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, cliente.getId());
			pStatement.setString(2, cliente.getNombre());
			pStatement.setString(3, cliente.getApellido());
			pStatement.setString(4, cliente.getDireccion());
			pStatement.setInt(5, cliente.getDNI());
			pStatement.setString(6, cliente.getDate());

			pStatement.executeUpdate();
			connection.close();

			JOptionPane.showMessageDialog(null, "Cliente added successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCliente() {

	}

	public void updateCliente() {

	}

}
