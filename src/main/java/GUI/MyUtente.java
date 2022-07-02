package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Utente;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class MyUtente extends JFrame {

	private JPanel contentPane;
	
	private JFrame myUtente;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Nazione;
	private DefaultListModel dlm = new DefaultListModel();
	private JButton btnNO = new JButton("NO");
	private JButton btnSI = new JButton("SI");
	private JLabel lblSeiSicuro = new JLabel("Sei sicuro ?");
	
	public MyUtente(JFrame home, Utente utente, Controller controller, boolean flag, JFrame login) {
		System.out.println("Sei in MyUtente");
		
		home.setVisible(false);
		myUtente=this;
		myUtente.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		JLabel lblMyUtente = new JLabel("Profilo di " + utente.getNickname());
		lblMyUtente.setHorizontalAlignment(SwingConstants.LEFT);
		lblMyUtente.setForeground(new Color(34, 139, 34));
		lblMyUtente.setFont(new Font("Arial", Font.PLAIN, 50));
		lblMyUtente.setBounds(10, 10, 774, 54);
		contentPane.add(lblMyUtente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 26));
		lblNome.setBounds(10, 89, 99, 37);
		contentPane.add(lblNome);
		
		Nome = new JTextField();
		Nome.setEditable(false);
		Nome.setFont(new Font("Arial", Font.PLAIN, 22));
		Nome.setColumns(10);
		Nome.setBounds(10, 122, 227, 45);
		contentPane.add(Nome);
		Nome.setText(utente.getNome());
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("Arial", Font.PLAIN, 26));
		lblCognome.setBounds(10, 178, 144, 37);
		contentPane.add(lblCognome);
		
		JLabel lblDataN = new JLabel("Data di nascita:");
		lblDataN.setFont(new Font("Arial", Font.PLAIN, 26));
		lblDataN.setBounds(312, 311, 227, 37);
		contentPane.add(lblDataN);
		
		JLabel lblSesso = new JLabel("Sesso:");
		lblSesso.setFont(new Font("Arial", Font.PLAIN, 26));
		lblSesso.setBounds(312, 179, 99, 37);
		contentPane.add(lblSesso);
		
		JLabel lblIsAdmin = new JLabel("Admin:");
		lblIsAdmin.setFont(new Font("Arial", Font.PLAIN, 26));
		lblIsAdmin.setBounds(10, 571, 81, 31);
		contentPane.add(lblIsAdmin);
		
		JLabel lblNazione = new JLabel("Nazione:");
		lblNazione.setFont(new Font("Arial", Font.PLAIN, 26));
		lblNazione.setBounds(311, 89, 144, 37);
		contentPane.add(lblNazione);
		
		JLabel lblIsPremium = new JLabel("Premium:");
		lblIsPremium.setFont(new Font("Arial", Font.PLAIN, 26));
		lblIsPremium.setBounds(10, 523, 116, 37);
		contentPane.add(lblIsPremium);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 311, 227, 189);
		contentPane.add(scrollPane_1);
		
		JEditorPane descrizione = new JEditorPane();
		descrizione.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane_1.setViewportView(descrizione);
		descrizione.setEditable(false);
		
		if(utente.getDescrizione() != null)
		{
			descrizione.setText(utente.getDescrizione());
		}
		else
		{
			descrizione.setFont(new Font("Arial", Font.ITALIC, 22));
			descrizione.setText("Nessuna descrizione");
		}
		
		Cognome = new JTextField();
		Cognome.setEditable(false);
		Cognome.setFont(new Font("Arial", Font.PLAIN, 22));
		Cognome.setColumns(10);
		Cognome.setBounds(10, 220, 227, 45);
		contentPane.add(Cognome);
		Cognome.setText(utente.getCognome());
		
		Nazione = new JTextField();
		Nazione.setEditable(false);
		Nazione.setFont(new Font("Arial", Font.PLAIN, 22));
		Nazione.setColumns(10);
		Nazione.setBounds(312, 122, 227, 45);
		contentPane.add(Nazione);
		Nazione.setText(utente.getNazione());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 214, 227, 88);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane.setViewportView(list);
		
		dlm.addElement(utente.getSesso());
		list.setModel(dlm);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(312, 353, 323, 147);
		contentPane.add(calendar);
		calendar.setDate(utente.getDatan());
		
		JCheckBox chckbxPremium = new JCheckBox("");
		chckbxPremium.setEnabled(false);
		chckbxPremium.setBounds(132, 533, 21, 21);
		contentPane.add(chckbxPremium);
		chckbxPremium.setSelected(utente.getIsIspremium());
		
		JCheckBox chckbxAdmin = new JCheckBox("");
		chckbxAdmin.setEnabled(false);
		chckbxAdmin.setBounds(133, 578, 21, 21);
		contentPane.add(chckbxAdmin);
		chckbxAdmin.setSelected(utente.getIsIsadmin());
		
		JButton btnConferma = new JButton("Conferma"); 
		btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int esito=0;
				
				Nome.setEditable(false);
				Cognome.setEditable(false);
				descrizione.setEditable(false);
				Nazione.setEditable(false);
				list.setEnabled(false);
				btnConferma.setVisible(false);
				esito=controller.updateUtente(utente.getNickname(),Nome.getText(),Cognome.getText(),Nazione.getText(),(String) list.getSelectedValue(),chckbxPremium.isSelected(),chckbxAdmin.isSelected(), descrizione.getText());
				if(esito == 1 )
				{
					JOptionPane.showMessageDialog(btnConferma, "Modifica avvenuta con successo, verrai riportato al log-in per ricaricare il profilo");
					home.dispose();
					login.setVisible(true);
					myUtente.dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(btnConferma, "Errore durante la modifica");
				}
			}
		});
		btnConferma.setForeground(Color.BLACK);
		btnConferma.setFont(new Font("Arial", Font.BOLD, 26));
		btnConferma.setBackground(new Color(0, 128, 0));
		btnConferma.setBounds(794, 179, 247, 37);
		contentPane.add(btnConferma);
		btnConferma.setVisible(false);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConferma.setVisible(true);
				list.setEnabled(true);
				Nome.setEditable(true);
				Cognome.setEditable(true);
				descrizione.setEditable(true);
				Nazione.setEditable(true);
				dlm.remove(0);
				dlm.addElement("Uomo");
				dlm.addElement("Donna");
				dlm.addElement("Transgender");
				dlm.addElement("Lampadina");
				dlm.addElement("Unicorno");
				list.setModel(dlm);
			}
		});
		btnModifica.setForeground(Color.BLACK);
		btnModifica.setFont(new Font("Arial", Font.BOLD, 26));
		btnModifica.setBackground(new Color(255, 99, 71));
		btnModifica.setBounds(794, 124, 247, 37);
		contentPane.add(btnModifica);
	
		JButton btnTornaIndietro = new JButton("Torna Indietro");
		btnTornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.setVisible(true);
				System.out.println("Sono tornato in home");
				myUtente.dispose();
			}
		});
		btnTornaIndietro.setForeground(Color.BLACK);
		btnTornaIndietro.setFont(new Font("Arial", Font.BOLD, 26));
		btnTornaIndietro.setBackground(Color.RED);
		btnTornaIndietro.setBounds(794, 27, 249, 37);
		contentPane.add(btnTornaIndietro);
		
		JButton btnCancellaAccount = new JButton("Elimina Account");
		btnCancellaAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSI.setVisible(true);
				btnNO.setVisible(true);
				lblSeiSicuro.setVisible(true);
			}
		});
		btnCancellaAccount.setForeground(Color.BLACK);
		btnCancellaAccount.setFont(new Font("Arial", Font.BOLD, 26));
		btnCancellaAccount.setBackground(new Color(255, 69, 0));
		btnCancellaAccount.setBounds(794, 75, 247, 37);
		contentPane.add(btnCancellaAccount);
		
		JButton btnPannelloAscolti = new JButton("Pannello ascolti");
		btnPannelloAscolti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pannello pannello=new Pannello(myUtente,controller,home);
				System.out.println("Sono in Pannello");
			}
		});
		btnPannelloAscolti.setForeground(Color.BLACK);
		btnPannelloAscolti.setFont(new Font("Arial", Font.BOLD, 26));
		btnPannelloAscolti.setBackground(new Color(255, 165, 0));
		btnPannelloAscolti.setBounds(794, 595, 249, 37);
		contentPane.add(btnPannelloAscolti);
		
		btnModifica.setVisible(flag);
		btnCancellaAccount.setVisible(flag);
		if(!utente.getIsIsadmin() || !flag)
		{
			btnPannelloAscolti.setVisible(false);
		}
		list.setEnabled(false);
		calendar.setEnabled(false);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setFont(new Font("Arial", Font.PLAIN, 26));
		lblDescrizione.setBounds(10, 276, 144, 37);
		contentPane.add(lblDescrizione);
		
		lblSeiSicuro.setFont(new Font("Arial", Font.PLAIN, 26));
		lblSeiSicuro.setBounds(794, 238, 144, 37);
		contentPane.add(lblSeiSicuro);
		btnNO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSeiSicuro.setVisible(false);
				btnNO.setVisible(false);
				btnSI.setVisible(false);
			}
		});
		
		btnNO.setForeground(Color.BLACK);
		btnNO.setFont(new Font("Arial", Font.BOLD, 26));
		btnNO.setBackground(Color.RED);
		btnNO.setBounds(898, 286, 81, 37);
		contentPane.add(btnNO);
		btnSI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int esito = controller.deleteUtente(utente.getNickname());
				
				if(esito != 0)
				{
					JOptionPane.showMessageDialog(btnCancellaAccount, "Eliminazione eseguita con successo");
					home.dispose();
					login.setVisible(true);
					System.out.println("Ti trovi in login");
					myUtente.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(btnCancellaAccount, "Impossibile eliminare l'account");
				}
			}
		});
		
		btnSI.setForeground(Color.BLACK);
		btnSI.setFont(new Font("Arial", Font.BOLD, 26));
		btnSI.setBackground(new Color(0, 128, 0));
		btnSI.setBounds(794, 286, 81, 37);
		contentPane.add(btnSI);
		
		btnSI.setVisible(false);
		btnNO.setVisible(false);
		lblSeiSicuro.setVisible(false);
	}
}
