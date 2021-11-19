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
		
		JMenuItem nClient = new JMenuItem("Client");
		nClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NClientFenetre fenetre = new NClientFenetre(manager);
				fenetre.setVisible(true);
			}
		});
		menu.add(nClient);
		
		
		JMenuItem nMedic = new JMenuItem("Médicament");
		nMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NOUVEAU MEDICAMENT
			}
		});
		menu.add(nMedic);
		
		setJMenuBar(menuBar);
		
		JMenu mOption = new JMenu("Option");
		menuBar.add(mOption);
		
		JMenuItem mAjouterStock = new JMenuItem("Ajoutez du stocks");
		mOption.add(mAjouterStock);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("<html>Rechercher un client avec son numéro <br> de sécurité sociale:</html>");
		l1.setBounds(5, 52, 426, 113);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Rockwell", Font.PLAIN, 23));
		contentPane.add(l1);
		
		zoneTexte = new JTextField();
		zoneTexte.setToolTipText("Numéro de sécurité sociale");
		zoneTexte.setBounds(54, 176, 342, 65);
		contentPane.add(zoneTexte);
		zoneTexte.setColumns(5);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String secu = zoneTexte.getText();
				try {
					Client client = null;
					for(Client element : manager.getListeClients()) {
						if(element.getSecu().equalsIgnoreCase(secu))
							client = element;
					}
					if(client != null) {
						System.out.println("Eleve : "+client.getFullName());
						client.showDetailWindow(parent);
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
