package JPallas.TA22.ejercicio1.models;

import java.util.Date;
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

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, String direccion, int DNI, String date) {
		this.nombre = string250CharValidator(nombre);
		this.apellido = string250CharValidator(apellido);
		this.direccion = string250CharValidator(direccion);
		this.DNI = DNIValidator(DNI);
		this.date = dateValidator(date);
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
		this.nombre = string250CharValidator(nombre);
	}

	public void setApellido(String apellido) {
		this.apellido = string250CharValidator(apellido);
	}

	public void setDireccion(String direccion) {
		this.direccion = string250CharValidator(direccion);
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
	public String string250CharValidator(String string) {
		if (string.length() > 250) {
			return "";
		}
		return string;
	}

	// Validate for DNI length between 8 and 11
	public int DNIValidator(int DNI) {
		int length = String.valueOf(DNI).length();
		if (length < 8 || length > 11) {
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
			return "";
		}
		return "";
	}

}
