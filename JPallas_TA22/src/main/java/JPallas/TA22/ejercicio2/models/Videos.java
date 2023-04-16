package JPallas.TA22.ejercicio2.models;

public class Videos {

	// Videos model with attributes
	private int id;
	private String title;
	private String director;
	private int cli_id;

	// Default constructor
	public Videos() {

	}

	// Constructor with attributes
	public Videos(int id, String title, String director, int cli_id) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.cli_id = cli_id;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public int getCli_id() {
		return cli_id;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = Cliente.strLenValidator(title, 250);
	}

	public void setDirector(String director) {
		this.director = Cliente.strLenValidator(director, 250);
	}

	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}
	
	

}
