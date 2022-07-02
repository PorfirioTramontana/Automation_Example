package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Playlist;
import Model.Utente;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DettagliUtente extends JFrame {

	private JPanel contentPane;
	private JFrame dettagliUtente;
	private JList list = new JList();
	private DefaultListModel dlm = new DefaultListModel();
	private ArrayList<Playlist> playlist;
	

	
	public DettagliUtente(JFrame home, Utente utente, Controller controller)
	{
		home.setVisible(false);
		dettagliUtente=this;
		dettagliUtente.setVisible(true);
		System.out.println("Mi trovo in DettagliUtente");
		
		setValori(controller,utente);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		JLabel lblMyUtente = new JLabel("Profilo di "+utente.getNickname());
		lblMyUtente.setHorizontalAlignment(SwingConstants.LEFT);
		lblMyUtente.setForeground(new Color(34, 139, 34));
		lblMyUtente.setFont(new Font("Arial", Font.PLAIN, 50));
		lblMyUtente.setBounds(10, 10, 647, 54);
		contentPane.add(lblMyUtente);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setFont(new Font("Arial", Font.PLAIN, 26));
		lblDescrizione.setBounds(10, 87, 144, 37);
		contentPane.add(lblDescrizione);
		
		JEditorPane descrizione = new JEditorPane();
		descrizione.setFont(new Font("Arial", Font.PLAIN, 22));
		descrizione.setEditable(false);
		descrizione.setBounds(10, 144, 225, 187);
		contentPane.add(descrizione);
		
		JLabel lblListaPlaylist = new JLabel("Lista Playlsit di "+utente.getNickname()+":");
		lblListaPlaylist.setFont(new Font("Arial", Font.PLAIN, 22));
		lblListaPlaylist.setBounds(316, 74, 293, 54);
		contentPane.add(lblListaPlaylist);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 144, 367, 192);
		contentPane.add(scrollPane);
		list.setFont(new Font("Arial", Font.PLAIN, 22));
		
		scrollPane.setViewportView(list);
		
		JButton btnDettagli = new JButton("Dettagli");
		btnDettagli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedIndex() != -1)
				{
					DettagliPlaylist dettagliPlaylist= new DettagliPlaylist(home,playlist.get(list.getSelectedIndex()),controller,false,utente,false,dettagliUtente);
					
				}
			}
		});
		btnDettagli.setFont(new Font("Arial", Font.PLAIN, 22));
		btnDettagli.setBounds(326, 340, 154, 37);
		btnDettagli.setBackground(new Color(244, 164, 96));
		btnDettagli.setForeground(Color.BLACK);
		contentPane.add(btnDettagli);
		
		JButton btnHome = new JButton("Torna in home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.setVisible(true);
				dettagliUtente.dispose();
				System.out.println("Sto tornando in home (da dettagli Utente)");
			}
		});
		btnHome.setForeground(Color.BLACK);
		btnHome.setFont(new Font("Arial", Font.BOLD, 26));
		btnHome.setBackground(Color.RED);
		btnHome.setBounds(794, 47, 249, 37);
		contentPane.add(btnHome);
		
		if(playlist.size() == 0) {
			btnDettagli.setVisible(false);
		}
		
		if(utente.getDescrizione() !=  null)
		{
			descrizione.setText(utente.getDescrizione());
		}
		else {
			descrizione.setFont(new Font("Arial", Font.ITALIC, 22));
			descrizione.setText("Nessuna descrizione presente");
			}
	}
	
	private void setValori(Controller controller,Utente utente)
	{
		playlist= controller.takePlaylist("SELECT * FROM PLAYLIST WHERE NICKNAME= '"+utente.getNickname()+"' AND VISIBILITA = TRUE;");
		int i;
		
		for(i=0;i<playlist.size();i++)
		{
			dlm.addElement(""+playlist.get(i).getTitolo());
		}
		list.setModel(dlm);
		
	}
}

