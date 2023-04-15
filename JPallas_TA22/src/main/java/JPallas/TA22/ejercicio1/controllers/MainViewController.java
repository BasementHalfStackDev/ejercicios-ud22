package JPallas.TA22.ejercicio1.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import JPallas.TA22.Java_SQL_Utils.Java_SQL;
import JPallas.TA22.ejercicio1.models.Cliente;
import JPallas.TA22.ejercicio1.models.ClienteTableModel;
import JPallas.TA22.ejercicio1.views.MainView;

public class MainViewController {

	// Attributes
	private MainView view; // View
	private ClienteTableModel tableModel; // Table Model
	TableRowSorter<ClienteTableModel> sorter; // Sorter

	public MainViewController(MainView view) {
		this.view = view;
		this.tableModel = new ClienteTableModel(); // Create Model
		view.table.setModel(tableModel); // Set model to view table
		view.table.addMouseListener(tblListener); // Add Mouse listener to table
		// Action listener to buttons
		view.btnAdd.addActionListener(btns);
		view.btnDel.addActionListener(btns);
		view.btnModify.addActionListener(btns);
		view.btnReset.addActionListener(btns);
		sorter = new TableRowSorter<>(tableModel); // Create sorter based on model
		view.table.setRowSorter(sorter); // Add sorter to table
		view.textFieldSearch.addKeyListener(searchBar); // Add key listener to searchbar
	}

	// Buttons action listener
	ActionListener btns = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// If button is reset, resets text fields
			if (e.getSource() == view.btnReset) {
				resetTextFields();
			}

			// If button is add, adds client info to DB and table
			if (e.getSource() == view.btnAdd) {
				Cliente cliente = new Cliente();
				cliente.setNombre(view.textFieldNombre.getText());
				cliente.setApellido(view.textFieldApellido.getText());
				cliente.setDireccion(view.textFieldDireccion.getText());
				cliente.setDNI(Integer.parseInt(view.textFieldDNI.getText()));
				cliente.setDate(view.textFieldFecha.getText());

				// Adds cliente to DB and table model
				tableModel.addClienteToDB(cliente);
				// Resets text fields
				resetTextFields();
				// Updates table data
				tableModel.fireTableDataChanged();
			}

			// If button is del, delete selected client
			if (e.getSource() == view.btnDel) {
				// Delete selected client
				tableModel.deleteCliente(view.table.getSelectedRow());
				// Resets text fields
				resetTextFields();
				// Update table data
				tableModel.fireTableDataChanged();
			}
		}
	};

	// Table mouse listener
	MouseListener tblListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			// Gets clicked selected row and puts values in text fields
			int row = view.table.getSelectedRow();
			view.textFieldNombre.setText((String) tableModel.getValueAt(row, 1));
			view.textFieldApellido.setText((String) tableModel.getValueAt(row, 2));
			view.textFieldDireccion.setText((String) tableModel.getValueAt(row, 3));
			view.textFieldDNI.setText((String) tableModel.getValueAt(row, 4).toString());
			view.textFieldFecha.setText((String) tableModel.getValueAt(row, 5));
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	};

	// Search bar Key adapter
	KeyAdapter searchBar = new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			// Gets input written in search bar, and displays rows that contain the written
			// text
			String query = view.textFieldSearch.getText();
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
		}
	};

	// Function to reset textFields
	public void resetTextFields() {
		view.textFieldApellido.setText("");
		view.textFieldDireccion.setText("");
		view.textFieldDNI.setText("");
		view.textFieldFecha.setText("");
		view.textFieldNombre.setText("");
	}

}
