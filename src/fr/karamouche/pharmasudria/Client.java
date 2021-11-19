package fr.karamouche.pharmasudria;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client {
	final String nSecuSociale;
	final String nom;
	final String prenom;
	final String adresse;
	final String telephone;
	
	public Client(String nSecu, String nom, String prenom, String adresse, String nTelephone) {
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
	
	/*
	public void showDetailWindow(JFrame frame) {
		String text = "Etudiant : "+this.getFullName();
		text += "\nMoyenne : ";
		int nNote = 0;
		double moyenne = 0;
		if(nNote !=0)
			moyenne = moyenne/nNote;
		moyenne = Math.round(moyenne*100)/100.0;
		text += moyenne;
		if(moyenne >= 10)
			text += " (admis)\n";
		else
			text += " (non admis)\n";
		text += "\nMatières :";
		for (Medic element : this.listeMatiere) {
			text += "\n"+element.getNom()+" : \n"
					+ "\tNote oral : "+element.getNotesOral().get(this)+"\n"
					+ "\tNote écrite : "+element.getNotesEcrit().get(this)+"\n";
		}
		JOptionPane.showMessageDialog(frame, text, "Informations : "+this.getFullName(), JOptionPane.INFORMATION_MESSAGE);
	}*/

}
