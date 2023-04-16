package JPallas.TA22.ejercicio2;

import java.awt.EventQueue;

import JPallas.TA22.ejercicio2.controllers.MainWindowController;
import JPallas.TA22.ejercicio2.views.MainWindow;

public class ejercicio2_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					MainWindowController controller = new MainWindowController(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
