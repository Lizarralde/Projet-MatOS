package objects;

/**
 * 
 * @author Fabien PINEL
 * 
 */
public class MatOS extends Material {
	private TypeOS	typeOS;

	public MatOS(String name, String description, TypeOS typeOS) {
		super(name, description);
		this.typeOS = typeOS;
		// TODO Auto-generated constructor stub
	}

	public TypeOS getTypeOS() {
		return typeOS;
	}

	public void setTypeOS(TypeOS typeOS) {
		this.typeOS = typeOS;
	}

}
