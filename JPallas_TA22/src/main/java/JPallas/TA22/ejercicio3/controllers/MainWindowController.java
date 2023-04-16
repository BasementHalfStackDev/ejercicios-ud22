package JPallas.TA22.ejercicio3.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JPallas.TA22.ejercicio3.views.MainWindow;
import JPallas.TA22.ejercicio3.views.ProjectView;
import JPallas.TA22.ejercicio3.views.ScientistView;

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
					ScientistView sview = new ScientistView();
					ScientistViewController svController = new ScientistViewController(sview);
				}
			}
			if (e.getSource() == view.btnProjects) {
				if (projectWindowsOpen == 0) {
					projectWindowsOpen++;
					ProjectView pview = new ProjectView();
					ProjectViewController pvController = new ProjectViewController(pview);
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
