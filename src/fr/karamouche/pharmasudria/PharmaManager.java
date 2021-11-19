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
	
	public String newClient(String nSecu, String nom, String prenom, String adresse, String nTelephone) {
		boolean existId = false;
		for(Client element : this.listeClients) {
			if(element.getSecu() == nSecu)
				existId = true;
		}
		if(!existId) {
			//IF nSECU > 13 (throw InvalidSecuriteSocialeFormat)
			Client client = new Client(nSecu, nom, prenom, adresse, nTelephone);
			this.listeClients.add(client);
			return "Le client a bien été créé au nom de "+client.getFullName()+" avec le numéro de SS: "+client.getSecu();
		}
		else
			return null;
	}
	
	public void newMedic(String name) {
		if(name != null) {
			Medic matiere = new Medic(name);
			this.listeMatiere.add(matiere);
			System.out.println("Nouvelle matière : "+name);
		}
	}

}
