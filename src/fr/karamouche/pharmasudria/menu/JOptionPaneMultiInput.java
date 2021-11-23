package fr.karamouche.pharmasudria.menu;

import javax.swing.*;

import fr.karamouche.pharmasudria.Client;
import fr.karamouche.pharmasudria.Medic;

public class JOptionPaneMultiInput {
   public JOptionPaneMultiInput(Client client, Medic medic) {
      JTextField txtQuant = new JTextField(4);

      JPanel panel = new JPanel();
      JLabel title = new JLabel("Vous voulez acheter des "+medic.toString()+" et il en reste "+medic.getQuantite()+".");
      JLabel label = new JLabel("Quantité :");
      panel.add(title);
      panel.add(label);
      panel.add(txtQuant);

      int result = JOptionPane.showConfirmDialog(null, panel, 
               "Vous voulez acheter des "+medic.toString(), JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
    	 try {
    		 int quantite = Integer.parseInt(txtQuant.getText());
    		 if(quantite > 0 && medic.getQuantite()-quantite >= 0) {
    			 medic.setQuantite(medic.getQuantite()-quantite);
    			 final String resultS = "Vous avez acheté "+quantite+" "+medic.getNom()+". Il en reste mnt "+medic.getQuantite();
    			 JOptionPane.showMessageDialog(null, resultS, "Notes ajoutés", JOptionPane.INFORMATION_MESSAGE);
    		 }
    		 else if(quantite <= 0)
    			 JOptionPane.showMessageDialog(null, "Vous devez saisir une quantité positive", "Erreur", JOptionPane.ERROR_MESSAGE);
    		 else
    			 JOptionPane.showMessageDialog(null, "Vous dépassez le stock disponible", "Erreur", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Entrez bien une valeur numérique", "Erreur", JOptionPane.ERROR_MESSAGE);
		}

      }
   }
}