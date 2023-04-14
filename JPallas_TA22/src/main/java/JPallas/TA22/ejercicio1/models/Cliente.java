package JPallas.TA22.ejercicio1.models;

import java.util.Date;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cliente {

	// Client model with attributes
	private static int nextId = 1; // AutoIncrement
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int DNI;
	private String date;

	public Cliente() {
		this.id = nextId;
		nextId++;
	}

	public Cliente(String nombre, String apellido, String direccion, int DNI, String date) {
		this.id = nextId;
		this.nombre = strLenValidator(nombre, 250);
		this.apellido = strLenValidator(apellido, 250);
		this.direccion = strLenValidator(direccion, 250);
		this.DNI = DNIValidator(DNI);
		this.date = dateValidator(date);
		nextId++;
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
	// Validate 250 character varchars
	public String strLenValidator(String string, int l) {
		if (string.length() > l) {
			JOptionPane.showMessageDialog(null, string + ". This field is longer than " + l + " characters.");
			return "";
		}
		return string;
	}

	// Validate for DNI length between 8 and 11
	public int DNIValidator(int DNI) {
		int length = String.valueOf(DNI).length();
		if (length < 8 || length > 11) {
			JOptionPane.showMessageDialog(null, "Dni invalid, setting default 0");
			return 0;
		}
		return DNI;
	}

	// Validate date format is valid
	public String dateValidator(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);

		try {
			Date SQLdate = (Date) sdf.parse(date);
			String formattedDate = sdf.format(SQLdate);
			if (formattedDate.equals(date)) {
				return formattedDate;
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Fecha invalid, setting NULL");
			return "NULL";
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Fecha invalid, setting NULL");
			return "NULL";
		}
		return "NULL";
	}

}
