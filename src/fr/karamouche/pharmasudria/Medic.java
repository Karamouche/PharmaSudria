package fr.karamouche.pharmasudria;

public class Medic {

	final String REF;
	final String nom;
	final String desc;
	int quantite;
	final float prix;
	
	
	public Medic(String ref, String nom, String desc, int quantite, float prix) {
		this.REF = ref;
		this.nom = nom;
		this.desc = desc;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrix() {
		return prix;
	}

	public String getREF() {
		return REF;
	}

	public String getNom() {
		return nom;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return this.getNom();
	}

}
