package fr.karamouche.pharmasudria.menu;

import javax.swing.*;

import fr.karamouche.pharmasudria.Client;
import fr.karamouche.pharmasudria.Medic;

public class JOptionPaneMultiInput {
   public JOptionPaneMultiInput(Client etudiant, Medic matiere) {
      JTextField textOral = new JTextField(4);
      JTextField textEcrit = new JTextField(4);

      JPanel panel = new JPanel();
      panel.add(new JLabel("Note oral : "));
      panel.add(textOral);
      panel.add(Box.createHorizontalStrut(15));//espace
      panel.add(new JLabel("Note écrite : "));
      panel.add(textEcrit);

      int result = JOptionPane.showConfirmDialog(null, panel, 
               "Entrez la note orale et écrite en "+matiere.getNom(), JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
    	 try {
    		 float noteOral = Float.parseFloat(textOral.getText());
    		 float noteEcrite = Float.parseFloat(textEcrit.getText());
    		 if(noteOral >= 0 && noteOral <= 20 && noteEcrite >= 0 && noteEcrite <= 20) {
    			 etudiant.addMatiere(matiere, noteOral, noteEcrite);
    			 System.out.println("Ajouté à "+etudiant.getFullName()+" note "+noteOral+" "+noteEcrite);
    			 final String resultS = "Les notes en "+matiere.getNom()+" pour "+etudiant.getFullName()+" on bien étés ajoutés\n Ecrit : "+noteEcrite+" et Orale : "+noteOral;
    			 JOptionPane.showMessageDialog(null, resultS, "Notes ajoutés", JOptionPane.INFORMATION_MESSAGE);
    		 }
    		 else
    			 JOptionPane.showMessageDialog(null, "Une note doit être comprise entre 0 et 20", "Erreur", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Entrez bien une valeur numérique pour note", "Erreur", JOptionPane.ERROR_MESSAGE);
		}

      }
   }
}