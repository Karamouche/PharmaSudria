package fr.karamouche.pharmasudria.menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import fr.karamouche.pharmasudria.PharmaManager;

import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class NEleveFenetre extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JLabel l1;
	private JTextField textNoteProjet;
	public NEleveFenetre(PharmaManager manager) {
		setTitle("Créer un élève");
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lID = new JLabel("ID : ");
		lID.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lID.setBounds(125, 98, 49, 14);
		contentPane.add(lID);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblNom.setBounds(125, 136, 49, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom : ");
		lblPrenom.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblPrenom.setBounds(125, 178, 95, 14);
		contentPane.add(lblPrenom);
		
		txtID = new JTextField();
		txtID.setBounds(161, 97, 125, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(184, 135, 102, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(194, 177, 92, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		textNoteProjet = new JTextField();
		textNoteProjet.setBounds(190, 239, 96, 20);
		contentPane.add(textNoteProjet);
		textNoteProjet.setColumns(10);
		textNoteProjet.setVisible(false);
		
		JLabel lblNoteProjet = new JLabel("Note du Projet :");
		lblNoteProjet.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblNoteProjet.setBounds(75, 234, 144, 31);
		contentPane.add(lblNoteProjet);
		lblNoteProjet.setVisible(false);
		
		JCheckBox isLastYearBox = new JCheckBox("  En dernière année");
		isLastYearBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(isLastYearBox.isSelected()) {
					lblNoteProjet.setVisible(true);
					textNoteProjet.setVisible(true);
				}else if(!isLastYearBox.isSelected()) {
					lblNoteProjet.setVisible(false);
					textNoteProjet.setVisible(false);
				}
			}
		});
		isLastYearBox.setFont(new Font("Rockwell", Font.PLAIN, 13));
		isLastYearBox.setHorizontalAlignment(SwingConstants.CENTER);
		isLastYearBox.setBounds(145, 209, 160, 23);
		contentPane.add(isLastYearBox);
		
		l1 = new JLabel("<html>Donnez les caractéristiques <br/> de l'élèves</html>");
		l1.setHorizontalAlignment(SwingConstants.LEFT);
		l1.setFont(new Font("Rockwell", Font.PLAIN, 25));
		l1.setBounds(45, -23, 381, 135);
		contentPane.add(l1);
		JButton btnValider = new JButton("Valider");
		final JFrame parent = this;
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtID.getText().length() <= 4 
							&& txtID.getText().length() > 0 
							&& txtNom.getText().length() > 0
							&& txtPrenom.getText().length() > 0) {
						String result = null;
						if(isLastYearBox.isSelected()) {
							if(!textNoteProjet.getText().equalsIgnoreCase("") && Float.parseFloat(textNoteProjet.getText()) >= 0 && Float.parseFloat(textNoteProjet.getText()) <= 20)
								result = manager.nouvelEleve(Integer.parseInt(txtID.getText()), txtNom.getText(), txtPrenom.getText(), Float.parseFloat(textNoteProjet.getText()));
						}else {
							result = manager.nouvelEleve(Integer.parseInt(txtID.getText()), txtNom.getText(), txtPrenom.getText(), -1);
						}
						
						//https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
						if(result == null) {
							if(textNoteProjet.getText().equalsIgnoreCase(""))
								JOptionPane.showMessageDialog(parent, "Veuillez renseigner une note pour le projet de fin d'année", "Erreur", JOptionPane.ERROR_MESSAGE);
							else if(Float.parseFloat(textNoteProjet.getText()) > 20 || Float.parseFloat(textNoteProjet.getText()) < 0)
								JOptionPane.showMessageDialog(parent, "La note de projet doit être compris entre 0 et 20", "Erreur", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(parent, "L'ID est déjà utilisé par un autre étudiant", "Erreur", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(parent, result, "Etudiant crée", JOptionPane.INFORMATION_MESSAGE);
							parent.setVisible(false);
						}
					}else {
						if(txtID.getText().length() > 4 )
							JOptionPane.showMessageDialog(parent, "L'ID ne peut faire que 4 caractère maximum", "Erreur", JOptionPane.ERROR_MESSAGE);
						else
							JOptionPane.showMessageDialog(parent, "Un champ n'a pas été rempli", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(parent, "Rentrez des chiffres dans les notes et ID", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValider.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnValider.setBounds(161, 281, 89, 23);
		contentPane.add(btnValider);
		

	}
}
