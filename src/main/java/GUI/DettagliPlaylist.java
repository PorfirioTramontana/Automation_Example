package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Playlist;
import Model.Traccia;
import Model.Utente;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DettagliPlaylist extends JFrame {

	private JPanel contentPane;
	private JFrame dettagliPlaylist;
	private JTextField proprietarioField;
	private JTextField durataField;
	private JTextField nTracceField;
	private JCheckBox boxPubblica = new JCheckBox("Pubblica");
	private JCheckBox boxPrivata = new JCheckBox("Privata");
	private JList listTracceIn = new JList();
	private JScrollPane scrollPane = new JScrollPane();
	private ArrayList<Traccia> tracce = new ArrayList<Traccia>();
	private JButton btnEliminaPlaylist = new JButton("Elimina playlist");
	private JButton btnModifica = new JButton("Modifica");
	private JButton btnConferma = new JButton("Conferma");
	private JLabel lblSeiSicuro = new JLabel("Sei sicuro ?");
	private JButton btnSi = new JButton("Si");
	private JButton btnNo = new JButton("No");
	private JButton btnDettagli = new JButton("Dettagli");
	private final JLabel lblScegliTracciaDa = new JLabel("Scegli traccia da aggiungere:");
	private final JTextField ricercaField = new JTextField();
	private final JList listTracceNew = new JList();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JButton btnRimuovi = new JButton("Rimuovi");
	private final JButton btnAggiungi = new JButton("Aggiungi");
	private final JButton btnCerca = new JButton("Cerca");
	private final JLabel lblTitolo = new JLabel("Titolo:");
	private final JTextField titoloField = new JTextField();
	private ArrayList<Integer> codT = new ArrayList<Integer>();
	private DefaultListModel dlm = new DefaultListModel();
	private ArrayList<Integer> codTNew = new ArrayList<Integer>();
	private ArrayList<Traccia> tracce2;
	private JLabel lblHome = new JLabel();
	private final JButton btnTornaIndietro = new JButton("Torna Indietro");
	private JButton btnCreaNuovaPlaylist = new JButton("Crea nuova playlist");
	private boolean nuovo1;
	
	public DettagliPlaylist(JFrame home, Playlist playlist, Controller controller, boolean flag, Utente utente, boolean nuovo, JFrame indietro) 
	{
		dettagliPlaylist = this;
		dettagliPlaylist.setVisible(true);
		home.setVisible(false);
		System.out.println("Sei in dettagli playlist");
		this.nuovo1 = nuovo;
		
		if(indietro == null)
		{
			btnTornaIndietro.setVisible(false);
		}
		else
		{
			indietro.setVisible(false);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setForeground(new Color(34, 139, 34));
		lblHome.setFont(new Font("Arial", Font.PLAIN, 50));
		lblHome.setBounds(10, 11, 565, 54);
		contentPane.add(lblHome);
		
		JLabel lblProprietario = new JLabel("Proprietario:");
		lblProprietario.setFont(new Font("Arial", Font.PLAIN, 26));
		lblProprietario.setBounds(10, 177, 165, 37);
		contentPane.add(lblProprietario);
		
		proprietarioField = new JTextField();
		proprietarioField.setEditable(false);
		proprietarioField.setFont(new Font("Arial", Font.PLAIN, 22));
		proprietarioField.setColumns(10);
		proprietarioField.setBounds(10, 212, 215, 45);
		contentPane.add(proprietarioField);
		
		JLabel lblDurata = new JLabel("Durata:");
		lblDurata.setFont(new Font("Arial", Font.PLAIN, 26));
		lblDurata.setBounds(10, 268, 165, 37);
		contentPane.add(lblDurata);
		
		durataField = new JTextField();
		durataField.setFont(new Font("Arial", Font.PLAIN, 22));
		durataField.setEditable(false);
		durataField.setColumns(10);
		durataField.setBounds(10, 316, 215, 45);
		contentPane.add(durataField);
		
		JLabel lblNTracce = new JLabel("N tracce:");
		lblNTracce.setFont(new Font("Arial", Font.PLAIN, 26));
		lblNTracce.setBounds(10, 362, 165, 37);
		contentPane.add(lblNTracce);
		
		nTracceField = new JTextField();
		nTracceField.setFont(new Font("Arial", Font.PLAIN, 22));
		nTracceField.setEditable(false);
		nTracceField.setColumns(10);
		nTracceField.setBounds(10, 410, 215, 45);
		contentPane.add(nTracceField);
		
		JLabel Visibilit = new JLabel("Visibilit\u00E0:");
		Visibilit.setFont(new Font("Arial", Font.PLAIN, 26));
		Visibilit.setBounds(10, 466, 165, 37);
		contentPane.add(Visibilit);
		boxPubblica.setEnabled(false);
		
		boxPubblica.setFont(new Font("Arial", Font.PLAIN, 22));
		boxPubblica.setBounds(10, 510, 127, 37);
		boxPubblica.setBackground(new Color(224, 255, 255));
		contentPane.add(boxPubblica);
		boxPrivata.setEnabled(false);
		
		boxPrivata.setFont(new Font("Arial", Font.PLAIN, 22));
		boxPrivata.setBounds(10, 550, 127, 37);
		boxPrivata.setBackground(new Color(224, 255, 255));
		contentPane.add(boxPrivata);
		
		ButtonGroup group = new ButtonGroup();
		group.add(boxPubblica);
		group.add(boxPrivata);
		
		JLabel lblTracce = new JLabel("Tracce:");
		lblTracce.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTracce.setBounds(271, 86, 165, 37);
		contentPane.add(lblTracce);
		
		scrollPane.setBounds(271, 121, 304, 133);
		contentPane.add(scrollPane);
		
		listTracceIn.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane.setViewportView(listTracceIn);
		
		JButton btnHome = new JButton("Torna in home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.setVisible(true);
				System.out.println("Ti trovi in home");
				dettagliPlaylist.dispose();
			}
		});
		btnHome.setForeground(Color.BLACK);
		btnHome.setFont(new Font("Arial", Font.BOLD, 26));
		btnHome.setBackground(Color.RED);
		btnHome.setBounds(792, 21, 249, 37);
		contentPane.add(btnHome);
		btnEliminaPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSeiSicuro.setVisible(true);
				btnSi.setVisible(true);
				btnNo.setVisible(true);
			}
		});
		
		btnEliminaPlaylist.setForeground(Color.BLACK);
		btnEliminaPlaylist.setFont(new Font("Arial", Font.BOLD, 26));
		btnEliminaPlaylist.setBackground(new Color(255, 69, 0));
		btnEliminaPlaylist.setBounds(792, 116, 249, 37);
		contentPane.add(btnEliminaPlaylist);
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDettagli.setVisible(false);
				btnRimuovi.setVisible(true);
				btnCerca.setVisible(true);
				lblScegliTracciaDa.setVisible(true);
				listTracceNew.setVisible(true);
				scrollPane_1.setVisible(true);
				ricercaField.setVisible(true);
				btnConferma.setVisible(true);
				titoloField.setEditable(true);
				boxPubblica.setEnabled(true);
				boxPrivata.setEnabled(true);
			}
		});
		
		btnModifica.setForeground(Color.BLACK);
		btnModifica.setFont(new Font("Arial", Font.BOLD, 26));
		btnModifica.setBackground(new Color(255, 99, 71));
		btnModifica.setBounds(792, 164, 249, 37);
		contentPane.add(btnModifica);
		btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flag3 = false;
				int i, maxP;
				ArrayList<Playlist> p;
				
				if(boxPubblica.getSelectedObjects() != null)
				{
					flag3 = true;
				}
				
				if(nuovo1)
				{
					controller.updatePlaylist("Insert into playlist(Titolo, visibilita, nickname) values('" + titoloField.getText() + "', " + flag3 + ", '" + utente.getNickname() + "');");
					p = controller.takePlaylist("Select CodP, NickName, titolo, Ntracce, visibilita, durata from playlist where nickname = '" + utente.getNickname() + "'");
					maxP = p.get(0).getCodP();	
					for(i = 1; i < p.size(); i++)
					{
						if(maxP < p.get(i).getCodP())
						{
							maxP = p.get(i).getCodP();
						}
					}
					
					for(i = 0; i < codTNew.size(); i++)
					{
						controller.updatePlaylist("insert into Contiene values(" + maxP + ", " + codTNew.get(i) + ");");
					}
				}
				else
				{
					controller.updatePlaylist("Update playlist set titolo = '" + titoloField.getText() + "', visibilita = " + flag3 + " where codp = " + playlist.getCodP() + ";");
					
					for(i = 0; i < codT.size(); i++)
					{
						controller.updatePlaylist("Delete from contiene where codp = " + playlist.getCodP() + "and codt = " + codT.get(i));
					}
					
					for(i = 0; i < codTNew.size(); i++)
					{
						controller.updatePlaylist("insert into Contiene values(" + playlist.getCodP() + ", " + codTNew.get(i) + ");");
					}
				}
				
				home.setVisible(true);
				System.out.println("Ti trovi in home");
				JOptionPane.showMessageDialog(btnConferma, "Modifica avvenuta con successo, stai tornando in home");
				dettagliPlaylist.dispose();
			}
		});
		
		btnConferma.setForeground(Color.BLACK);
		btnConferma.setFont(new Font("Arial", Font.BOLD, 26));
		btnConferma.setBackground(new Color(0, 128, 0));
		btnConferma.setBounds(792, 214, 249, 37);
		contentPane.add(btnConferma);
		
		lblSeiSicuro.setFont(new Font("Arial", Font.PLAIN, 26));
		lblSeiSicuro.setBounds(812, 261, 165, 37);
		contentPane.add(lblSeiSicuro);
		btnSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.updatePlaylist("Delete from playlist where codp = " + playlist.getCodP());
				JOptionPane.showMessageDialog(btnSi, "Eliminazione eseguita, stai tornando nella home");
				home.setVisible(true);
				System.out.println("Ti trovi in home");
				dettagliPlaylist.dispose();
			}
		});
		
		btnSi.setForeground(Color.BLACK);
		btnSi.setFont(new Font("Arial", Font.BOLD, 26));
		btnSi.setBackground(new Color(0, 128, 0));
		btnSi.setBounds(792, 302, 70, 37);
		contentPane.add(btnSi);
		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSeiSicuro.setVisible(false);
				btnSi.setVisible(false);
				btnNo.setVisible(false);
			}
		});
		
		btnNo.setForeground(Color.BLACK);
		btnNo.setFont(new Font("Arial", Font.BOLD, 26));
		btnNo.setBackground(Color.RED);
		btnNo.setBounds(907, 302, 70, 37);
		contentPane.add(btnNo);
		btnDettagli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listTracceIn.getSelectedIndex() != -1)
				{
					DettagliTraccia dettagliTraccia = new DettagliTraccia(home, tracce.get(listTracceIn.getSelectedIndex()), controller, dettagliPlaylist, utente);
					System.out.println("Ti trovi in dettagli traccia");	
				}
				else
				{
					JOptionPane.showMessageDialog(btnDettagli, "Cliccare su una scelta");
				}
			}
		});
		
		btnDettagli.setForeground(Color.BLACK);
		btnDettagli.setFont(new Font("Arial", Font.BOLD, 26));
		btnDettagli.setBackground(new Color(244, 164, 96));
		btnDettagli.setBounds(271, 268, 154, 37);
		contentPane.add(btnDettagli);
		lblScegliTracciaDa.setFont(new Font("Arial", Font.PLAIN, 26));
		lblScegliTracciaDa.setBounds(271, 359, 343, 37);
		
		contentPane.add(lblScegliTracciaDa);
		ricercaField.setFont(new Font("Arial", Font.PLAIN, 22));
		ricercaField.setColumns(10);
		ricercaField.setBounds(271, 395, 343, 45);
		
		contentPane.add(ricercaField);
		scrollPane_1.setBounds(271, 454, 343, 122);
		
		contentPane.add(scrollPane_1);
		listTracceNew.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane_1.setViewportView(listTracceNew);
		btnRimuovi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listTracceIn.getSelectedIndex() != -1)
				{
					codT.add(tracce.get(listTracceIn.getSelectedIndex()).getCodT());
					tracce.remove(listTracceIn.getSelectedIndex());
					int i = 0;
					boolean elimina = false;
					
					while(i < codTNew.size() && i < codT.size() && !elimina)
					{
						if(codTNew.get(i) == codT.get(i))
						{
							codTNew.remove(i);
							elimina = true;
						}
						i++;
					}
					
					dlm.removeAllElements();
					for(i = 0; i < tracce.size(); i++)
					{
						dlm.addElement(""+ tracce.get(i).getTitolo() + ", " + tracce.get(i).getFormato() + ", " + tracce.get(i).getQualita());
					}
					
					listTracceIn.setModel(dlm);
				}
				else
				{
					JOptionPane.showMessageDialog(btnRimuovi, "Scegliere una traccia");
				}
			}
		});
		
		btnRimuovi.setForeground(Color.BLACK);
		btnRimuovi.setFont(new Font("Arial", Font.BOLD, 26));
		btnRimuovi.setBackground(Color.RED);
		btnRimuovi.setBounds(449, 268, 154, 37);
		
		contentPane.add(btnRimuovi);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listTracceNew.getSelectedIndex() != -1)
				{
					int i = 0;
					boolean flag2 = false; 
					
					while(i < codTNew.size() && !flag2)
					{
						if(codTNew.get(i) == tracce2.get(listTracceNew.getSelectedIndex()).getCodT())
						{
							flag2 = true;
						}
						
						i++;
					}
					
					i = 0;
					while(i < tracce.size() && !flag2)
					{
						if(tracce.get(i).getCodT() == tracce2.get(listTracceNew.getAnchorSelectionIndex()).getCodT())
						{
							System.out.println(tracce.get(i).getCodT());
							flag2 = true;
						}
						
						i++;
					}
					
					if(!flag2)
					{
						codTNew.add(tracce2.get(listTracceNew.getSelectedIndex()).getCodT());
						dlm.addElement(""+ tracce2.get(listTracceNew.getSelectedIndex()).getTitolo() + ", " + tracce2.get(listTracceNew.getSelectedIndex()).getFormato() + ", " + tracce2.get(listTracceNew.getSelectedIndex()).getQualita());
						listTracceIn.setModel(dlm);
						tracce.add(tracce2.get(listTracceNew.getSelectedIndex()));
					}
					else
					{
						JOptionPane.showMessageDialog(btnRimuovi, "Traccia già inserita");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnRimuovi, "Scegliere una traccia");
				}
			}
		});
		btnAggiungi.setForeground(Color.BLACK);
		btnAggiungi.setFont(new Font("Arial", Font.BOLD, 26));
		btnAggiungi.setBackground(new Color(0, 128, 0));
		btnAggiungi.setBounds(624, 451, 154, 37);
		
		contentPane.add(btnAggiungi);
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!ricercaField.getText().equals(""))
				{
					tracce2 = controller.takeTraccia("Select * from traccia where titolo = '" + ricercaField.getText() + "'");
					DefaultListModel dlm2 = new DefaultListModel();
					int i; 
					
					if(tracce2.size() != 0)
					{
						for(i = 0; i < tracce2.size(); i++)
						{
							dlm2.addElement(""+ tracce2.get(i).getTitolo() + ", " + tracce2.get(i).getFormato() + ", " + tracce2.get(i).getQualita());
						}
						
						listTracceNew.setModel(dlm2);
						btnAggiungi.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(btnCerca, "Nessuna traccia con il titolo inserito");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(btnCerca, "Scrivere il titolo di una traccia");
				}
			}
		});
		btnCerca.setForeground(Color.BLACK);
		btnCerca.setFont(new Font("Arial", Font.BOLD, 26));
		btnCerca.setBackground(new Color(0, 128, 0));
		btnCerca.setBounds(624, 395, 154, 37);
		
		contentPane.add(btnCerca);
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTitolo.setBounds(10, 86, 165, 37);
		
		contentPane.add(lblTitolo);
		titoloField.setText((String) null);
		titoloField.setFont(new Font("Arial", Font.PLAIN, 22));
		titoloField.setEditable(false);
		titoloField.setColumns(10);
		titoloField.setBounds(10, 121, 215, 45);
		
		contentPane.add(titoloField);
		btnTornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indietro.setVisible(true);
				System.out.println("Stai tornando Indietro");
				dettagliPlaylist.dispose();
			}
		});
		btnTornaIndietro.setForeground(Color.BLACK);
		btnTornaIndietro.setFont(new Font("Arial", Font.BOLD, 26));
		btnTornaIndietro.setBackground(new Color(255, 69, 0));
		btnTornaIndietro.setBounds(792, 69, 249, 37);
		
		contentPane.add(btnTornaIndietro);
		btnCreaNuovaPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nuovo1 = true;
				setNuovo();
			}
		});
		
		btnCreaNuovaPlaylist.setForeground(Color.BLACK);
		btnCreaNuovaPlaylist.setFont(new Font("Arial", Font.BOLD, 26));
		btnCreaNuovaPlaylist.setBackground(new Color(0, 128, 0));
		btnCreaNuovaPlaylist.setBounds(759, 560, 282, 37);
		contentPane.add(btnCreaNuovaPlaylist);
		
		if(nuovo1)
		{
			setNuovo();
		}
		else
		{
			setValue(playlist, controller, flag);
		}
		
	}
	
	private void setValue(Playlist playlist, Controller controller, boolean flag)
	{
		int i;
		tracce = controller.takeTraccia("Select * from traccia, contiene where traccia.codt = contiene.codt and contiene.codp = '" + playlist.getCodP() +"';");
		
		lblHome.setText(playlist.getTitolo());
		proprietarioField.setText(playlist.getUtente().getNickname());
		durataField.setText(playlist.getDurata().toString());
		nTracceField.setText("" + playlist.getNtracce());
		titoloField.setText("" + playlist.getTitolo());
		if(playlist.getVisibilita())
		{
			boxPubblica.setSelected(true);
		}
		else
		{
			boxPrivata.setSelected(true);
		}
		
		for(i = 0; i < tracce.size(); i++)
		{
			dlm.addElement(""+ tracce.get(i).getTitolo() + ", " + tracce.get(i).getFormato() + ", " + tracce.get(i).getQualita());
		}
		
		btnEliminaPlaylist.setVisible(flag);
		btnModifica.setVisible(flag);
		btnSi.setVisible(false);
		btnNo.setVisible(false);
		lblSeiSicuro.setVisible(false);
		btnConferma.setVisible(false);
		lblScegliTracciaDa.setVisible(false);
		btnAggiungi.setVisible(false);
		btnRimuovi.setVisible(false);
		listTracceNew.setVisible(false);
		scrollPane_1.setVisible(false);
		btnCerca.setVisible(false);
		ricercaField.setVisible(false);
		listTracceIn.setModel(dlm);
		btnCreaNuovaPlaylist.setVisible(flag);
	}
	
	private void setNuovo()
	{
		int i;
		
		titoloField.setEditable(true);
		boxPubblica.setEnabled(true);
		boxPrivata.setEnabled(true);
		boxPrivata.setSelected(true);
		btnRimuovi.setVisible(true);
		btnCerca.setVisible(true);
		lblScegliTracciaDa.setVisible(true);
		listTracceNew.setVisible(true);
		scrollPane_1.setVisible(true);
		ricercaField.setVisible(true);
		btnConferma.setVisible(true);
		btnDettagli.setVisible(false);
		btnEliminaPlaylist.setVisible(false);
		btnModifica.setVisible(false);
		lblSeiSicuro.setVisible(false);
		btnSi.setVisible(false);
		btnNo.setVisible(false);
		btnAggiungi.setVisible(false);
		btnCreaNuovaPlaylist.setVisible(false);
		
		dlm.removeAllElements();
		
		tracce.removeAll(tracce);		
		
		listTracceIn.setModel(dlm);
		titoloField.setText("");
		durataField.setText("");
		nTracceField.setText("");
	}
}
