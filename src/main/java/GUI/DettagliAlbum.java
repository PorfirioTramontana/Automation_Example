package GUI;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Album;
import Model.Artista;
import Model.Traccia;
import Model.Utente;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DettagliAlbum extends JFrame {

	private JPanel contentPane;
	private JFrame dettagliAlbum;
	private JTextField titoloField;
	private JTextField annoUField;
	private JTextField durataField;
	private JTextField etichettaField;
	private JTextField votoField;
	private JTextField nTracceField;
	
	public DettagliAlbum(JFrame home, Controller controller, Album album, JFrame indietro, Utente utente) 
	{
		home.setVisible(false);
		dettagliAlbum = this;
		dettagliAlbum.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		JLabel lblHome = new JLabel(album.getTitolo());
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setForeground(new Color(34, 139, 34));
		lblHome.setFont(new Font("Arial", Font.PLAIN, 50));
		lblHome.setBounds(10, 11, 466, 54);
		contentPane.add(lblHome);
		
		JLabel lblTitolo = new JLabel("Titolo:");
		lblTitolo.setForeground(new Color(0, 0, 205));
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTitolo.setBounds(10, 77, 99, 37);
		contentPane.add(lblTitolo);
		
		titoloField = new JTextField(album.getTitolo());
		titoloField.setFont(new Font("Arial", Font.PLAIN, 22));
		titoloField.setEditable(false);
		titoloField.setColumns(10);
		titoloField.setBounds(10, 117, 307, 45);
		contentPane.add(titoloField);
		
		JLabel lblAnnoDiUscita = new JLabel("Anno di uscita:");
		lblAnnoDiUscita.setForeground(new Color(0, 0, 205));
		lblAnnoDiUscita.setFont(new Font("Arial", Font.PLAIN, 28));
		lblAnnoDiUscita.setBounds(10, 173, 185, 37);
		contentPane.add(lblAnnoDiUscita);
		
		annoUField = new JTextField("" + album.getAnnoU());
		annoUField.setFont(new Font("Arial", Font.PLAIN, 22));
		annoUField.setEditable(false);
		annoUField.setColumns(10);
		annoUField.setBounds(10, 206, 307, 45);
		contentPane.add(annoUField);
		
		JLabel lblDurata = new JLabel("Durata:");
		lblDurata.setForeground(new Color(0, 0, 205));
		lblDurata.setFont(new Font("Arial", Font.PLAIN, 28));
		lblDurata.setBounds(10, 262, 99, 37);
		contentPane.add(lblDurata);
		
		durataField = new JTextField(album.getDurata().toString());
		durataField.setFont(new Font("Arial", Font.PLAIN, 22));
		durataField.setEditable(false);
		durataField.setColumns(10);
		durataField.setBounds(10, 296, 307, 45);
		contentPane.add(durataField);
		
		JLabel lblEtichetta = new JLabel("Etichetta:");
		lblEtichetta.setForeground(new Color(0, 0, 205));
		lblEtichetta.setFont(new Font("Arial", Font.PLAIN, 28));
		lblEtichetta.setBounds(10, 350, 151, 37);
		contentPane.add(lblEtichetta);
		
		etichettaField = new JTextField();
		etichettaField.setFont(new Font("Arial", Font.PLAIN, 22));
		etichettaField.setEditable(false);
		etichettaField.setColumns(10);
		etichettaField.setBounds(10, 398, 307, 45);
		contentPane.add(etichettaField);
		if(album.getEtichetta() == null)
		{
			etichettaField.setText("Nessuna etichetta");
		}
		else
		{
			etichettaField.setText(album.getEtichetta());
		}
		
		JLabel lblTitolo_1_2 = new JLabel("Voto:");
		lblTitolo_1_2.setForeground(new Color(0, 0, 205));
		lblTitolo_1_2.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTitolo_1_2.setBounds(10, 455, 99, 37);
		contentPane.add(lblTitolo_1_2);
		
		votoField = new JTextField("" + album.getVoto());
		votoField.setFont(new Font("Arial", Font.PLAIN, 22));
		votoField.setEditable(false);
		votoField.setColumns(10);
		votoField.setBounds(10, 490, 56, 45);
		contentPane.add(votoField);
		
		JLabel lblTitolo_1_1 = new JLabel("N Tracce:");
		lblTitolo_1_1.setForeground(new Color(0, 0, 205));
		lblTitolo_1_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTitolo_1_1.setBounds(133, 455, 131, 37);
		contentPane.add(lblTitolo_1_1);
		
		nTracceField = new JTextField("" + album.getNtracce());
		nTracceField.setFont(new Font("Arial", Font.PLAIN, 22));
		nTracceField.setEditable(false);
		nTracceField.setColumns(10);
		nTracceField.setBounds(133, 490, 99, 45);
		contentPane.add(nTracceField);
		
		JLabel lblTracceContenute = new JLabel("Tracce contenute:");
		lblTracceContenute.setForeground(new Color(0, 0, 205));
		lblTracceContenute.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTracceContenute.setBounds(377, 76, 258, 37);
		contentPane.add(lblTracceContenute);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 113, 291, 228);
		contentPane.add(scrollPane);
		
		JList listTracce = new JList();
		listTracce.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane.setViewportView(listTracce);
		
		JLabel lblTracceContenute_1 = new JLabel("Artisti:");
		lblTracceContenute_1.setForeground(new Color(0, 0, 205));
		lblTracceContenute_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTracceContenute_1.setBounds(377, 350, 258, 37);
		contentPane.add(lblTracceContenute_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(377, 398, 291, 126);
		contentPane.add(scrollPane_1);
		
		JList listArtisti = new JList();
		listArtisti.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane_1.setViewportView(listArtisti);
		
		DefaultListModel dlm;
		dlm = setDlm(album.getTracce());
		DefaultListModel dlm2;
		dlm2 = setDlm2(album.getArtisti());
		listTracce.setModel(dlm);
		listArtisti.setModel(dlm2);
		
		JButton btnTornaHome = new JButton("Torna ad home");
		btnTornaHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.setVisible(true);
				System.out.println("Ti trovi in home");
				dettagliAlbum.dispose();
			}
		});
		btnTornaHome.setForeground(Color.BLACK);
		btnTornaHome.setFont(new Font("Arial", Font.BOLD, 26));
		btnTornaHome.setBackground(Color.RED);
		btnTornaHome.setBounds(762, 11, 279, 37);
		contentPane.add(btnTornaHome);
		
		JButton btnTornaIndietro = new JButton("Torna indietro");
		btnTornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indietro.setVisible(true);
				System.out.println("Stai tornando indietro");
				dettagliAlbum.dispose();
			}
		});
		btnTornaIndietro.setForeground(Color.BLACK);
		btnTornaIndietro.setFont(new Font("Arial", Font.BOLD, 26));
		btnTornaIndietro.setBackground(Color.RED);
		btnTornaIndietro.setBounds(762, 59, 279, 37);
		contentPane.add(btnTornaIndietro);
		
		JButton btnVisualizzaArtista = new JButton("Visualizza artista");
		btnVisualizzaArtista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listArtisti.getSelectedIndex() != -1)
				{
					DettagliArtista da = new DettagliArtista(home, controller, album.getArtisti().get(listArtisti.getSelectedIndex()), dettagliAlbum, utente);
				}
				else
				{
					JOptionPane.showMessageDialog(btnVisualizzaArtista, "Scegliere un artista");
				}
			}
		});
		btnVisualizzaArtista.setForeground(Color.BLACK);
		btnVisualizzaArtista.setFont(new Font("Arial", Font.BOLD, 26));
		btnVisualizzaArtista.setBackground(new Color(244, 164, 96));
		btnVisualizzaArtista.setBounds(678, 443, 251, 37);
		contentPane.add(btnVisualizzaArtista);
		
		JButton btnVisualizzaTraccia = new JButton("Visualizza traccia");
		btnVisualizzaTraccia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listTracce.getSelectedIndex() != -1)
				{
					DettagliTraccia dettagliTraccia = new DettagliTraccia(home,album.getTracce().get(listTracce.getSelectedIndex()), controller, dettagliAlbum, utente);
				}
				else
				{
					JOptionPane.showMessageDialog(btnVisualizzaTraccia, "Scegliere una traccia");
				}
			}
		});
		btnVisualizzaTraccia.setForeground(Color.BLACK);
		btnVisualizzaTraccia.setFont(new Font("Arial", Font.BOLD, 26));
		btnVisualizzaTraccia.setBackground(new Color(244, 164, 96));
		btnVisualizzaTraccia.setBounds(678, 206, 251, 37);
		contentPane.add(btnVisualizzaTraccia);
		
		if(indietro == null)
		{
			btnTornaIndietro.setVisible(false);
		}
		else
		{
			indietro.setVisible(false);
		}
	}
	
	private DefaultListModel setDlm(ArrayList<Traccia> tracce)
	{
		DefaultListModel dlm = new DefaultListModel();
		int i;
		
		for(i = 0; i < tracce.size(); i++)
		{
			dlm.addElement("" + tracce.get(i).getTitolo() + ", " + tracce.get(i).getFormato() +", " + tracce.get(i).getQualita());
		}
		
		return dlm;
	}
	
	private DefaultListModel setDlm2(ArrayList<Artista> artisti)
	{
		DefaultListModel dlm = new DefaultListModel();
		int i;
		
		for(i = 0; i < artisti.size(); i++)
		{
			dlm.addElement(artisti.get(i).getNomearte());
		}
		
		return dlm;
	}
}
