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
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import Model.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField ricercaField;
	private ArrayList<Traccia> tracce;
	private ArrayList<Album> album;
	private ArrayList<Utente> utenti;
	private ArrayList<Playlist> playlist;
	private ArrayList<Artista> artisti;
	private JFrame home;
	private JButton btnAscolta = new JButton("Ascolta");
	private JButton btnVota = new JButton("Vota");
	private JButton btnDettagli = new JButton("Dettagli");
	private DefaultListModel mdl = new DefaultListModel();
	private boolean btnAlbum = false;
	private boolean btnTraccia = false;
	private JScrollPane scrollPane = new JScrollPane();
	private JList list = new JList();
	private JRadioButton rb1 = new JRadioButton("1");
	private JRadioButton rb2 = new JRadioButton("2");
	private JRadioButton rb3 = new JRadioButton("3");
	private JRadioButton rb4 = new JRadioButton("4");
	private JRadioButton rb5 = new JRadioButton("5");	
	private JRadioButton rb6 = new JRadioButton("6");
	private JRadioButton rb7 = new JRadioButton("7");
	private JRadioButton rb8 = new JRadioButton("8");
	private JRadioButton rb9 = new JRadioButton("9");
	private JRadioButton rb10 = new JRadioButton("10");
	private JLabel lblInserisciVoto = new JLabel("Inserisci voto:");
	private ButtonGroup group = new ButtonGroup();
	private JButton btnCercaTracce = new JButton("Cerca Tracce");
	private boolean btnUtenti = false;
	private boolean btnPlaylist = false;
	private boolean btnArtista = false;
	
	public Home(JFrame login, Utente utente, Controller controller) 
	{
		login.setVisible(false);
		home = this;
		home.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		JLabel lblRicerca = new JLabel("Ricerca:");
		lblRicerca.setFont(new Font("Arial", Font.PLAIN, 26));
		lblRicerca.setBounds(10, 192, 99, 37);
		contentPane.add(lblRicerca);
		
		ricercaField = new JTextField();
		ricercaField.setFont(new Font("Arial", Font.PLAIN, 22));
		ricercaField.setColumns(10);
		ricercaField.setBounds(10, 225, 453, 45);
		contentPane.add(ricercaField);
		
		scrollPane.setBounds(494, 225, 529, 238);
		contentPane.add(scrollPane);
		
		list.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane.setViewportView(list);
		list.setVisible(false);
		
		JButton btnCercaAlbum = new JButton("Cerca Album");
		btnCercaAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ricercaField.getText().equals(""))
				{
					album=controller.takeAlbum("SELECT * FROM ALBUM WHERE CODA<>0", true);
				}
				else
				{
				album = controller.takeAlbum("select * from album where titolo = '" + ricercaField.getText() + "'", true);
				}
				if(album.size() != 0)
				{
					int i;
					btnAlbum = true;
					btnTraccia = false;
					btnUtenti = false;
					btnPlaylist =false;
					btnArtista = false;
					
					mdl.removeAllElements();
					for(i = 0; i < album.size(); i++)
					{
						mdl.addElement("" + album.get(i).getTitolo() + ", " + album.get(i).getAnnoU());
					}
					
					list.setModel(mdl);
					setVisibilita(false);
					list.setVisible(true);
					scrollPane.setVisible(true);
					btnDettagli.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(btnCercaAlbum, "Non esistono album con il titolo inserito");
				}
			}
		});
		btnCercaAlbum.setForeground(Color.BLACK);
		btnCercaAlbum.setFont(new Font("Arial", Font.BOLD, 26));
		btnCercaAlbum.setBackground(new Color(176, 196, 222));
		btnCercaAlbum.setBounds(10, 344, 314, 37);
		contentPane.add(btnCercaAlbum);
		
		JButton btnCercaArtisti = new JButton("Cerca Artisti");
		btnCercaArtisti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ricercaField.getText().equals("")) 
				{
					artisti=controller.takeArtisti("SELECT * FROM ARTISTA ;");
				}
				else
				{
				artisti=controller.takeArtisti("SELECT * FROM ARTISTA WHERE NomeArte= '"+ricercaField.getText()+"' ;");
				}
				if(artisti.size() !=0 )
				{
					setVisibilita(false);
					btnDettagli.setVisible(true);
					list.setVisible(true);
					scrollPane.setVisible(true);
					btnUtenti = false;
					btnAlbum = false;
					btnTraccia = false;
					btnPlaylist = false;
					btnArtista = true;
					
					mdl.removeAllElements();
					int i;
					for(i = 0; i < artisti.size(); i++)
					{
						mdl.addElement(artisti.get(i).getNomearte());
					}
					list.setModel(mdl);
				}
				else {JOptionPane.showMessageDialog(btnAscolta, "Non esistono Artisti con il Nome inserito");}
				
			}
		});
		btnCercaArtisti.setForeground(Color.BLACK);
		btnCercaArtisti.setFont(new Font("Arial", Font.BOLD, 26));
		btnCercaArtisti.setBackground(new Color(176, 196, 222));
		btnCercaArtisti.setBounds(10, 392, 314, 37);
		contentPane.add(btnCercaArtisti);
		
		JButton btnCercaPlaylist = new JButton("Cerca Playlist");
		btnCercaPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ricercaField.getText().equals(""))
				{
					playlist=controller.takePlaylist("SELECT * FROM PLAYLIST ;");
				}
				else 
				{
				playlist= controller.takePlaylist("SELECT * FROM PLAYLIST WHERE visibilita = true and Titolo = '"+ricercaField.getText()+"';");
				}
				if(playlist.size() != 0)
				{
					setVisibilita(false);
					btnDettagli.setVisible(true);
					list.setVisible(true);
					scrollPane.setVisible(true);
					btnUtenti = false;
					btnAlbum = false;
					btnTraccia = false;
					btnPlaylist = true;
					btnArtista = false;
					
					mdl.removeAllElements();
					int i;
					for(i = 0; i < playlist.size(); i++)
					{
						mdl.addElement(""+playlist.get(i).getTitolo()+", "+playlist.get(i).getUtente().getNickname());
					}
					list.setModel(mdl);
				}
				
				else {JOptionPane.showMessageDialog(btnAscolta, "Non esistono Playlist con il Titolo inserito");}
				
			}
		});
		btnCercaPlaylist.setForeground(Color.BLACK);
		btnCercaPlaylist.setFont(new Font("Arial", Font.BOLD, 26));
		btnCercaPlaylist.setBackground(new Color(176, 196, 222));
		btnCercaPlaylist.setBounds(10, 440, 314, 37);
		contentPane.add(btnCercaPlaylist);
		
		JButton btnCercaUtenti = new JButton("Cerca Utenti");
		btnCercaUtenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ricercaField.getText().equals(""))
				{
					utenti=controller.showUtenti("SELECT * FROM UTENTE ;");
				}
				else
				{
				utenti = controller.takeUtente(ricercaField.getText());
				}
				if(utenti.size() != 0)
				{
					setVisibilita(false);
					btnDettagli.setVisible(true);
					list.setVisible(true);
					scrollPane.setVisible(true);
					btnUtenti = true;
					btnAlbum = false;
					btnTraccia = false;
					btnPlaylist= false;
					btnArtista = false;
					
					mdl.removeAllElements();
					int i;
					for(i = 0; i < utenti.size(); i++)
					{
						mdl.addElement(utenti.get(i).getNickname());
					}
					list.setModel(mdl);
				}
				else
				{
					JOptionPane.showMessageDialog(btnAscolta, "Non esistono utenti con il NickName inserito");
				}
			}
		});
		btnCercaUtenti.setForeground(Color.BLACK);
		btnCercaUtenti.setFont(new Font("Arial", Font.BOLD, 26));
		btnCercaUtenti.setBackground(new Color(176, 196, 222));
		btnCercaUtenti.setBounds(10, 488, 314, 37);
		contentPane.add(btnCercaUtenti);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setForeground(new Color(34, 139, 34));
		lblHome.setFont(new Font("Arial", Font.PLAIN, 50));
		lblHome.setBounds(20, 11, 273, 54);
		contentPane.add(lblHome);
		
		JLabel lblHome_1 = new JLabel("Benvenuto " + utente.getNickname());
		lblHome_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome_1.setForeground(Color.BLACK);
		lblHome_1.setFont(new Font("Arial", Font.PLAIN, 38));
		lblHome_1.setBounds(20, 90, 701, 54);
		contentPane.add(lblHome_1);
		
		JButton btnLeMiePlaylist = new JButton("Le mie Playlist");
		btnLeMiePlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playlist = controller.takePlaylist("SELECT * FROM PLAYLIST WHERE NickName = '"+utente.getNickname()+"';");
				
				if(playlist.size() != 0)
				{
					setVisibilita(false);
					btnDettagli.setVisible(true);
					list.setVisible(true);
					scrollPane.setVisible(true);
					btnUtenti = false;
					btnAlbum = false;
					btnTraccia = false;
					btnPlaylist = true;
					btnArtista = false;
					
					mdl.removeAllElements();
					int i;
					for(i = 0; i < playlist.size(); i++)
					{
						mdl.addElement(""+playlist.get(i).getTitolo()+", "+playlist.get(i).getUtente().getNickname());
					}
					list.setModel(mdl);
				}
				
				else
				{
					JOptionPane.showMessageDialog(btnAscolta, "Non hai creato nessuna playlist, verrai reindirizzato nella pagina per la creazione di una playlist");
					DettagliPlaylist dettagliPlaylist = new DettagliPlaylist(home, null, controller, true, utente, true,null);
				}
				
				
			}
		});
		btnLeMiePlaylist.setForeground(Color.BLACK);
		btnLeMiePlaylist.setFont(new Font("Arial", Font.BOLD, 26));
		btnLeMiePlaylist.setBackground(new Color(240, 230, 140));
		btnLeMiePlaylist.setBounds(727, 28, 314, 37);
		contentPane.add(btnLeMiePlaylist);
		
		JButton btnEsciDallaccount = new JButton("Esci dall'account");
		btnEsciDallaccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login.setVisible(true);
				System.out.println("Ti trovi in login");
				home.dispose();
			}
		});
		btnEsciDallaccount.setForeground(Color.BLACK);
		btnEsciDallaccount.setFont(new Font("Arial", Font.BOLD, 26));
		btnEsciDallaccount.setBackground(Color.RED);
		btnEsciDallaccount.setBounds(727, 124, 314, 37);
		contentPane.add(btnEsciDallaccount);
		
		JButton btnIlMioProfilo = new JButton("Il mio profilo");
		btnIlMioProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyUtente myUtente = new MyUtente(home, utente, controller, true, login);
				setVisibilita(false);
			}
		});
		btnIlMioProfilo.setForeground(Color.BLACK);
		btnIlMioProfilo.setFont(new Font("Arial", Font.BOLD, 26));
		btnIlMioProfilo.setBackground(new Color(0, 128, 0));
		btnIlMioProfilo.setBounds(727, 76, 314, 37);
		contentPane.add(btnIlMioProfilo);
		btnAscolta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedIndex() != -1)
				{
					try 
					{
				        java.awt.Desktop.getDesktop().browse(java.net.URI.create(tracce.get(list.getSelectedIndex()).getLink()));
				    } catch (java.io.IOException e1) {
				        System.out.println(e1.getMessage());
				    }
					
					int esito = controller.insertAscolto(tracce.get(list.getSelectedIndex()), utente, Calendar.getInstance());
					System.out.println(esito);
				}
				else
				{
					JOptionPane.showMessageDialog(btnAscolta, "Eseguire su una scelta");
				}
			}
		});
		
		btnAscolta.setForeground(Color.BLACK);
		btnAscolta.setFont(new Font("Arial", Font.BOLD, 26));
		btnAscolta.setBackground(new Color(244, 164, 96));
		btnAscolta.setBounds(685, 488, 154, 37);
		contentPane.add(btnAscolta);
		btnVota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedIndex() != -1)
				{
					int voto = -1;
					int esito;
					
					if(rb1.isSelected())
					{
						voto = 1;
					}
					else if(rb2.isSelected())
					{
						voto = 2;
					}
					else if(rb3.isSelected())
					{
						voto = 3;
					}
					else if(rb4.isSelected())
					{
						voto = 4;
					}
					else if(rb5.isSelected())
					{
						voto = 5;
					}
					else if(rb6.isSelected())
					{
						voto = 6;
					}
					else if(rb7.isSelected())
					{
						voto = 7;
					}
					else if(rb8.isSelected())
					{
						voto = 8;
					}
					else if(rb9.isSelected())
					{
						voto = 9;
					}
					else if(rb10.isSelected())
					{
						voto = 10;
					}
					
					if(voto != -1)
					{
						if(!controller.checkVoto("Select * from Vota where Nickname= '"+utente.getNickname()+"' AND codT="+tracce.get(list.getSelectedIndex()).getCodT()+";"))
						{
							esito = controller.insertVoto(utente, tracce.get(list.getSelectedIndex()), voto);
						
							System.out.println(esito);
						
							if(esito != 0)
							{
								cercaTraccia(controller, utente, tracce.get(0).getTitolo());
								System.out.println("inserimenti");
							}
						}
						else
						{
							esito=controller.updateVoto("UPDATE VOTA SET VOTO ="+voto+" WHERE NICKNAME='"+utente.getNickname()+"' AND CODT="+tracce.get(list.getSelectedIndex()).getCodT()+";");
							if(esito!=0)
							{
								cercaTraccia(controller, utente, tracce.get(0).getTitolo());
								System.out.println("aggiornamenti");
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(btnAscolta, "Scegliere un voto");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnAscolta, "Eseguire su una scelta");
				}
			}
		});
		
		btnVota.setForeground(Color.BLACK);
		btnVota.setFont(new Font("Arial", Font.BOLD, 26));
		btnVota.setBackground(new Color(244, 164, 96));
		btnVota.setBounds(869, 488, 154, 37);
		contentPane.add(btnVota);
		
		lblInserisciVoto.setFont(new Font("Arial", Font.PLAIN, 26));
		lblInserisciVoto.setBounds(494, 543, 227, 37);
		contentPane.add(lblInserisciVoto);
		lblInserisciVoto.setVisible(false);
		
		rb1.setFont(new Font("Arial", Font.PLAIN, 26));
		rb1.setBackground(new Color(224, 255, 255));
		rb1.setBounds(494, 587, 44, 34);
		contentPane.add(rb1);
		
		rb2.setFont(new Font("Arial", Font.PLAIN, 26));
		rb2.setBackground(new Color(224, 255, 255));
		rb2.setBounds(540, 587, 44, 34);
		contentPane.add(rb2);
		
		rb3.setFont(new Font("Arial", Font.PLAIN, 26));
		rb3.setBackground(new Color(224, 255, 255));
		rb3.setBounds(586, 587, 44, 34);
		contentPane.add(rb3);
		
		rb4.setFont(new Font("Arial", Font.PLAIN, 26));
		rb4.setBackground(new Color(224, 255, 255));
		rb4.setBounds(632, 587, 44, 34);
		contentPane.add(rb4);
		
		rb5.setFont(new Font("Arial", Font.PLAIN, 26));
		rb5.setBackground(new Color(224, 255, 255));
		rb5.setBounds(685, 587, 44, 34);
		contentPane.add(rb5);
		
		rb6.setFont(new Font("Arial", Font.PLAIN, 26));
		rb6.setBackground(new Color(224, 255, 255));
		rb6.setBounds(727, 587, 44, 34);
		contentPane.add(rb6);
		
		rb7.setFont(new Font("Arial", Font.PLAIN, 26));
		rb7.setBackground(new Color(224, 255, 255));
		rb7.setBounds(773, 587, 44, 34);
		contentPane.add(rb7);
		rb7.setVisible(false);
		
		rb8.setFont(new Font("Arial", Font.PLAIN, 26));
		rb8.setBackground(new Color(224, 255, 255));
		rb8.setBounds(819, 587, 44, 34);
		contentPane.add(rb8);
		
		rb9.setFont(new Font("Arial", Font.PLAIN, 26));
		rb9.setBackground(new Color(224, 255, 255));
		rb9.setBounds(869, 587, 44, 34);
		contentPane.add(rb9);
		
		rb10.setFont(new Font("Arial", Font.PLAIN, 26));
		rb10.setBackground(new Color(224, 255, 255));
		rb10.setBounds(915, 587, 82, 34);
		contentPane.add(rb10);
		
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		group.add(rb4);
		group.add(rb5);
		group.add(rb6);
		group.add(rb7);
		group.add(rb8);
		group.add(rb9);
		group.add(rb10);
		
		btnCercaTracce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cercaTraccia(controller, utente, ricercaField.getText());
			}
		});
		btnCercaTracce.setForeground(Color.BLACK);
		btnCercaTracce.setFont(new Font("Arial", Font.BOLD, 26));
		btnCercaTracce.setBackground(new Color(176, 196, 222));
		btnCercaTracce.setBounds(10, 296, 314, 37);
		contentPane.add(btnCercaTracce);
		
		btnDettagli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedIndex() != -1)
				{
					if(btnTraccia)
					{
						DettagliTraccia dettagliTraccia = new DettagliTraccia(home, tracce.get(list.getSelectedIndex()), controller, null, utente);
						System.out.println("Ti trovi in dettagli traccia");
						
					}
					else if(btnAlbum)
					{
						DettagliAlbum dettagliAlbum = new DettagliAlbum(home, controller, album.get(list.getSelectedIndex()), null, utente);
						System.out.println("Ti trovi in dettagli Album");
					}
					else if(btnUtenti)
					{
						DettagliUtente dettagliUtente = new DettagliUtente(home, utenti.get(list.getSelectedIndex()), controller);
						System.out.println("Ti trovi in MyUtente");
					}
					else if(btnPlaylist)
					{
						boolean flag = false;
						
						if(playlist.get(list.getSelectedIndex()).getUtente().getNickname().equals(utente.getNickname()))
						{
							flag = true;
						}
						DettagliPlaylist dettagliPlaylist = new DettagliPlaylist(home, playlist.get(list.getSelectedIndex()), controller, flag, utente, false,null);
					}
					else
					{
						DettagliArtista dettagliArtista = new DettagliArtista(home,controller,artisti.get(list.getSelectedIndex()),null, utente);
					}
					
					ricercaField.setText("");
					setVisibilita(false);
				}
				else
				{
					JOptionPane.showMessageDialog(btnCercaTracce, "Cliccare su una scelta");
				}
			}
		});
		
		btnDettagli.setForeground(Color.BLACK);
		btnDettagli.setFont(new Font("Arial", Font.BOLD, 26));
		btnDettagli.setBackground(new Color(244, 164, 96));
		btnDettagli.setBounds(494, 488, 154, 37);
		contentPane.add(btnDettagli);
		
		setVisibilita(false);
	}
	
	private void setVisibilita(boolean flag)
	{
		btnDettagli.setVisible(flag);
		list.setVisible(flag);
		scrollPane.setVisible(flag);
		btnAscolta.setVisible(flag);
		btnVota.setVisible(flag);
		lblInserisciVoto.setVisible(flag);
		rb1.setVisible(flag);
		rb2.setVisible(flag);
		rb3.setVisible(flag);
		rb4.setVisible(flag);
		rb5.setVisible(flag);
		rb6.setVisible(flag);
		rb7.setVisible(flag);
		rb8.setVisible(flag);
		rb9.setVisible(flag);
		rb10.setVisible(flag);
	}
	
	private void cercaTraccia(Controller controller, Utente utente, String titolo)
	{
		if(titolo.equals("") && utente.getIsIspremium())
		{
			tracce=controller.takeTraccia("SELECT * FROM TRACCIA WHERE CODT<>0 ;");
			
		}
		else if(titolo.equals("") && !utente.getIsIspremium())
		{
			tracce=controller.takeTraccia("SELECT * FROM TRACCIA WHERE QUALITA=128 AND CODT<>0");
		}
		else
		{
			if(utente.getIsIspremium() || utente.getIsIsadmin())
			{
				tracce = controller.takeTraccia("SELECT * FROM TRACCIA WHERE TITOLO = '"+ titolo + "'");
			}
			else
			{
				tracce = controller.takeTraccia("SELECT * FROM TRACCIA WHERE TITOLO = '"+ titolo + "' AND qualita = 128;");
			
			}
		}
		System.out.println(tracce.size());
		if(tracce.size() != 0)
		{
			if(utente.getIsIspremium() || utente.getIsIsadmin())
			{
			setVisibilita(true);
			}
		
			btnDettagli.setVisible(true);
			btnAscolta.setVisible(true);
			scrollPane.setVisible(true);
			list.setVisible(true);
			btnAlbum = false;
			btnTraccia = true;
			btnUtenti = false;
			btnPlaylist = false;
			btnArtista = false;
			
			
			int i;
			mdl.removeAllElements();
			for(i = 0; i < tracce.size(); i++)
			{
				mdl.addElement(""+ tracce.get(i).getTitolo() + ", " + tracce.get(i).getFormato() + ", " + tracce.get(i).getQualita());
			}
			
			list.setModel(mdl);
		}
		else
		{
			JOptionPane.showMessageDialog(btnCercaTracce, "Non esistono tracce con il titolo inserito");
		}
		
	}
}
