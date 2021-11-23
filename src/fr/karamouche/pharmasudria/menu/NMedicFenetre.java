package fr.karamouche.pharmasudria.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.karamouche.pharmasudria.InvalidSecuriteSocialeFormat;
import fr.karamouche.pharmasudria.PharmaManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NMedicFenetre extends JFrame {

	private JPanel contentPane;
	private JTextField textRef;
	private JTextField textLib;
	private JTextField textQuant;
	private JTextField textPrix;


	public NMedicFenetre(PharmaManager gestion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JFrame parent = this;
		
		setBounds(100, 100, 518, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewmedic = new JLabel("Ajouter un medicament");
		lblNewmedic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewmedic.setBounds(136, 11, 218, 48);
		contentPane.add(lblNewmedic);
		
		JLabel lblNewRef = new JLabel("R\u00E9f\u00E9rence :");
		lblNewRef.setBounds(46, 100, 69, 14);
		contentPane.add(lblNewRef);
		
		JLabel lblNewLib = new JLabel("Lib\u00E9l\u00E9 :");
		lblNewLib.setBounds(46, 152, 50, 14);
		contentPane.add(lblNewLib);
		
		JLabel lblNewDes = new JLabel("D\u00E9scription du m\u00E9dicament :");
		lblNewDes.setBounds(46, 198, 143, 14);
		contentPane.add(lblNewDes);
		
		JLabel lblNewQuant = new JLabel("Quantit\u00E9 :");
		lblNewQuant.setBounds(46, 312, 69, 14);
		contentPane.add(lblNewQuant);
		
		JLabel lblNewPrix = new JLabel("Prix unitaire :");
		lblNewPrix.setBounds(46, 359, 125, 14);
		contentPane.add(lblNewPrix);
		
		textRef = new JTextField();
		textRef.setBounds(121, 97, 86, 20);
		contentPane.add(textRef);
		textRef.setColumns(10);
		
		textLib = new JTextField();
		textLib.setBounds(121, 149, 86, 20);
		contentPane.add(textLib);
		textLib.setColumns(10);
		
		JTextArea textDes = new JTextArea();
		textDes.setBounds(219, 198, 186, 87);
		contentPane.add(textDes);
		
		textQuant = new JTextField();
		textQuant.setBounds(121, 309, 86, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		textPrix = new JTextField();
		textPrix.setBounds(121, 356, 86, 20);
		contentPane.add(textPrix);
		textPrix.setColumns(10);
		
		JButton btnValidMedic = new JButton("Valider");
		final JFrame factuelle = this;
		btnValidMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String res = null;
					res = gestion.newMedic(textRef.getText(), textLib.getText(), textDes.getText(), Integer.parseInt(textQuant.getText()), Float.parseFloat(textPrix.getText()));
					if(res == null){
						JOptionPane.showMessageDialog(factuelle, res, "Erreur dans la cration", JOptionPane.ERROR_MESSAGE);		
					}
					else {			
						JOptionPane.showMessageDialog(factuelle, res, "Medicament", JOptionPane.INFORMATION_MESSAGE);
						factuelle.setVisible(false);
						
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(parent, "La quantité et le prix doivent être des chiffres", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		btnValidMedic.setBounds(207, 437, 89, 23);
		contentPane.add(btnValidMedic);
	}
}

