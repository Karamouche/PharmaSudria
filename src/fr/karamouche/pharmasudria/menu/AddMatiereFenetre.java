package fr.karamouche.pharmasudria.menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.karamouche.pharmasudria.Client;
import fr.karamouche.pharmasudria.Medic;
import fr.karamouche.pharmasudria.PharmaManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddMatiereFenetre extends JFrame {

	private JPanel contentPane;
	private JLabel l1;
	public AddMatiereFenetre(PharmaManager manager) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		final JFrame parent = this;
		setTitle("Ajouter une matière à un élève");
		setBounds(100, 100, 320, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1 = new JLabel("Choisissez :");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Rockwell", Font.PLAIN, 25));
		l1.setBounds(-16, -13, 340, 127);
		contentPane.add(l1);
		
		JLabel lEtudiant = new JLabel("Etudiant : ");
		lEtudiant.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lEtudiant.setHorizontalAlignment(SwingConstants.CENTER);
		lEtudiant.setBounds(60, 109, 83, 35);
		contentPane.add(lEtudiant);
		
		JLabel lMatiere = new JLabel("Matière : ");
		lMatiere.setHorizontalAlignment(SwingConstants.CENTER);
		lMatiere.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lMatiere.setBounds(60, 155, 83, 35);
		contentPane.add(lMatiere);
		
		JComboBox<Client> comboEtudiant = new JComboBox<Client>();
		comboEtudiant.setBounds(140, 117, 108, 22);
		for(Client element : manager.getListeEtudiant()) {
			comboEtudiant.addItem(element);
		}
		contentPane.add(comboEtudiant);
		
		JComboBox<Medic> comboMatiere = new JComboBox<Medic>();
		comboMatiere.setBounds(140, 163, 108, 22);
		for(Medic element : manager.getListeMatiere()) {
			comboMatiere.addItem(element);
		}
		contentPane.add(comboMatiere);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Client etudiant = (Client) comboEtudiant.getSelectedItem();
				final Medic matiere = (Medic) comboMatiere.getSelectedItem();
				@SuppressWarnings("unused")
				JOptionPaneMultiInput optionPane;
				if(!etudiant.getListeMatiere().contains(matiere))
					optionPane = new JOptionPaneMultiInput(etudiant, matiere);
				else
					JOptionPane.showMessageDialog(parent, "La matière est déjà associé à cet étudiant", "Erreur", JOptionPane.ERROR_MESSAGE);

			}
		});
		btnValider.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnValider.setBounds(113, 215, 89, 23);
		contentPane.add(btnValider);
		

	}
}
