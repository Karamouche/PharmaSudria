package fr.karamouche.pharmasudria;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client {
	final String nSecuSociale;
	final String nom;
	final String prenom;
	final String adresse;
	final String telephone;
	
	public Client(String nSecu, String nom, String prenom, String adresse, String nTelephone){
		this.nSecuSociale = nSecu;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = nTelephone;
	}

	public String getSecu() {
		return this.nSecuSociale;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}
	
	public String getTel() {
		return this.telephone;
	}
	public String getFullName() {
		return this.getPrenom() + " " + this.getNom();
	}
	
	@Override
	public String toString() {
		return this.getFullName();
	}
	
	public void showDetailWindow(JFrame frame) {
		String text = "Client : "+this.getFullName();
		text += "\nNuméro de SS : "+this.getSecu();
		text += "\nAdresse : "+this.getAdresse();
		text += "\nNuméro de téléphone : "+this.getTel();
		JOptionPane.showMessageDialog(frame, text, "Informations : "+this.getFullName(), JOptionPane.INFORMATION_MESSAGE);
	}

}
