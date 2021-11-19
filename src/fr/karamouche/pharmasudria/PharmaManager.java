package fr.karamouche.pharmasudria;

import java.util.ArrayList;

import fr.karamouche.pharmasudria.menu.Fenetre;

public class PharmaManager {
	final String nom;
	final ArrayList<Client> listeClients = new ArrayList<Client>();
	final ArrayList<Medic> listeMedic = new ArrayList<Medic>();
	public PharmaManager(String nom) {
		this.nom = nom;
	}
	
	public ArrayList<Client> getListeClients(){
		return this.listeClients;
	}
	public ArrayList<Medic> getListeMedic(){
		return this.listeMedic;
	}
	
	public void menu() {
		Fenetre fenetre = new Fenetre(this.nom, this);
		fenetre.setVisible(true);
	}
	
	public String newClient(String nSecu, String nom, String prenom, String adresse, String nTelephone) throws InvalidSecuriteSocialeFormat{
		boolean existId = false;
		for(Client element : this.listeClients) {
			if(element.getSecu() == nSecu)
				existId = true;
		}
		if(!existId) {
			if(nSecu.length() < 13)
				throw new InvalidSecuriteSocialeFormat("Votre numéro de sécurité sociale doit faire au moins 13 caractères");
			Client client = new Client(nSecu, nom, prenom, adresse, nTelephone);
			this.listeClients.add(client);
			return "Le client a bien été créé au nom de "+client.getFullName()+" avec le numéro de SS: "+client.getSecu();
			//IF nSECU > 13 (throw InvalidSecuriteSocialeFormat)
}
		else
			return null;
	}
	
	public String newMedic(String ref, String nom, String desc, int quantite, float prix) {
		if(!existMedic(ref)) {
			if(ref != null && nom != null && desc != null) {
				Medic medic = new Medic(ref, nom, desc, quantite, prix);
				this.listeMedic.add(medic);
				return "Le médicament "+medic.getNom()+" au prix de "+medic.getPrix()+" a bien été ajouté.";
			}
			return null;
		}
		return null;
	}
	

	public boolean existMedic(String ref) {
		for(Medic medic : listeMedic) {
			if(medic.REF == ref)
				return true;
		}
		return false;
	}

}
