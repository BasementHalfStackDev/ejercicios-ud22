package JPallas.TA22.ejercicio2.models;

import java.util.Date;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cliente {

	// Client model with attributes
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int DNI;
	private String date;

	// Default constructor
	public Cliente() {
	}

	// Constructor with attributes
	public Cliente(int id, String nombre, String apellido, String direccion, int DNI, String date) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.DNI = DNI;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Cliente id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", DNI=" + DNI + ", date=" + date + "";
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getDNI() {
		return DNI;
	}

	public String getDate() {
		return date;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = strLenValidator(nombre, 250);
	}

	public void setApellido(String apellido) {
		this.apellido = strLenValidator(apellido, 250);
	}

	public void setDireccion(String direccion) {
		this.direccion = strLenValidator(direccion, 250);
	}

	public void setDNI(int DNI) {
		this.DNI = DNIValidator(DNI);
	}

	public void setDate(String date) {
		this.date = dateValidator(date);
	}

	// Methods
	// Validators
	// Validate x character varchars
	public static String strLenValidator(String string, int l) {
		if (string.length() > l) {
			JOptionPane.showMessageDialog(null, string + ". This field is longer than " + l + " characters.");
			return ""; // If invalid set empty string
		}
		return string;
	}

	// Validate for DNI length between 8 and 11
	public int DNIValidator(int DNI) {
		int length = String.valueOf(DNI).length();
		if (length < 8 || length > 11) {
			JOptionPane.showMessageDialog(null, "Dni invalid, setting default 0");
			return 0; // If invalid set 0
		}
		return DNI;
	}

	// Validate date format is valid and returns as String
	public String dateValidator(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);

		try {
			Date SQLdate = (Date) sdf.parse(date);
			String formattedDate = sdf.format(SQLdate);
			if (formattedDate.equals(date)) {
				return formattedDate;
			}
		} catch (ParseException e) {  // If invalid set null
			JOptionPane.showMessageDialog(null, "Fecha invalid format yyyy-mm-dd, setting NULL");
			return null;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Fecha invalid format yyyy-mm-dd, setting NULL");
			return null;
		}
		JOptionPane.showMessageDialog(null, "Fecha invalid format yyyy-mm-dd, setting NULL");
		return null;
	}

}
