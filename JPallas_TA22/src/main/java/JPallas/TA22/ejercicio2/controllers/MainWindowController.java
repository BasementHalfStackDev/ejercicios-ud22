package JPallas.TA22.ejercicio2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JPallas.TA22.ejercicio2.views.ClienteView;
import JPallas.TA22.ejercicio2.views.MainWindow;
import JPallas.TA22.ejercicio2.views.VideosView;

public class MainWindowController {

	// View
	private MainWindow view;
	public static int clienteWindowsOpen = 0;
	public static int videosWindowsOpen = 0;

	// Controller with view
	public MainWindowController(MainWindow view) {
		this.view = view;
		view.btnClientes.addActionListener(btns);
		view.btnVideos.addActionListener(btns);
	}

	ActionListener btns = new ActionListener() {

		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.btnClientes) {
				if (clienteWindowsOpen == 0) {
					ClienteView cview = new ClienteView();
					ClienteViewController cvController = new ClienteViewController(cview);
					clienteWindowsOpen++;
				}
			}
			if (e.getSource() == view.btnVideos) {

				if (videosWindowsOpen == 0) {
					VideosView vview = new VideosView();
					VideosViewController vvController = new VideosViewController(vview);
					videosWindowsOpen++;
				}

			}

		}

	};

}
