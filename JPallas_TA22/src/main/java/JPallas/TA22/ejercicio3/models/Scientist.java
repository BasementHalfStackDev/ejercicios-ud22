package JPallas.TA22.ejercicio3.models;

import javax.swing.JOptionPane;

public class Scientist {

	// Attributes
	private String DNI;
	private String namSurnam;

	// Default Constructor
	public Scientist() {
	}

	// Constructor with attributes
	public Scientist(String DNI, String namSurnam) {
		this.DNI = DNI;
		this.namSurnam = namSurnam;
	}

	// Getters
	public String getDNI() {
		return DNI;
	}

	public String getNamSurnam() {
		return namSurnam;
	}

	// Setters
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public void setNamSurnam(String namSurnam) {
		this.namSurnam = namSurnam;
	}

	// Functions
	// DNI Validator that checks length and use of letter
	public static boolean dniValidator(String DNI) {
		int numCounter = 0; // Start counter of number
		try {
			char letter = DNI.charAt(8); // Get letter at last position
			for (int i = 0; i < DNI.length(); i++) { // Count ammount of numbers
				char c = DNI.charAt(i);
				if (Character.isDigit(c)) {
					numCounter++;
				}
			}
			if (DNI.length() == 9 && Character.isLetter(letter) && numCounter == 8) {
				return true; // Returns DNI if it has the specified length with last char letter and 8
								// numbers
			} else {
				throw new IllegalArgumentException( // Else, throws exception
						"Invalid DNI Format! Must be 8 numbers and 1 letter ex: (12345678X)");
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (StringIndexOutOfBoundsException e) { // If string is too short and goes out of bounds
			JOptionPane.showMessageDialog(null, "DNI Length too short");
		}
		return false;
	}

	// String length validator. Should've made a class for validators but no time
	// :')
	public static boolean strLenCheck(String string, int l) {
		if (string.length() > l || string.length() == 0) {
			JOptionPane.showMessageDialog(null, "Invalid String length");
			return false;
		} else {
			return true;
		}
	}

}
