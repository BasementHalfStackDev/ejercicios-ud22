package JPallas.TA22.ejercicio1;

import JPallas.TA22.ejercicio1.controllers.MainViewController;
import JPallas.TA22.ejercicio1.views.MainView;

public class ejercicio1_App {

	public static void main(String[] args) {
		// Initialise program and controller
		MainView view = new MainView();
		MainViewController vcontroller = new MainViewController(view);

	}

}
