package fr.karamouche.pharmasudria.menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.karamouche.pharmasudria.Client;
import fr.karamouche.pharmasudria.PharmaManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	private JPanel contentPane;
	private JTextField zoneTexte;
	
	@SuppressWarnings("unused")
	private final PharmaManager manager;
	private final String name;
	public Fenetre(String nom, PharmaManager manager){
		this.manager = manager;
		this.name = nom;
		final JFrame parent = this;
		setTitle(this.name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 535);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Nouveau");
		menuBar.add(menu);
		
		JMenuItem nMatiere = new JMenuItem("Matière");
		nMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer = JOptionPane.showInputDialog(parent, "Donnez le nom de la nouvelle matière : ", "Nom de la matière", JOptionPane.QUESTION_MESSAGE);
				if (answer != null) {
					if(!manager.existMatiere(answer)) {
						JOptionPane.showMessageDialog(parent, "La nouvelle matière : "+answer+" a bien été crée !", "Matière crée", JOptionPane.INFORMATION_MESSAGE);
						manager.nouvelleMatiere(answer);
					}else
						JOptionPane.showMessageDialog(parent, "Cette matière existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		menu.add(nMatiere);
		
		
		JMenuItem nEleve = new JMenuItem("Elève");
		nEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NEleveFenetre fenetre = new NEleveFenetre(manager);
				fenetre.setVisible(true);
			}
		});
		menu.add(nEleve);
		
		setJMenuBar(menuBar);
		
		JMenu menuOption= new JMenu("Option");
		menuBar.add(menuOption);
		
		JMenuItem menuAddMatiere = new JMenuItem("Ajouter une matière à un élève");
		menuAddMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMatiereFenetre fenetre = new AddMatiereFenetre(manager);
				if(manager.getListeEtudiant().size() != 0 && manager.getListeMatiere().size() != 0)
					fenetre.setVisible(true);
				else
					JOptionPane.showMessageDialog(parent, "Il faut au moins un élève et une matière", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		});
		menuOption.add(menuAddMatiere);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Rechercher un étudiant avec son ID :");
		l1.setBounds(5, 52, 426, 92);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Rockwell", Font.PLAIN, 23));
		contentPane.add(l1);
		
		zoneTexte = new JTextField();
		zoneTexte.setToolTipText("ID de l'élève");
		zoneTexte.setBounds(54, 176, 342, 65);
		contentPane.add(zoneTexte);
		zoneTexte.setColumns(5);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//GET WHATS IN TEXT FIELD
				String idS = zoneTexte.getText();
				try {
					int ID = Integer.parseInt(idS);
					Client etudiant = null;
					for(Client element : manager.getListeEtudiant()) {
						if (element.getId() == ID)
							etudiant = element;
					}
					if(etudiant != null) {
						System.out.println("Eleve : "+etudiant.getFullName());
						etudiant.showDetailWindow(parent);
					}else {
						JOptionPane.showMessageDialog(parent, "L'ID n'a pas été trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(parent, "L'ID doit être composé uniquement de chiffres", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValider.setFont(new Font("Rockwell", Font.PLAIN, 19));
		btnValider.setBounds(147, 317, 133, 60);
		contentPane.add(btnValider);
	}
}
