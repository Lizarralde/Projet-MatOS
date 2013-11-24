package objects;

/**
 * 
 * @author Fabien PINEL
 * 
 */
public class MatOS extends Material {
	private String	typeOS;

	public MatOS(String name, String description, String typeOS) {
		super(name, description);
		this.typeOS = typeOS;
		// TODO Auto-generated constructor stub
	}

	public String getTypeOS() {
		return typeOS;
	}

	public void setTypeOS(String typeOS) {
		this.typeOS = typeOS;
	}

}
