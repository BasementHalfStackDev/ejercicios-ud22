package JPallas.TA22.ejercicio1.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import JPallas.TA22.Java_SQL_Utils.Java_SQL;
import JPallas.TA22.ejercicio1.models.Cliente;
import JPallas.TA22.ejercicio1.models.ClienteTableModel;
import JPallas.TA22.ejercicio1.views.MainView;

public class MainViewController {

	private MainView view;
	private ClienteTableModel tableModel;

	public MainViewController(MainView view) {
		this.view = view;
		this.tableModel = new ClienteTableModel();
		view.table.setModel(tableModel);
		view.table.addMouseListener(tblListener);
		view.btnAdd.addActionListener(btns);
		view.btnDel.addActionListener(btns);
		view.btnModify.addActionListener(btns);
		view.btnReset.addActionListener(btns);
	}

	// Buttons action listener
	ActionListener btns = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// If button is reset, resets
			if (e.getSource() == view.btnReset) {
				resetTextFields();
			} else if (e.getSource() == view.btnAdd) {
				// Add to SQL and model
			} else if (e.getSource() == view.btnDel) {
				// Del from SQL and model
			} else if (e.getSource() == view.btnModify) {
				// Modify with actual values
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
		}
	};

	MouseListener tblListener = new MouseListener() {

		public void mouseClicked(MouseEvent e) {
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

	// Function to reset textFields
	public void resetTextFields() {
		view.textFieldApellido.setText("");
		view.textFieldDireccion.setText("");
		view.textFieldDNI.setText("");
		view.textFieldFecha.setText("");
		view.textFieldNombre.setText("");
	}

}
