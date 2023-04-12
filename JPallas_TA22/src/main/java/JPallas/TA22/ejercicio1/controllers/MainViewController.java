package JPallas.TA22.ejercicio1.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		view.btnAdd.addActionListener(btns);
		view.btnDel.addActionListener(btns);
		view.btnModify.addActionListener(btns);
		view.btnReset.addActionListener(btns);
	}

	ActionListener btns = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.btnReset) {
				view.textFieldApellido.setText("");
				view.textFieldDireccion.setText("");
				view.textFieldDNI.setText("");
				view.textFieldFecha.setText("");
				view.textFieldNombre.setText("");
			} else if (e.getSource() == view.btnAdd) {
				// Add to SQL and model
			} else if (e.getSource() == view.btnDel) {
				// Del from SQL and model
			} else if (e.getSource() == view.btnModify) {
				// Modify with actual values
			}

		}

	};

}
