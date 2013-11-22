package objects;

public class MatOS extends Materiel {
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
