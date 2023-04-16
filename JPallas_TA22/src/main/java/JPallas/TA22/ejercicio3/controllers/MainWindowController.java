package JPallas.TA22.ejercicio3.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JPallas.TA22.ejercicio3.views.MainWindow;

public class MainWindowController {

	// View
	private MainWindow view;
	public static int scientistWindowsOpen = 0;
	public static int projectWindowsOpen = 0;
	public static int assignationWindowsOpen = 0;

	// Controller with view
	public MainWindowController(MainWindow view) {
		this.view = view;
		view.btnScientists.addActionListener(btns);
		view.btnProjects.addActionListener(btns);
		view.btnAssignations.addActionListener(btns);
	}

	ActionListener btns = new ActionListener() {

		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.btnScientists) {
				if (scientistWindowsOpen == 0) {
					scientistWindowsOpen++;

				}
			}
			if (e.getSource() == view.btnProjects) {
				if (projectWindowsOpen == 0) {
					projectWindowsOpen++;

				}

			}
			if (e.getSource() == view.btnAssignations) {
				if (assignationWindowsOpen == 0) {
					assignationWindowsOpen++;

				}
			}

		}

	};

}
