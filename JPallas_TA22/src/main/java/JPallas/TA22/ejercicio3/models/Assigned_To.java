/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */

package JPallas.TA22.ejercicio3.models;

public class Assigned_To {

	// Attributes
	private String scientist_id;
	private String project_id;

	// Default constructor
	public Assigned_To() {
	}

	// Constructor with fields
	public Assigned_To(String s_id, String p_id) {
		this.scientist_id = s_id;
		this.project_id = p_id;
	}

	// Getters
	public String getScientist_id() {
		return scientist_id;
	}

	public String getProject_id() {
		return project_id;
	}

	// Setters
	public void setScientist_id(String scientist_id) {
		this.scientist_id = scientist_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

}
