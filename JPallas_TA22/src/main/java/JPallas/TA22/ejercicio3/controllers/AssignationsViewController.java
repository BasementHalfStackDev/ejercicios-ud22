package JPallas.TA22.ejercicio3.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import JPallas.TA22.ejercicio3.models.AssignedToTableModel;
import JPallas.TA22.ejercicio3.models.Assigned_To;
import JPallas.TA22.ejercicio3.models.Project;
import JPallas.TA22.ejercicio3.models.Scientist;
import JPallas.TA22.ejercicio3.views.AssignationsView;

public class AssignationsViewController {

	// Attributes
	private AssignationsView view; // View
	private AssignedToTableModel tableModel; // Table Model
	TableRowSorter<AssignedToTableModel> sorter; // Sorter

	public AssignationsViewController(AssignationsView view) {
		this.view = view;
		this.tableModel = new AssignedToTableModel(); // Create Model
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
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set Default close operation
		view.addWindowListener(window); // Window Listener to reset instances on close
	}

	// Buttons action listener
	ActionListener btns = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// If button is reset, resets text fields
			if (e.getSource() == view.btnReset) {
				resetTextFields();
			}
			// If button is add, adds Assignation info to DB and table
			if (e.getSource() == view.btnAdd) {
				Assigned_To assigned_to = new Assigned_To();

				if (!Scientist.dniValidator(view.textFieldScientist.getText())) { // Check if not valid
					return;
				}

				assigned_to.setScientist_id(view.textFieldScientist.getText());

				if (!Project.idCheck(view.textFieldProject.getText())) { // Check if not valid
					return;
				}

				assigned_to.setProject_id(view.textFieldProject.getText());

				// Adds assignation to DB and table model
				tableModel.addAssignationToDB(assigned_to);
				// Resets text fields
				resetTextFields();
				// Updates table data
				tableModel.fireTableDataChanged();
			}
			// If button is del, delete selected Assignation
			if (e.getSource() == view.btnDel) {
				// Delete selected Assignation
				int modelRow = view.table.convertRowIndexToModel(view.table.getSelectedRow());
				tableModel.deleteAssignation(modelRow);
				// Resets text fields
				resetTextFields();
				// Update table data
				tableModel.fireTableDataChanged();
			}
			// If button is modify, modify selected Assignation
			if (e.getSource() == view.btnModify) {
				// Check if the row is selected
				if (view.table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "No scientist Selected", "Error!",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				Assigned_To assigned_to = new Assigned_To();

				if (!Scientist.dniValidator(view.textFieldScientist.getText())) { // Check if not valid
					return;
				}

				assigned_to.setScientist_id(view.textFieldScientist.getText());

				if (!Project.idCheck(view.textFieldProject.getText())) { // Check if not valid
					return;
				}

				assigned_to.setProject_id(view.textFieldProject.getText());

				// Get past scientist and project before modifying
				int modelRow = view.table.convertRowIndexToModel(view.table.getSelectedRow());
				String pastScientist = (String) tableModel.getValueAt(modelRow, 0);
				String pastProject = (String) tableModel.getValueAt(modelRow, 1);

				// Modifies Assignation in DB and table model
				tableModel.updateAssignation(assigned_to, pastScientist, pastProject);
				// Resets text fields
				resetTextFields();
				// Updates table data
				tableModel.fireTableDataChanged();
			}
		}
	};

	// Table mouse listener
	MouseListener tblListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			// Gets clicked selected row and puts values in text fields
			int row = view.table.getSelectedRow();
			// Convert row to model row to select the correct row when Filtering
			int modelRow = view.table.convertRowIndexToModel(row);
			view.textFieldScientist.setText((String) tableModel.getValueAt(modelRow, 0));
			view.textFieldProject.setText((String) tableModel.getValueAt(modelRow, 1));
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

	// Window Listener
	WindowListener window = new WindowListener() {

		public void windowOpened(WindowEvent e) {
		}

		// Once closing the view, set instances to 0
		public void windowClosing(WindowEvent e) {
			MainWindowController.assignationWindowsOpen = 0;
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowActivated(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

	};

	// Function to reset textFields and table selection
	public void resetTextFields() {
		view.table.clearSelection();
		view.textFieldProject.setText("");
		view.textFieldScientist.setText("");
		view.textFieldSearch.setText("");
	}

}
