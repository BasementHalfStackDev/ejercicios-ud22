package JPallas.TA22.ejercicio3.models;

import javax.swing.JOptionPane;

public class Project {

	// Attributes
	private String id;
	private String name;
	private int hours;

	// Default Constructor
	Project() {
	}

	// Constructor with fields
	Project(String id, String name, int hours) {
		this.id = id;
		this.name = name;
		this.hours = hours;
	}

	// Getters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHours() {
		return hours;
	}

	// Setters
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	// Functions
	// Function to check correct id length
	public boolean idCheck(String id) {
		if (id.length() == 4) {
			return true;
		}
		return false;
	}

	// String length validator. Should've made a class for validators but no time
	// :')
	public boolean strLenCheck(String string, int l) {
		if (string.length() > l || string.length() == 0) {
			JOptionPane.showMessageDialog(null, "Invalid String length");
			return false;
		} else {
			return true;
		}
	}

}
