package objets;

public class Materiel {
	private String	nom, descriptif;
	private int	   dureeEmpruntMax, dureeEmpruntUsuelle;
	
	public Materiel(String nom, String descriptif) {
		this.nom = nom;
		this.descriptif = descriptif;
		this.dureeEmpruntUsuelle = 7;
		this.dureeEmpruntMax = 200;
	}
	
	public Materiel(String nom, String descriptif, int dureeUsuelle) {
		this.nom = nom;
		this.descriptif = descriptif;
		this.dureeEmpruntUsuelle = dureeUsuelle;
		this.dureeEmpruntMax = 200;
	}
	
	public Materiel(String nom, String descriptif, int dureeUsuelle, int dureeMax) {
		this.nom = nom;
		this.descriptif = descriptif;
		this.dureeEmpruntUsuelle = dureeUsuelle;
		this.dureeEmpruntMax = dureeMax;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescriptif() {
		return descriptif;
	}
	
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	public int getDureeEmpruntMax() {
		return dureeEmpruntMax;
	}
	
	public void setDureeEmpruntMax(int dureeEmpruntMax) {
		this.dureeEmpruntMax = dureeEmpruntMax;
	}
	
	public int getDureeEmpruntUsuelle() {
		return dureeEmpruntUsuelle;
	}
	
	public void setDureeEmpruntUsuelle(int dureeEmpruntUsuelle) {
		this.dureeEmpruntUsuelle = dureeEmpruntUsuelle;
	}
}
