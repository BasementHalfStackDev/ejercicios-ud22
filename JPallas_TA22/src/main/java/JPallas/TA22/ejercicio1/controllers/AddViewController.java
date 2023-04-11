package JPallas.TA22.ejercicio1.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import JPallas.TA22.Java_SQL_Utils.Java_SQL;
import JPallas.TA22.ejercicio1.models.Cliente;
import JPallas.TA22.ejercicio1.views.AddView;

public class AddViewController {

	// Attributes
	private AddView view;
	private Cliente cliente;

	// Controller
	public AddViewController(AddView view) {
		this.view = view;
		this.cliente = cliente;
		view.btnAdd.addActionListener(addbtn);
	}

	// Action listener for the button
	ActionListener addbtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Gets values from textboxes
			String nombre = view.textFieldNombre.getText();
			String apellido = view.textFieldApellido.getText();
			String direccion = view.textFieldDireccion.getText();
			String DNI = view.textFieldDNI.getText();
			String fecha = view.textFieldFecha.getText();
			int intDNI = parseInt(DNI); // Converts to int if valid

			// Adds them to the cliente object
			cliente = new Cliente(nombre, apellido, direccion, intDNI, fecha);

			// Executes SQL statement to add
			executeSQL(cliente);

			// Clears textfields
			clearFields();
		}
	};

	// Parses String to int, returning 0 if invalid
	public int parseInt(String DNI) {
		int intDNI = 0;
		try {
			intDNI = Integer.parseInt(DNI);
			return intDNI;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "Invalid DNI, set default to 0");
			return 0;
		}
	}

	// Function to clear text fields
	public void clearFields() {
		view.textFieldNombre.setText("");
		view.textFieldApellido.setText("");
		view.textFieldDireccion.setText("");
		view.textFieldDNI.setText("");
		view.textFieldFecha.setText("");
	}

	// Executes SQL, adding the Cliente object to database
	public void executeSQL(Cliente cliente) {
		Connection connection = Java_SQL.conectarDB();
		try {
			String QueryDB = "USE ud22_1;"; // DB to use
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(QueryDB);

			// Query
			String query = "INSERT INTO cliente (nombre, apellido, direccion, DNI, fecha) VALUES (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);

			// Adds values to query
			statement.setString(1, cliente.getNombre());

			statement.setString(2, cliente.getApellido());

			statement.setString(3, cliente.getDireccion());

			statement.setInt(4, cliente.getDNI());

			// Manually add null to date if null to avoid errors
			if (cliente.getDate().equals("NULL")) {
				statement.setNull(5, java.sql.Types.DATE);
				JOptionPane.showMessageDialog(view, "Invalid date, set default to NULL");
			} else {
				statement.setString(5, cliente.getDate());
			}

			// Execute query
			statement.executeUpdate();

			// Confirmation message
			JOptionPane.showMessageDialog(view, "Client added successfully");
			Java_SQL.closeConnection(connection);

		} catch (SQLException e) {
			// Error message if exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(view, "Error when exectuting the query");
		}

	}

}
