package objets;

public class MatOS extends Materiel {
	private String	typeOS;
	
	public MatOS(String nom, String descriptif, String typeOS) {
		super(nom, descriptif);
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
