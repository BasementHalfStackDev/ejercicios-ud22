/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */

package JPallas.TA22.ejercicio3;

import java.awt.EventQueue;

import JPallas.TA22.ejercicio3.controllers.MainWindowController;
import JPallas.TA22.ejercicio3.views.MainWindow;

public class ejercicio3_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
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
