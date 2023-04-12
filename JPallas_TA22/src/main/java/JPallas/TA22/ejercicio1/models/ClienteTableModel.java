package JPallas.TA22.ejercicio1.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import JPallas.TA22.Java_SQL_Utils.Java_SQL;

public class ClienteTableModel extends AbstractTableModel {
	private List<Cliente> clientes;
	private String[] columnNames = { "ID", "Nombre", "Apellido", "Direccion", "DNI", "Fecha" };

	public ClienteTableModel() {
		this.clientes = new ArrayList<Cliente>();
		String DB = "ud22_1";
		Connection connection = Java_SQL.conectarDB();
		Java_SQL.useDB(DB, connection);
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM cliente;");
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String direccion = rs.getString("direccion");
				int dni = rs.getInt("dni");
				String fecha = rs.getString("fecha");
				Cliente cliente = new Cliente(nombre, apellido, direccion, dni, fecha);
				cliente.setId(id);
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

}
