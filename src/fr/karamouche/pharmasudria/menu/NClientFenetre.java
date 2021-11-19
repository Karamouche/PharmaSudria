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

import fr.karamouche.pharmasudria.InvalidSecuriteSocialeFormat;
import fr.karamouche.pharmasudria.PharmaManager;

import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class NClientFenetre extends JFrame {

	private JPanel contentPane;
	private JTextField txtSecu;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JLabel l1;
	private JTextField txtAdresse;
	private JTextField txtTelephone;
	public NClientFenetre(PharmaManager manager) {
		setTitle("Créer un élève");
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nSecu = new JLabel("Numéro de secu :");
		nSecu.setFont(new Font("Rockwell", Font.PLAIN, 15));
		nSecu.setBounds(55, 98, 175, 14);
		contentPane.add(nSecu);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblNom.setBounds(125, 129, 49, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom : ");
		lblPrenom.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblPrenom.setBounds(133, 163, 95, 14);
		contentPane.add(lblPrenom);
		
		txtSecu = new JTextField();
		txtSecu.setBounds(185, 97, 125, 20);
		contentPane.add(txtSecu);
		txtSecu.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(184, 128, 102, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(202, 162, 92, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		l1 = new JLabel("<html>Donnez les caract\u00E9ristiques <br/> du client</html>");
		l1.setHorizontalAlignment(SwingConstants.LEFT);
		l1.setFont(new Font("Rockwell", Font.PLAIN, 25));
		l1.setBounds(45, -23, 381, 135);
		contentPane.add(l1);
		JButton btnValider = new JButton("Créer");
		final JFrame parent = this;
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtSecu.getText().length() > 0 
							&& txtNom.getText().length() > 0
							&& txtPrenom.getText().length() > 0
							&& txtAdresse.getText().length() > 0
							&& txtTelephone.getText().length() > 0) {
						String result = null;
						result = manager.newClient(txtSecu.getText(), txtNom.getText(), txtPrenom.getText(), txtAdresse.getText(), txtTelephone.getText());
						//GESTION DES ERREURS
						if(result == null) {
							JOptionPane.showMessageDialog(parent, "L'ID est déjà utilisé par un autre étudiant", "Erreur", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(parent, result, "Etudiant crée", JOptionPane.INFORMATION_MESSAGE);
							parent.setVisible(false);
						}
					}else {
						JOptionPane.showMessageDialog(parent, "Un champ n'a pas été rempli", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				} catch(InvalidSecuriteSocialeFormat e1) {
					JOptionPane.showMessageDialog(parent, "Le numéro de SS doit faire au moins 13 caractère", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValider.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnValider.setBounds(160, 267, 89, 23);
		contentPane.add(btnValider);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblAdresse.setBounds(136, 193, 95, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblTelephone.setBounds(124, 224, 95, 19);
		contentPane.add(lblTelephone);
		
		txtAdresse = new JTextField();
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(205, 192, 103, 20);
		contentPane.add(txtAdresse);
		
		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(214, 224, 104, 20);
		contentPane.add(txtTelephone);
		

	}
}
